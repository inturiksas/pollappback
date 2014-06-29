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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Model entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tblmodel", catalog = "bdpollapp")
public class Model implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Country country;
	private String name;
	private Integer score;
	private Boolean active;
	private Set<Ballot> ballots = new HashSet<Ballot>(0);
	private Set<PictureModel> pictureModels = new HashSet<PictureModel>(0);

	// Constructors

	/** default constructor */
	public Model() {
	}

	/** minimal constructor */
	public Model(Country country, String name, Integer score, Boolean active) {
		this.country = country;
		this.name = name;
		this.score = score;
		this.active = active;
	}

	/** full constructor */
	public Model(Country country, String name, Integer score, Boolean active,
			Set<Ballot> ballots, Set<PictureModel> pictureModels) {
		this.country = country;
		this.name = name;
		this.score = score;
		this.active = active;
		this.ballots = ballots;
		this.pictureModels = pictureModels;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCountry", nullable = false)
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "name", nullable = false, length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "score", nullable = false)
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "active", nullable = false)
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "model")
	public Set<Ballot> getBallots() {
		return this.ballots;
	}

	public void setBallots(Set<Ballot> ballots) {
		this.ballots = ballots;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "model")
	public Set<PictureModel> getPictureModels() {
		return this.pictureModels;
	}

	public void setPictureModels(Set<PictureModel> pictureModels) {
		this.pictureModels = pictureModels;
	}

}