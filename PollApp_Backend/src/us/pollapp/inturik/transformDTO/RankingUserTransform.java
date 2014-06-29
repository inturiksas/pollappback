package us.pollapp.inturik.transformDTO;

import us.pollapp.inturik.DTO.RankingUserDTO;
import us.pollapp.inturik.model.Match;
import us.pollapp.inturik.model.ResultMatch;
import us.pollapp.inturik.transformDTO.Utils.Transformer;

public class RankingUserTransform extends
		Transformer<RankingUserDTO, ResultMatch> {

	@Override
	public RankingUserDTO transformDTO(ResultMatch model) {

		RankingUserDTO result = new RankingUserDTO();

		if (model != null) {

			result.setIdResultMatch(model.getId());
			result.setNamesUser(model.getUser().getName());
			result.setLastNameUser(model.getUser().getLastname());
			result.setScoreTeamA(model.getScoreTeamA());
			result.setScoreTeamB(model.getScoreTeamB());
			result.setTotalScore(model.getTotalScore() != null ? model.getTotalScore() : 0);

			Match match = model.getMatch();

			result.setNameTeamA(match.getTeamA());
			result.setNameTeamB(match.getTeamB());
			result.setFlagTeamA(match.getFlagTeamA());
			result.setFlagTeamB(match.getFlagTeamB());
			result.setDateMatch(match.getDate());

			if (match.getResultTeamA() != null) {
				result.setScoreOrgTeamA(match.getResultTeamA());
			}

			if (match.getResultTeamB() != null) {
				result.setScoreOrgTeamB(match.getResultTeamB());
			}

		}

		return result;
	}

	@Override
	public ResultMatch transformModel(RankingUserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
