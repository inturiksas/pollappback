package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.ResultMatch;

/**
 * Interface for ResultMatchDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IResultMatchDAO {
	/**
	 * Perform an initial save of a previously unsaved ResultMatch entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IResultMatchDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            ResultMatch entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ResultMatch entity);

	/**
	 * Delete a persistent ResultMatch entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IResultMatchDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            ResultMatch entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ResultMatch entity);

	/**
	 * Persist a previously saved ResultMatch entity and return it or a copy of
	 * it to the sender. A copy of the ResultMatch entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IResultMatchDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            ResultMatch entity to update
	 * @return ResultMatch the persisted ResultMatch entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ResultMatch update(ResultMatch entity);

	public ResultMatch findById(Integer id);

	/**
	 * Find all ResultMatch entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the ResultMatch property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ResultMatch> found by query
	 */
	public List<ResultMatch> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<ResultMatch> findByScoreTeamA(Object scoreTeamA,
			int... rowStartIdxAndCount);

	public List<ResultMatch> findByScoreTeamB(Object scoreTeamB,
			int... rowStartIdxAndCount);

	public List<ResultMatch> findByTotalScore(Object totalScore,
			int... rowStartIdxAndCount);

	/**
	 * Find all ResultMatch entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ResultMatch> all ResultMatch entities
	 */
	public List<ResultMatch> findAll(int... rowStartIdxAndCount);

	public List<ResultMatch> findByIdPollaByUser(
			final int idPolla, final int idUser,
			final int... rowStartIdxAndCount);

	public List<ResultMatch> findByIdPollaMatchByUsers(final int idPollaMatch,
			final String idUsers, final int... rowStartIdxAndCount);

	public ResultMatch findByIdPollaByMatchByUser(final int idPolla,
			final int idMatch, final int idUser);

	public List<ResultMatch> findByIdPollaByMatch(final int idPolla,
			final int idMatch, final int... rowStartIdxAndCount);

	public List<ResultMatch> findByIdPolla(final int idPolla,
			final int... rowStartIdxAndCount);
	
	public List<ResultMatch> findByIdMatch(final int idMatch, final int... rowStartIdxAndCount);
}