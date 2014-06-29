package us.pollapp.inturik.transformDTO;

import us.pollapp.inturik.DTO.RankingDTO;
import us.pollapp.inturik.model.PollasUser;
import us.pollapp.inturik.transformDTO.Utils.Transformer;

public class RankingTransform extends Transformer<RankingDTO, PollasUser> {

	@Override
	public RankingDTO transformDTO(PollasUser model) {

		RankingDTO objRanking = new RankingDTO();

		if (model != null) {
			objRanking.setIdPollaUser(model.getId());
			objRanking.setTotalScore(model.getTotalScore());

			UserTransform objUserTrans = new UserTransform();

			objRanking.setUserDTO(objUserTrans.transformDTO(model.getUser()));
		}

		return objRanking;

	}

	@Override
	public PollasUser transformModel(RankingDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
