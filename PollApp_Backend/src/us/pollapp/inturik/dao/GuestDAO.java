package us.pollapp.inturik.dao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import us.pollapp.inturik.model.Guest;

/**
 * A data access object (DAO) providing persistence and search support for Guest
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see .Guest
 * @author MyEclipse Persistence Tools
 */

public class GuestDAO implements IGuestDAO {
	// property constants
	public static final String EMAIL = "email";
	public static final String INVITATION_SENT = "invitationSent";
	public static final String ACCEPTED = "accepted";
	public static final String IDPOLLA = "idpolla";
	public static final String ID_USER = "idUser";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Guest entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * GuestDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Guest entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Guest entity) {
		EntityManagerHelper.log("saving Guest instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Guest entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * GuestDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Guest entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Guest entity) {
		EntityManagerHelper.log("deleting Guest instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Guest.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Guest entity and return it or a copy of it to
	 * the sender. A copy of the Guest entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = GuestDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Guest entity to update
	 * @return Guest the persisted Guest entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Guest update(Guest entity) {
		EntityManagerHelper.log("updating Guest instance", Level.INFO, null);
		try {
			Guest result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Guest findById(Integer id) {
		EntityManagerHelper.log("finding Guest instance with id: " + id,
				Level.INFO, null);
		try {
			Guest instance = getEntityManager().find(Guest.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Guest entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Guest property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<Guest> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Guest> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding Guest instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Guest model where model."
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

	public List<Guest> findByEmail(Object email, int... rowStartIdxAndCount) {
		return findByProperty(EMAIL, email, rowStartIdxAndCount);
	}

	public List<Guest> findByInvitationSent(Object invitationSent,
			int... rowStartIdxAndCount) {
		return findByProperty(INVITATION_SENT, invitationSent,
				rowStartIdxAndCount);
	}

	public List<Guest> findByAccepted(Object accepted,
			int... rowStartIdxAndCount) {
		return findByProperty(ACCEPTED, accepted, rowStartIdxAndCount);
	}

	/**
	 * Find all Guest entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Guest> all Guest entities
	 */
	@SuppressWarnings("unchecked")
	public List<Guest> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper
				.log("finding all Guest instances", Level.INFO, null);
		try {
			final String queryString = "select model from Guest model";
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

	/**
	 * Obtiene la invitación por identificador de la polla e identificador
	 * usuario
	 * 
	 * @param idPolla
	 *            Identificador de la polla
	 * @param idUser
	 *            Identificador del usuario
	 * @return Guest Invitación
	 */
	public Guest findByPollaByUser(int idPolla, int idUser) {

		EntityManagerHelper.log("finding Guest By Model = " + idPolla
				+ " and User = " + idUser, Level.INFO, null);

		try {

			final String queryString = "select model from Guest model where model.pollas.id= :propertyIdPollaValue And"
					+ " model.user.id= :propertyIdUserValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyIdPollaValue", idPolla);
			query.setParameter("propertyIdUserValue", idUser);
			
			getEntityManager().getEntityManagerFactory().getCache().evictAll();

			return (Guest) query.getSingleResult();

		} catch (NoResultException re) {
			return null;
		} catch (RuntimeException re) {
			EntityManagerHelper.log(
					"find finding Guest By Model and User failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Obtiene las invitaciones de un usuario sin aceptar
	 * 
	 * @param idUser
	 *            Identificador del usuario
	 * @return List<Guest> Lista de invitaciones
	 */
	@SuppressWarnings("unchecked")
	public List<Guest> findByUser(int idUser) {

		EntityManagerHelper.log("finding Guest By idUser = " + idUser,
				Level.INFO, null);

		try {

			final String queryString = "select model from Guest model where model.user.id= :propertyIdUserValue And model.replied = 0";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyIdUserValue", idUser);

			getEntityManager().getEntityManagerFactory().getCache().evictAll();
			
			return query.getResultList();

		} catch (RuntimeException re) {
			EntityManagerHelper.log(
					"find finding Guest By Model and User failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Obtiene las invitaciones realizadas a una polla
	 * 
	 * @param idPolla
	 *            Identificador de la polla
	 * @return List<Guest> Invitaciones
	 */
	@SuppressWarnings("unchecked")
	public List<Guest> findByPolla(int idPolla) {

		EntityManagerHelper.log("finding Guest By idPolla = " + idPolla,
				Level.INFO, null);

		try {

			final String queryString = "select model from Guest model where model.pollas.id= :propertyIdPollaValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyIdPollaValue", idPolla);
			
			getEntityManager().getEntityManagerFactory().getCache().evictAll();

			return query.getResultList();

		} catch (RuntimeException re) {
			EntityManagerHelper.log("find finding Guest By idPolla failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Obtiene las invitaciones realizadas a un E-mail asociado a una polla
	 * 
	 * @param idPolla
	 * @param email
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Guest> findByPollaByEmail(int idPolla, String email) {

		EntityManagerHelper.log("finding Guest By idPolla = " + idPolla
				+ " And Email = " + email, Level.INFO, null);

		try {

			final String queryString = "select model from Guest model where model.pollas.id= :propertyIdPollaValue And model.email= :propertyEmailValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyIdPollaValue", idPolla);
			query.setParameter("propertyEmailValue", email);
			
			getEntityManager().getEntityManagerFactory().getCache().evictAll();

			return query.getResultList();

		} catch (RuntimeException re) {
			EntityManagerHelper.log("find finding Guest By idPolla failed",
					Level.SEVERE, re);
			throw re;
		}
	}

}