package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextRequestDTO;

public class MsgUpdateResultMatchOriginalRequest {

	private ContextRequestDTO contextRequestDTO;
	private int idMatch;
	private int scoreTeamAOrg;
	private int scoreTeamBOrg;

	public ContextRequestDTO getContextRequestDTO() {
		return contextRequestDTO;
	}

	public void setContextRequestDTO(ContextRequestDTO contextRequestDTO) {
		this.contextRequestDTO = contextRequestDTO;
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public int getScoreTeamAOrg() {
		return scoreTeamAOrg;
	}

	public void setScoreTeamAOrg(int scoreTeamAOrg) {
		this.scoreTeamAOrg = scoreTeamAOrg;
	}

	public int getScoreTeamBOrg() {
		return scoreTeamBOrg;
	}

	public void setScoreTeamBOrg(int scoreTeamBOrg) {
		this.scoreTeamBOrg = scoreTeamBOrg;
	}

}
