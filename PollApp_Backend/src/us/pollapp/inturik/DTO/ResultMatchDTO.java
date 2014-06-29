package us.pollapp.inturik.DTO;

public class ResultMatchDTO {

	private int idResultMatch;
	private int idUser;
	private String names;
	private String lastName;
	private int scoreTeamA;
	private int scoreTeamB;
	private int totalScore;

	public int getIdResultMatch() {
		return idResultMatch;
	}

	public void setIdResultMatch(int idResultMatch) {
		this.idResultMatch = idResultMatch;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
