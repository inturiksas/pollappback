package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.Model;

/**
 * Interface for ModelDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IModelDAO {
	/**
	 * Perform an initial save of a previously unsaved Model entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IModelDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Model entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Model entity);

	/**
	 * Delete a persistent Model entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IModelDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Model entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Model entity);

	/**
	 * Persist a previously saved Model entity and return it or a copy of it to
	 * the sender. A copy of the Model entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IModelDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Model entity to update
	 * @return Model the persisted Model entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Model update(Model entity);

	public Model findById(Integer id);

	/**
	 * Find all Model entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Model property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Model> found by query
	 */
	public List<Model> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Model> findByName(Object name, int... rowStartIdxAndCount);

	public List<Model> findByScore(Object score, int... rowStartIdxAndCount);

	public List<Model> findByActive(Object active, int... rowStartIdxAndCount);

	/**
	 * Find all Model entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Model> all Model entities
	 */
	public List<Model> findAll(int... rowStartIdxAndCount);

}