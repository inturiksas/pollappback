package us.pollapp.inturik.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Match entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tblmatch", catalog = "bdpollapp")
public class Match implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private Set<ResultMatch> resultMatchs = new HashSet<ResultMatch>(0);

	// Constructors

	/** default constructor */
	public Match() {
	}

	/** minimal constructor */
	public Match(String teamA, String teamB, String hour, String nameGroup,
			String flagTeamA, String flagTeamB, String stadium) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.hour = hour;
		this.nameGroup = nameGroup;
		this.flagTeamA = flagTeamA;
		this.flagTeamB = flagTeamB;
		this.stadium = stadium;
	}

	/** full constructor */
	public Match(String teamA, String teamB, Date date, String hour,
			String nameGroup, String flagTeamA, String flagTeamB,
			String stadium, Integer resultTeamA, Integer resultTeamB,
			Set<ResultMatch> resultMatchs) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.date = date;
		this.hour = hour;
		this.nameGroup = nameGroup;
		this.flagTeamA = flagTeamA;
		this.flagTeamB = flagTeamB;
		this.stadium = stadium;
		this.resultTeamA = resultTeamA;
		this.resultTeamB = resultTeamB;
		this.resultMatchs = resultMatchs;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "teamA", nullable = false)
	public String getTeamA() {
		return this.teamA;
	}

	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}

	@Column(name = "teamB", nullable = false)
	public String getTeamB() {
		return this.teamB;
	}

	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "hour", nullable = false, length = 20)
	public String getHour() {
		return this.hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	@Column(name = "nameGroup", nullable = false)
	public String getNameGroup() {
		return this.nameGroup;
	}

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}

	@Column(name = "flagTeamA", nullable = false)
	public String getFlagTeamA() {
		return this.flagTeamA;
	}

	public void setFlagTeamA(String flagTeamA) {
		this.flagTeamA = flagTeamA;
	}

	@Column(name = "flagTeamB", nullable = false)
	public String getFlagTeamB() {
		return this.flagTeamB;
	}

	public void setFlagTeamB(String flagTeamB) {
		this.flagTeamB = flagTeamB;
	}

	@Column(name = "stadium", nullable = false)
	public String getStadium() {
		return this.stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	@Column(name = "resultTeamA")
	public Integer getResultTeamA() {
		return this.resultTeamA;
	}

	public void setResultTeamA(Integer resultTeamA) {
		this.resultTeamA = resultTeamA;
	}

	@Column(name = "resultTeamB")
	public Integer getResultTeamB() {
		return this.resultTeamB;
	}

	public void setResultTeamB(Integer resultTeamB) {
		this.resultTeamB = resultTeamB;
	}

	@Column(name = "round")
	public Integer getRound() {
		return this.round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "match")
	public Set<ResultMatch> getResultMatchs() {
		return this.resultMatchs;
	}

	public void setResultMatchs(Set<ResultMatch> resultMatchs) {
		this.resultMatchs = resultMatchs;
	}

}