package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.Match;

/**
 * Interface for MatchDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMatchDAO {
	/**
	 * Perform an initial save of a previously unsaved Match entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMatchDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Match entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Match entity);

	/**
	 * Delete a persistent Match entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMatchDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Match entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Match entity);

	/**
	 * Persist a previously saved Match entity and return it or a copy of it to
	 * the sender. A copy of the Match entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IMatchDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Match entity to update
	 * @return Match the persisted Match entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Match update(Match entity);

	public Match findById(Integer id);

	/**
	 * Find all Match entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Match property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Match> found by query
	 */
	public List<Match> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Match> findByTeamA(Object teamA, int... rowStartIdxAndCount);

	public List<Match> findByTeamB(Object teamB, int... rowStartIdxAndCount);

	public List<Match> findByHour(Object hour, int... rowStartIdxAndCount);

	public List<Match> findByNameGroup(Object nameGroup,
			int... rowStartIdxAndCount);

	public List<Match> findByFlagTeamA(Object flagTeamA,
			int... rowStartIdxAndCount);

	public List<Match> findByFlagTeamB(Object flagTeamB,
			int... rowStartIdxAndCount);

	public List<Match> findByStadium(Object stadium, int... rowStartIdxAndCount);

	public List<Match> findByResultTeamA(Object resultTeamA,
			int... rowStartIdxAndCount);

	public List<Match> findByResultTeamB(Object resultTeamB,
			int... rowStartIdxAndCount);

	/**
	 * Find all Match entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Match> all Match entities
	 */
	public List<Match> findAll(int... rowStartIdxAndCount);

	public List<Match> findByRound(Object round, int... rowStartIdxAndCount);

	public List<Match> findByRoundOrderByDate(final int idRound,
			final int... rowStartIdxAndCount);
}