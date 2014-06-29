package us.pollapp.inturik.dao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import us.pollapp.inturik.model.Picture;

public class PictureDAO implements IPictureDAO {
	// property constants
	public static final String PICTURE = "picture";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public void save(Picture entity) {
		EntityManagerHelper.log("saving Picture instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	public void delete(Picture entity) {
		EntityManagerHelper.log("deleting Picture instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Picture.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Picture update(Picture entity) {
		EntityManagerHelper.log("updating Picture instance", Level.INFO, null);
		try {
			Picture result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Picture findById(Integer id) {
		EntityManagerHelper.log("finding Picture instance with id: " + id,
				Level.INFO, null);
		try {
			Picture instance = getEntityManager().find(Picture.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Picture> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding Picture instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select picture from Picture picture where picture."
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

	public List<Picture> findByPicture(Object picture,
			int... rowStartIdxAndCount) {
		return findByProperty(PICTURE, picture, rowStartIdxAndCount);
	}

	@SuppressWarnings("unchecked")
	public List<Picture> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all Picture instances", Level.INFO,
				null);
		try {
			final String queryString = "select picture from Picture picture";
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

}