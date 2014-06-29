package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextRequestDTO;

public class MsgUpdateAcceptedInvitationRequest {

	private ContextRequestDTO contextRequestDTO;
	private int idPolla;
	private int idUser;
	private boolean accepted;

	public ContextRequestDTO getContextRequestDTO() {
		return contextRequestDTO;
	}

	public void setContextRequestDTO(ContextRequestDTO contextRequestDTO) {
		this.contextRequestDTO = contextRequestDTO;
	}

	public int getIdPolla() {
		return idPolla;
	}

	public void setIdPolla(int idPolla) {
		this.idPolla = idPolla;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

}
