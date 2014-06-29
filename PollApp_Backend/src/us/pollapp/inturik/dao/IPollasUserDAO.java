package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.PollasUser;

/**
 * Interface for PollasUserDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPollasUserDAO {
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
	 * IPollasUserDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PollasUser entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(PollasUser entity);

	/**
	 * Delete a persistent PollasUser entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPollasUserDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            PollasUser entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(PollasUser entity);

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
	 * entity = IPollasUserDAO.update(entity);
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
	public PollasUser update(PollasUser entity);

	public PollasUser findById(Integer id);

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
	 *            count of results to return.
	 * @return List<PollasUser> found by query
	 */
	public List<PollasUser> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<PollasUser> findByIsAdmin(Object isAdmin,
			int... rowStartIdxAndCount);

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
	public List<PollasUser> findAll(int... rowStartIdxAndCount);
	
	public List<PollasUser> findByUser(int idUser);
	
	public PollasUser findAdminByPolla(int idPolla);
	
	public List<PollasUser> findByPolla(int idPolla);
	
	public List<PollasUser> findByPollaByUser(int idPolla, int idUser);
}