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
 * PollasUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tblpollasuser", catalog = "bdpollapp")
public class PollasUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Pollas pollas;
	private User user;
	private int totalScore;
	private Boolean isAdmin;

	// Constructors

	/** default constructor */
	public PollasUser() {
	}

	/** full constructor */
	public PollasUser(Pollas pollas, User user, Boolean isAdmin) {
		this.pollas = pollas;
		this.user = user;
		this.isAdmin = isAdmin;
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
	@JoinColumn(name = "idpolla", nullable = false)
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

	@Column(name = "isAdmin", nullable = false)
	public Boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Column(name = "totalScore", nullable = true)
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

}