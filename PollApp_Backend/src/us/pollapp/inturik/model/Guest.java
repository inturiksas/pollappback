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
 * Guest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tblGuest", catalog = "bdpollapp")
public class Guest implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Pollas pollas;
	private User user;
	private String email;
	private Boolean invitationSent;
	private Boolean accepted;
	private Boolean replied;

	// Constructors

	/** default constructor */
	public Guest() {
	}

	/** minimal constructor */
	public Guest(Pollas pollas, String email, Boolean invitationSent,
			Boolean accepted) {
		this.pollas = pollas;
		this.email = email;
		this.invitationSent = invitationSent;
		this.accepted = accepted;
	}

	/** full constructor */
	public Guest(Pollas pollas, User user, String email,
			Boolean invitationSent, Boolean accepted) {
		this.pollas = pollas;
		this.user = user;
		this.email = email;
		this.invitationSent = invitationSent;
		this.accepted = accepted;
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
	@JoinColumn(name = "idUser")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "email", nullable = false, length = 200)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "invitationSent", nullable = false)
	public Boolean getInvitationSent() {
		return this.invitationSent;
	}

	public void setInvitationSent(Boolean invitationSent) {
		this.invitationSent = invitationSent;
	}

	@Column(name = "accepted", nullable = false)
	public Boolean getAccepted() {
		return this.accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}
	
	@Column(name = "replied", nullable = false)
	public Boolean getReplied() {
		return this.replied;
	}

	public void setReplied(Boolean replied) {
		this.replied = replied;
	}
}