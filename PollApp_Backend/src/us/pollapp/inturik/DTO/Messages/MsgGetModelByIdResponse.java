package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.ModelDTO;

public class MsgGetModelByIdResponse {

	private ContextResponseDTO contextResponse;
	private ModelDTO model;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public ModelDTO getModel() {
		return model;
	}

	public void setModel(ModelDTO model) {
		this.model = model;
	}

}
