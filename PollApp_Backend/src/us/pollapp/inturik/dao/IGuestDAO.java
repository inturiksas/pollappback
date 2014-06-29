package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.Guest;

/**
 * Interface for GuestDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IGuestDAO {
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
	 * IGuestDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Guest entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Guest entity);

	/**
	 * Delete a persistent Guest entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IGuestDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Guest entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Guest entity);

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
	 * entity = IGuestDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Guest entity to update
	 * @return Guest the persisted Guest entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Guest update(Guest entity);

	public Guest findById(Integer id);

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
	 *            count of results to return.
	 * @return List<Guest> found by query
	 */
	public List<Guest> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Guest> findByEmail(Object email, int... rowStartIdxAndCount);

	public List<Guest> findByInvitationSent(Object invitationSent,
			int... rowStartIdxAndCount);

	public List<Guest> findByAccepted(Object accepted,
			int... rowStartIdxAndCount);

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
	public List<Guest> findAll(int... rowStartIdxAndCount);
	
	public Guest findByPollaByUser(int idPolla, int idUser);

	public List<Guest> findByUser(int idUser);

	public List<Guest> findByPolla(int idPolla);
	
	public List<Guest> findByPollaByEmail(int idPolla, String email);
}