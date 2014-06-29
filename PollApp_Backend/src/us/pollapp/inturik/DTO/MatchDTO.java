package us.pollapp.inturik.DTO;

import java.util.Date;

public class MatchDTO {

	private Integer id;
	private String teamA;
	private String teamB;
	private Date date;
	private String hour;
	private String nameGroup;
	private String flagTeamA;
	private String flagTeamB;
	private String stadium;
	private Integer resultTeamA;
	private Integer resultTeamB;
	private Integer round;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamA() {
		return teamA;
	}

	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}

	public String getTeamB() {
		return teamB;
	}

	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getNameGroup() {
		return nameGroup;
	}

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
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

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public Integer getResultTeamA() {
		return resultTeamA;
	}

	public void setResultTeamA(Integer resultTeamA) {
		this.resultTeamA = resultTeamA;
	}

	public Integer getResultTeamB() {
		return resultTeamB;
	}

	public void setResultTeamB(Integer resultTeamB) {
		this.resultTeamB = resultTeamB;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

}
