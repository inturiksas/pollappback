package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.UserDTO;

public class MsgCreateUserResponse {

	private ContextResponseDTO contextResponse;
	private UserDTO userDTO;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
