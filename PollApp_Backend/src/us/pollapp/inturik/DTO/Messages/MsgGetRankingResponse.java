package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.RankingDTO;

public class MsgGetRankingResponse {

	private ContextResponseDTO contextResponse;
	private List<RankingDTO> lstRankingDTO;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public List<RankingDTO> getLstRankingDTO() {
		return lstRankingDTO;
	}

	public void setLstRankingDTO(List<RankingDTO> lstRankingDTO) {
		this.lstRankingDTO = lstRankingDTO;
	}

}
