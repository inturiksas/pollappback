package us.pollapp.inturik.model;

import java.sql.Timestamp;
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

/**
 * Pollas entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tblpollas", catalog = "bdpollapp")
public class Pollas implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private Timestamp createdDate;
	private Set<Guest> guests = new HashSet<Guest>(0);
	private Set<ResultMatch> resultMatchs = new HashSet<ResultMatch>(0);
	private Set<PollasUser> pollasUsers = new HashSet<PollasUser>(0);
	private Integer idUserAdmin;

	// Constructors

	/** default constructor */
	public Pollas() {
	}

	/** minimal constructor */
	public Pollas(String nombre, Timestamp createdDate) {
		this.nombre = nombre;
		this.createdDate = createdDate;
	}

	/** full constructor */
	public Pollas(String nombre, Timestamp createdDate, Set<Guest> guests,
			Set<ResultMatch> resultMatchs, Set<PollasUser> pollasUsers) {
		this.nombre = nombre;
		this.createdDate = createdDate;
		this.guests = guests;
		this.resultMatchs = resultMatchs;
		this.pollasUsers = pollasUsers;
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

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "createdDate", nullable = false, length = 19)
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pollas")
	public Set<Guest> getGuests() {
		return this.guests;
	}

	public void setGuests(Set<Guest> guests) {
		this.guests = guests;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pollas")
	public Set<ResultMatch> getResultMatchs() {
		return this.resultMatchs;
	}

	public void setResultMatchs(Set<ResultMatch> resultMatchs) {
		this.resultMatchs = resultMatchs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pollas")
	public Set<PollasUser> getPollasUsers() {
		return this.pollasUsers;
	}

	public void setPollasUsers(Set<PollasUser> pollasUsers) {
		this.pollasUsers = pollasUsers;
	}

	@Column(name = "idUserAdmin", nullable = false)
	public Integer getIdUserAdmin() {
		return idUserAdmin;
	}

	public void setIdUserAdmin(Integer idUserAdmin) {
		this.idUserAdmin = idUserAdmin;
	}

}