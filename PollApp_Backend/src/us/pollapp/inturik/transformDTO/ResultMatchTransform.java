package us.pollapp.inturik.transformDTO;

import us.pollapp.inturik.DTO.ResultMatchDTO;
import us.pollapp.inturik.model.ResultMatch;
import us.pollapp.inturik.transformDTO.Utils.Transformer;

public class ResultMatchTransform extends
		Transformer<ResultMatchDTO, ResultMatch> {

	@Override
	public ResultMatchDTO transformDTO(ResultMatch model) {

		ResultMatchDTO result = new ResultMatchDTO();

		if (model != null) {

			result.setIdResultMatch(model.getId());
			result.setIdUser(model.getUser().getId());
			result.setNames(model.getUser().getName());
			result.setLastName(model.getUser().getLastname());
			result.setScoreTeamA(model.getScoreTeamA());
			result.setScoreTeamB(model.getScoreTeamB());
			result.setTotalScore(model.getTotalScore() == null ? 0 : model
					.getTotalScore());

		}

		return result;
	}

	@Override
	public ResultMatch transformModel(ResultMatchDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
