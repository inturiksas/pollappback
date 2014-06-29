package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.MatchDTO;

public class MsgGetMatchsByRoundResponse {

	private ContextResponseDTO contextResponse;
	private List<MatchDTO> lstMatchDTO;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public List<MatchDTO> getLstMatchDTO() {
		return lstMatchDTO;
	}

	public void setLstMatchDTO(List<MatchDTO> lstMatchDTO) {
		this.lstMatchDTO = lstMatchDTO;
	}

}
