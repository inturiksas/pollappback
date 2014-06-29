package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.PictureModel;

public interface IPictureModelDAO {

	public void save(PictureModel entity);

	public void delete(PictureModel entity);

	public PictureModel update(PictureModel entity);

	public PictureModel findById(Integer id);

	public List<PictureModel> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<PictureModel> findAll(int... rowStartIdxAndCount);
}