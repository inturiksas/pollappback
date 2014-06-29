package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.ResultMatchDTO;

public class MsgGetResulstMatchResponse {

	private ContextResponseDTO contextResponse;
	private List<ResultMatchDTO> lstResultMatchDTO;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public List<ResultMatchDTO> getLstResultMatchDTO() {
		return lstResultMatchDTO;
	}

	public void setLstResultMatchDTO(List<ResultMatchDTO> lstResultMatchDTO) {
		this.lstResultMatchDTO = lstResultMatchDTO;
	}

}
