package us.pollapp.inturik.businesslogic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import us.pollapp.inturik.dao.IPollasDAO;
import us.pollapp.inturik.dao.IPollasUserDAO;
import us.pollapp.inturik.dao.PollasDAO;
import us.pollapp.inturik.dao.PollasUserDAO;
import us.pollapp.inturik.model.Pollas;
import us.pollapp.inturik.model.PollasUser;
import us.pollapp.inturik.model.User;

public class LPolla {

	/**
	 * Crea una nueva polla
	 * 
	 * @param name
	 *            Nombre de la polla
	 * @param createdDate
	 *            Fecha Creaci�n
	 * @return Id de la polla creada
	 * @throws Exception
	 */
	public int addPolla(String name, Date createdDate, int idUser)
			throws Exception {

		try {

			// TODO: validaciones
			IPollasDAO objPollasDAO = new PollasDAO();

			Pollas objPollas = new Pollas();

			objPollas.setNombre(name);
			objPollas.setCreatedDate(new Timestamp(createdDate.getTime()));
			objPollas.setIdUserAdmin(idUser);

			objPollasDAO.save(objPollas);

			return objPollas.getId();

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Adiciona un usuario a la polla
	 * 
	 * @param idUser
	 *            Usuario
	 * @param idPolla
	 *            Polla
	 * @param isAdmin
	 *            Si es administrador
	 * @throws Exception
	 */
	public void addUserPolla(int idUser, int idPolla, boolean isAdmin)
			throws Exception {

		try {

			// TODO: validaciones

			User objUser = new User();
			objUser.setId(idUser);

			Pollas objPollas = new Pollas();
			objPollas.setId(idPolla);

			PollasUser objPollasUser = new PollasUser();
			objPollasUser.setUser(objUser);
			objPollasUser.setPollas(objPollas);
			objPollasUser.setIsAdmin(isAdmin);

			IPollasUserDAO objPollasUserDAO = new PollasUserDAO();
			objPollasUserDAO.save(objPollasUser);

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene la polla por su identificador
	 * 
	 * @param idPolla
	 *            Identificador de la polla
	 * @return Polla
	 * @throws Exception
	 */
	public Pollas getPollaById(int idPolla) throws Exception {

		try {

			// TODO: validaciones

			IPollasDAO objPollasDAO = new PollasDAO();
			return objPollasDAO.findById(idPolla);

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene las pollas en las que participa el usuario
	 * 
	 * @param idUser
	 * @return
	 * @throws Exception
	 */
	public List<Pollas> getPollasByUser(int idUser) throws Exception {

		List<Pollas> lstPollas = new ArrayList<>();

		try {

			// TODO: validaciones

			IPollasUserDAO objPollasUserDAO = new PollasUserDAO();
			List<PollasUser> lstPollasUser = objPollasUserDAO
					.findByUser(idUser);

			Pollas polla;

			for (PollasUser pollasUser : lstPollasUser) {
				polla = pollasUser.getPollas();
				polla.setIdUserAdmin(pollasUser.getIsAdmin() ? idUser : 0);
				lstPollas.add(polla);
			}

			return lstPollas;

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene el usuario administrador de una polla
	 * 
	 * @param idPolla
	 * @return Usuario administrador
	 * @throws Exception
	 */
	public User getUserAdminByPolla(int idPolla) throws Exception {

		User user = null;

		try {

			// TODO: validaciones

			IPollasUserDAO objPollasUserDAO = new PollasUserDAO();
			PollasUser objPollasUser = objPollasUserDAO
					.findAdminByPolla(idPolla);

			if (objPollasUser != null) {
				user = objPollasUser.getUser();
			}

			return user;

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene todos los usuarios que pertenecen a la polla
	 * 
	 * @param idPolla
	 * @return Lista de Usuarios
	 * @throws Exception
	 */
	public List<User> getUsersByPolla(int idPolla) throws Exception {

		List<User> lstUser = new ArrayList<>();

		try {

			// TODO: validaciones

			IPollasUserDAO objPollasUserDAO = new PollasUserDAO();
			List<PollasUser> lstPollasUser = objPollasUserDAO
					.findByPolla(idPolla);

			for (PollasUser pollasUser : lstPollasUser) {
				lstUser.add(pollasUser.getUser());
			}

			return lstUser;

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene todos los usuarios que pertenecen a la polla
	 * 
	 * @param idPolla
	 * @param idUser
	 * @param pointsMatch
	 * @throws Exception
	 */
	public void updateTotalScoresByUser(int idPolla, int idUser,
			int pointsMatchNew, int pointsMatchOld) throws Exception {

		try {

			// TODO: validaciones

			IPollasUserDAO objPollasUserDAO = new PollasUserDAO();
			List<PollasUser> lstPollasUser = objPollasUserDAO
					.findByPollaByUser(idPolla, idUser);

			int pointsOrig = 0;

			for (PollasUser pollasUser : lstPollasUser) {

				pointsOrig = pollasUser.getTotalScore();

				pointsOrig = pointsOrig - pointsMatchOld;

				pollasUser.setTotalScore(pointsOrig + pointsMatchNew);

				objPollasUserDAO.update(pollasUser);

			}

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene cada uno de los participantes de la polla con su puntaje total
	 * 
	 * @param idPolla
	 *            Identificador de la polla
	 * @return List<PollasUser>
	 * @throws Exception
	 */
	public List<PollasUser> getPollaUsersById(int idPolla) throws Exception {

		try {

			// TODO: validaciones

			IPollasUserDAO objPollasUserDAO = new PollasUserDAO();
			return objPollasUserDAO.findByPolla(idPolla);

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene las pollas con el mismo nombre creadas por un usuario
	 * 
	 * @param name
	 * @param idUser
	 * @return
	 * @throws Exception
	 */
	public List<Pollas> getPollaByNameByIdUser(String name, int idUser)
			throws Exception {

		try {

			// TODO: validaciones

			IPollasDAO objPollasDAO = new PollasDAO();
			return objPollasDAO.findByNameByIdUser(name.trim(), idUser);

		} catch (Exception e) {
			throw e;
		}

	}

}
