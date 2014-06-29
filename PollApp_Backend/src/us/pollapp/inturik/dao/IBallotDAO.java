package us.pollapp.inturik.dao;

import java.util.List;

import us.pollapp.inturik.model.Ballot;

public interface IBallotDAO {

	public void save(Ballot entity);

	public void delete(Ballot entity);

	public Ballot update(Ballot entity);

	public Ballot findById(Integer id);

	public List<Ballot> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Ballot> findAll(int... rowStartIdxAndCount);

	public long countBallotByModel(int idModel);

	public List<Ballot> findByIdModelAndIdUser(int idModel, int idUser);
	
}