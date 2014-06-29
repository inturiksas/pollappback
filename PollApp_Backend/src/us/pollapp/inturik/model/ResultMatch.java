package us.pollapp.inturik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ResultMatch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tblresultmatch", catalog = "bdpollapp")
public class ResultMatch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Match match;
	private Pollas pollas;
	private User user;
	private Integer scoreTeamA;
	private Integer scoreTeamB;
	private Integer totalScore;

	// Constructors

	/** default constructor */
	public ResultMatch() {
	}

	/** minimal constructor */
	public ResultMatch(Match match, Pollas pollas, User user,
			Integer scoreTeamA, Integer scoreTeamB) {
		this.match = match;
		this.pollas = pollas;
		this.user = user;
		this.scoreTeamA = scoreTeamA;
		this.scoreTeamB = scoreTeamB;
	}

	/** full constructor */
	public ResultMatch(Match match, Pollas pollas, User user,
			Integer scoreTeamA, Integer scoreTeamB, Integer totalScore) {
		this.match = match;
		this.pollas = pollas;
		this.user = user;
		this.scoreTeamA = scoreTeamA;
		this.scoreTeamB = scoreTeamB;
		this.totalScore = totalScore;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idMatch", nullable = false)
	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPolla", nullable = false)
	public Pollas getPollas() {
		return this.pollas;
	}

	public void setPollas(Pollas pollas) {
		this.pollas = pollas;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "scoreTeamA", nullable = false)
	public Integer getScoreTeamA() {
		return this.scoreTeamA;
	}

	public void setScoreTeamA(Integer scoreTeamA) {
		this.scoreTeamA = scoreTeamA;
	}

	@Column(name = "scoreTeamB", nullable = false)
	public Integer getScoreTeamB() {
		return this.scoreTeamB;
	}

	public void setScoreTeamB(Integer scoreTeamB) {
		this.scoreTeamB = scoreTeamB;
	}

	@Column(name = "totalScore")
	public Integer getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

}