package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextRequestDTO;

public class MsgAddGuestPollaRequest {

	private ContextRequestDTO contextRequestDTO;
	private List<String> emails;
	private int idPolla;
	private int idUserAdmin;

	public ContextRequestDTO getContextRequestDTO() {
		return contextRequestDTO;
	}

	public void setContextRequestDTO(ContextRequestDTO contextRequestDTO) {
		this.contextRequestDTO = contextRequestDTO;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public int getIdPolla() {
		return idPolla;
	}

	public void setIdPolla(int idPolla) {
		this.idPolla = idPolla;
	}

	public int getIdUserAdmin() {
		return idUserAdmin;
	}

	public void setIdUserAdmin(int idUserAdmin) {
		this.idUserAdmin = idUserAdmin;
	}

}
