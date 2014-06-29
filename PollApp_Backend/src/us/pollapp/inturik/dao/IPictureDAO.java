package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.Picture;

public interface IPictureDAO {

	public void save(Picture entity);

	public void delete(Picture entity);

	public Picture update(Picture entity);

	public Picture findById(Integer id);

	public List<Picture> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Picture> findByPicture(Object picture,
			int... rowStartIdxAndCount);

	public List<Picture> findAll(int... rowStartIdxAndCount);
}