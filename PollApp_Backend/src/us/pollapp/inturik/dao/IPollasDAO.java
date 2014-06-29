package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.Pollas;

/**
 * Interface for PollasDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPollasDAO {
	/**
	 * Perform an initial save of a previously unsaved Pollas entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPollasDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pollas entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Pollas entity);

	/**
	 * Delete a persistent Pollas entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPollasDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Pollas entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Pollas entity);

	/**
	 * Persist a previously saved Pollas entity and return it or a copy of it to
	 * the sender. A copy of the Pollas entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IPollasDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pollas entity to update
	 * @return Pollas the persisted Pollas entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Pollas update(Pollas entity);

	public Pollas findById(Integer id);

	/**
	 * Find all Pollas entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Pollas property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Pollas> found by query
	 */
	public List<Pollas> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Pollas> findByNombre(Object nombre, int... rowStartIdxAndCount);

	/**
	 * Find all Pollas entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Pollas> all Pollas entities
	 */
	public List<Pollas> findAll(int... rowStartIdxAndCount);
	
	public List<Pollas> findByNameByIdUser(String name, int idUser);
}