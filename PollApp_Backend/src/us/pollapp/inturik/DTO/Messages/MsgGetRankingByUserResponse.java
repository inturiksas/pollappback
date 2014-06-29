package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.RankingUserDTO;

public class MsgGetRankingByUserResponse {

	private ContextResponseDTO contextResponse;
	private List<RankingUserDTO> lstRankingUserDTO;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public List<RankingUserDTO> getLstRankingUserDTO() {
		return lstRankingUserDTO;
	}

	public void setLstRankingUserDTO(List<RankingUserDTO> lstRankingUserDTO) {
		this.lstRankingUserDTO = lstRankingUserDTO;
	}

}
