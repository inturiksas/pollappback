package us.pollapp.inturik.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbluser", catalog = "bdpollapp")
public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6020176214917471832L;
	private Integer id;
	private String name;
	private String email;
	private String lastname;
	private String password;
	private Set<Ballot> ballots = new HashSet<Ballot>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String email, String lastname, String password) {
		this.name = name;
		this.email = email;
		this.lastname = lastname;
		this.password = password;
	}

	/** full constructor */
	public User(String name, String email, String lastname, String password,
			Set<Ballot> ballots) {
		this.name = name;
		this.email = email;
		this.lastname = lastname;
		this.password = password;
		this.ballots = ballots;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false, length = 500)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "lastname", nullable = false, length = 500)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Ballot> getBallots() {
		return this.ballots;
	}

	public void setBallots(Set<Ballot> ballots) {
		this.ballots = ballots;
	}

}