package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.ModelDTO;

public class MsgGetAllModelsActiveResponse {

	private ContextResponseDTO contextResponse;
	private List<ModelDTO> lstModels;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public List<ModelDTO> getModels() {
		return lstModels;
	}

	public void setModels(List<ModelDTO> lstModels) {
		this.lstModels = lstModels;
	}

}
