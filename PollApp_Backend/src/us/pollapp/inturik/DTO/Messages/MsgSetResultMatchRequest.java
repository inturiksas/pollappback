package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextRequestDTO;

public class MsgSetResultMatchRequest {

	private ContextRequestDTO contextRequestDTO;
	private int idUser;
	private int idPolla;
	private int idMatch;
	private int scoreTeamA;
	private int scoreTeamB;

	public ContextRequestDTO getContextRequestDTO() {
		return contextRequestDTO;
	}

	public void setContextRequestDTO(ContextRequestDTO contextRequestDTO) {
		this.contextRequestDTO = contextRequestDTO;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdPolla() {
		return idPolla;
	}

	public void setIdPolla(int idPolla) {
		this.idPolla = idPolla;
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public int getScoreTeamA() {
		return scoreTeamA;
	}

	public void setScoreTeamA(int scoreTeamA) {
		this.scoreTeamA = scoreTeamA;
	}

	public int getScoreTeamB() {
		return scoreTeamB;
	}

	public void setScoreTeamB(int scoreTeamB) {
		this.scoreTeamB = scoreTeamB;
	}

}
