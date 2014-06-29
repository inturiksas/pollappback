package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextRequestDTO;

public class MsgAddPollaRequest {

	private ContextRequestDTO contextRequestDTO;
	private String namePolla;
	private int idUser;
	private List<String> emails;

	public ContextRequestDTO getContextRequestDTO() {
		return contextRequestDTO;
	}

	public void setContextRequestDTO(ContextRequestDTO contextRequestDTO) {
		this.contextRequestDTO = contextRequestDTO;
	}

	public String getNamePolla() {
		return namePolla;
	}

	public void setNamePolla(String namePolla) {
		this.namePolla = namePolla;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

}
