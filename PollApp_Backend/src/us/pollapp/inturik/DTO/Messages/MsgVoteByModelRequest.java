package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextRequestDTO;

public class MsgVoteByModelRequest {

	private ContextRequestDTO contextRequest;
	private int idModel;
	private int idUser;
	private int score;

	public ContextRequestDTO getContextRequest() {
		return contextRequest;
	}

	public void setContextRequest(ContextRequestDTO contextRequest) {
		this.contextRequest = contextRequest;
	}

	public int getIdModel() {
		return idModel;
	}

	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
