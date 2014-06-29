package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextResponseDTO;

public class MsgAddPollaResponse {

	private ContextResponseDTO contextResponse;
	private int idPolla;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public int getIdPolla() {
		return idPolla;
	}

	public void setIdPolla(int idPolla) {
		this.idPolla = idPolla;
	}

}
