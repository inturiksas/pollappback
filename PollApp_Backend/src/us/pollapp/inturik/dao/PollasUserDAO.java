package us.pollapp.inturik.dao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import us.pollapp.inturik.model.PollasUser;

/**
 * A data access object (DAO) providing persistence and search support for
 * PollasUser entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see .PollasUser
 * @author MyEclipse Persistence Tools
 */

public class PollasUserDAO implements IPollasUserDAO {
	// property constants
	public static final String ID_USER = "idUser";
	public static final String IDPOLLA = "idpolla";
	public static final String IS_ADMIN = "isAdmin";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved PollasUser entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PollasUserDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PollasUser entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(PollasUser entity) {
		EntityManagerHelper.log("saving PollasUser instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent PollasUser entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PollasUserDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            PollasUser entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(PollasUser entity) {
		EntityManagerHelper.log("deleting PollasUser instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(PollasUser.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved PollasUser entity and return it or a copy of
	 * it to the sender. A copy of the PollasUser entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = PollasUserDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PollasUser entity to update
	 * @return PollasUser the persisted PollasUser entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public PollasUser update(PollasUser entity) {
		EntityManagerHelper.log("updating PollasUser instance", Level.INFO,
				null);
		try {
			PollasUser result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public PollasUser findById(Integer id) {
		EntityManagerHelper.log("finding PollasUser instance with id: " + id,
				Level.INFO, null);
		try {
			PollasUser instance = getEntityManager().find(PollasUser.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all PollasUser entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the PollasUser property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<PollasUser> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<PollasUser> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding PollasUser instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from PollasUser model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<PollasUser> findByIsAdmin(Object isAdmin,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_ADMIN, isAdmin, rowStartIdxAndCount);
	}

	/**
	 * Find all PollasUser entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<PollasUser> all PollasUser entities
	 */
	@SuppressWarnings("unchecked")
	public List<PollasUser> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all PollasUser instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from PollasUser model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PollasUser> findByUser(int idUser) {
		EntityManagerHelper.log("finding PollasUser instance with idUser: "
				+ idUser, Level.INFO, null);
		try {
			final String queryString = "select model from PollasUser model where model.user.id= :propertyIdUser";

			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyIdUser", idUser);

			getEntityManager().getEntityManagerFactory().getCache().evictAll();

			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("findByUser failed", Level.SEVERE, re);
			throw re;
		}
	}

	public PollasUser findAdminByPolla(int idPolla) {
		EntityManagerHelper.log("finding Admin Pollas instance with idPolla: "
				+ idPolla, Level.INFO, null);
		try {
			final String queryString = "select model from PollasUser model where model.pollas.id= :propertyIdPolla And model.isAdmin = 1";

			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyIdPolla", idPolla);

			getEntityManager().getEntityManagerFactory().getCache().evictAll();

			return (PollasUser) query.getSingleResult();

		} catch (RuntimeException re) {
			EntityManagerHelper
					.log("findAdminByPolla failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PollasUser> findByPolla(int idPolla) {
		EntityManagerHelper.log("finding Pollas User with idPolla: " + idPolla,
				Level.INFO, null);
		try {
			final String queryString = "select model from PollasUser model where model.pollas.id= :propertyIdPolla order by model.totalScore desc";

			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyIdPolla", idPolla);

			getEntityManager().getEntityManagerFactory().getCache().evictAll();

			return query.getResultList();

		} catch (RuntimeException re) {
			EntityManagerHelper.log("findByPolla failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PollasUser> findByPollaByUser(int idPolla, int idUser) {

		EntityManagerHelper.log("finding Pollas User with idPolla: " + idPolla
				+ "And idUser: " + idUser, Level.INFO, null);

		try {

			final String queryString = "select model from PollasUser model where model.pollas.id= :propertyIdPolla And "
					+ "model.user.id= :propertyIdUser";

			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyIdPolla", idPolla);
			query.setParameter("propertyIdUser", idUser);

			getEntityManager().getEntityManagerFactory().getCache().evictAll();

			return query.getResultList();

		} catch (RuntimeException re) {
			EntityManagerHelper.log("findByPollaByUser failed", Level.SEVERE,
					re);
			throw re;
		}
	}

}