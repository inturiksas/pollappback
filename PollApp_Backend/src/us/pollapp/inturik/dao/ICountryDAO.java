package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.Country;

/**
 * Interface for CountryDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ICountryDAO {

	public void save(Country entity);

	public void delete(Country entity);

	public Country update(Country entity);

	public Country findById(Integer id);

	public List<Country> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Country> findByName(Object name, int... rowStartIdxAndCount);

	public List<Country> findByFlag(Object flag, int... rowStartIdxAndCount);

	/**
	 * Find all Country entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Country> all Country entities
	 */
	public List<Country> findAll(int... rowStartIdxAndCount);
}