package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.PollaDTO;

public class MsgGetPollasByUserResponse {

	private ContextResponseDTO contextResponse;
	private List<PollaDTO> lstPollaDTO;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public List<PollaDTO> getLstPollaDTO() {
		return lstPollaDTO;
	}

	public void setLstPollaDTO(List<PollaDTO> lstPollaDTO) {
		this.lstPollaDTO = lstPollaDTO;
	}

}
