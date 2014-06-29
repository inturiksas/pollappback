package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextRequestDTO;

public class MsgGetAllTweetsRequest {

	private ContextRequestDTO contextRequestDTO;

	public ContextRequestDTO getContextRequest() {
		return contextRequestDTO;
	}

	public void setContextRequest(ContextRequestDTO contextRequestDTO) {
		this.contextRequestDTO = contextRequestDTO;
	}
	
}
