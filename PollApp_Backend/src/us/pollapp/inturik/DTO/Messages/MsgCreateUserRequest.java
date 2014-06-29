package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextRequestDTO;
import us.pollapp.inturik.DTO.UserDTO;

public class MsgCreateUserRequest {

	private ContextRequestDTO contextRequestDTO;
	private UserDTO userDTO;

	public ContextRequestDTO getContextRequestDTO() {
		return contextRequestDTO;
	}

	public void setContextRequestDTO(ContextRequestDTO contextRequestDTO) {
		this.contextRequestDTO = contextRequestDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
