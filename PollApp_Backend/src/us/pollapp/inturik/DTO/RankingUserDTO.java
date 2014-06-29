package us.pollapp.inturik.DTO;

import java.util.Date;

public class RankingUserDTO {

	private int idResultMatch;
	private String namesUser;
	private String lastNameUser;
	private int scoreTeamA;
	private int scoreTeamB;
	private int scoreOrgTeamA;
	private int scoreOrgTeamB;
	private int totalScore;
	private String nameTeamA;
	private String nameTeamB;
	private String flagTeamA;
	private String flagTeamB;
	private Date dateMatch;

	public int getIdResultMatch() {
		return idResultMatch;
	}

	public void setIdResultMatch(int idResultMatch) {
		this.idResultMatch = idResultMatch;
	}

	public String getNamesUser() {
		return namesUser;
	}

	public void setNamesUser(String namesUser) {
		this.namesUser = namesUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
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

	public int getScoreOrgTeamA() {
		return scoreOrgTeamA;
	}

	public void setScoreOrgTeamA(int scoreOrgTeamA) {
		this.scoreOrgTeamA = scoreOrgTeamA;
	}

	public int getScoreOrgTeamB() {
		return scoreOrgTeamB;
	}

	public void setScoreOrgTeamB(int scoreOrgTeamB) {
		this.scoreOrgTeamB = scoreOrgTeamB;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getNameTeamA() {
		return nameTeamA;
	}

	public void setNameTeamA(String nameTeamA) {
		this.nameTeamA = nameTeamA;
	}

	public String getNameTeamB() {
		return nameTeamB;
	}

	public void setNameTeamB(String nameTeamB) {
		this.nameTeamB = nameTeamB;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}

	public String getFlagTeamA() {
		return flagTeamA;
	}

	public void setFlagTeamA(String flagTeamA) {
		this.flagTeamA = flagTeamA;
	}

	public String getFlagTeamB() {
		return flagTeamB;
	}

	public void setFlagTeamB(String flagTeamB) {
		this.flagTeamB = flagTeamB;
	}

}
