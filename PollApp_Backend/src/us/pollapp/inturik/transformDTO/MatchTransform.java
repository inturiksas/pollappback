package us.pollapp.inturik.transformDTO;

import us.pollapp.inturik.DTO.MatchDTO;
import us.pollapp.inturik.model.Match;
import us.pollapp.inturik.transformDTO.Utils.Transformer;

public class MatchTransform extends Transformer<MatchDTO, Match> {

	@Override
	public MatchDTO transformDTO(Match model) {

		MatchDTO objMatchDTO = new MatchDTO();

		if (model != null) {

			objMatchDTO.setId(model.getId());
			objMatchDTO.setTeamA(model.getTeamA());
			objMatchDTO.setTeamB(model.getTeamB());
			objMatchDTO.setDate(model.getDate());
			objMatchDTO.setHour(model.getHour());
			objMatchDTO.setNameGroup(model.getNameGroup());
			objMatchDTO.setFlagTeamA(model.getFlagTeamA());
			objMatchDTO.setFlagTeamB(model.getFlagTeamB());
			objMatchDTO.setStadium(model.getStadium());
			objMatchDTO.setResultTeamA(model.getResultTeamA() == null ? 0
					: model.getResultTeamA());
			objMatchDTO.setResultTeamB(model.getResultTeamB() == null ? 0
					: model.getResultTeamB());
			objMatchDTO.setRound(model.getRound());

		}

		return objMatchDTO;
	}

	@Override
	public Match transformModel(MatchDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
