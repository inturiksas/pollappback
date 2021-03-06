package us.pollapp.inturik.businesslogic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

import us.pollapp.inturik.dao.EntityManagerHelper;
import us.pollapp.inturik.dao.IModelDAO;
import us.pollapp.inturik.dao.ModelDAO;
import us.pollapp.inturik.model.Model;
import us.pollapp.inturik.util.Constant;
import us.pollapp.inturik.util.Messages;

/**
 * @author Juan Guillermo G�mez Clase que permite gestionar las modelos pollapp
 * 
 */
public class LModels {

	private IModelDAO modelDAO;
	private static final Logger log = Logger.getLogger(LModels.class.getName());

	public LModels() {		
	}

	/*
	 * Permite obtener las modelos por identificador
	 */
	public List<Model> getModelById(List<Integer> lstIdModels) throws Exception {

		try {

			List<Model> lstModels = new ArrayList<>();
			Model model = null;
			modelDAO = new ModelDAO();

			for (Integer idModel : lstIdModels) {
				model = modelDAO.findById(idModel);
				lstModels.add(model);
			}

			return lstModels;

		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * Permite obtener las modelos por identificador
	 */
	public Model getModelById(int idModel) throws Exception {

		try {

			Model model = null;
			modelDAO = new ModelDAO();
			model = modelDAO.findById(idModel);
			return model;

		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * Permite obtener todas las modelos activas
	 */
	@SuppressWarnings("unchecked")
	public List<Model> getAllModelsActive(boolean newLoad) throws Exception {

		try {

			log.info("Se consultan todas las modelos activas");

			MemcacheService objCache = MemcacheServiceFactory
					.getMemcacheService();

			List<Model> lstModel = null;

			if (!objCache.contains(Constant.KEY_CACHE_MODELS) || newLoad) {

				modelDAO = new ModelDAO();
				
				log.info("Las modelos no se encuentran en cache. Se carga por primera vez");

				lstModel = modelDAO.findByActive(true);
				objCache.put(Constant.KEY_CACHE_MODELS, lstModel, Expiration
						.byDeltaSeconds(Constant.SECONDS_EXPIRATION_MODELS));
			} else {

				log.info("Se cargan las modelos desde cache");

				lstModel = (List<Model>) objCache
						.get(Constant.KEY_CACHE_MODELS);
			}

			return lstModel;

		} catch (Exception e) {
			log.severe(e.getMessage());
			throw e;
		}

	}

	/*
	 * Permite obtener todas las modelos activas paginando los datos
	 */
	public List<Model> getAllModelsActive(int pageNumber, int pageSize)
			throws Exception {

		try {

			log.info("Se consultan todas las modelos activas con paginaci�n");

			modelDAO = new ModelDAO();
			List<Model> lstModel = modelDAO.findAll(pageNumber, pageSize);
			return lstModel;

		} catch (Exception e) {
			log.severe(e.getMessage());
			throw e;
		}

	}

	/*
	 * Permite actualizar el score total de las modelos
	 */
	public int updateScoreModel(int idModel, int numberStar, int idUser)
			throws Exception {

		try {

			log.info("Se realiza una votaci�n a la modelo >> " + idModel);

			LBallot objLBallot = new LBallot();
			boolean userVote = objLBallot.isUserVote(idUser, idModel);

			modelDAO = new ModelDAO();
			Model model = modelDAO.findById(idModel);

			int score = model.getScore();

			if (!userVote) {

				log.info("Usuario que vota >> " + idUser);

				model.setScore(model.getScore()
						+ (numberStar * Constant.POINTS_STAR));

				score = model.getScore();

				try {

					EntityManagerHelper.beginTransaction();

					modelDAO.update(model);

					objLBallot.addScoreModel(idModel, idUser, score);
					
					getAllModelsActive(true);

					EntityManagerHelper.commit();

				} catch (Exception e) {
					EntityManagerHelper.rollback();
					throw e;
				}
			} else {
				log.info("Usuario ya voto >> " + idUser);
				throw new Exception(Messages.MSG_00005);
			}

			return score;

		} catch (Exception e) {
			log.severe(e.getMessage());
			throw e;
		}

	}


}
