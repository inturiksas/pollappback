package us.pollapp.inturik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblpicturemodel", catalog = "bdpollapp")
public class PictureModel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Model model;
	private Picture picture;
	private Boolean main;

	// Constructors

	/** default constructor */
	public PictureModel() {
	}

	/** full constructor */
	public PictureModel(Model model, Picture picture, Boolean main) {
		this.model = model;
		this.picture = picture;
		this.main = main;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idModel", nullable = false)
	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPicture", nullable = false)
	public Picture getPicture() {
		return this.picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	@Column(name = "main", nullable = false)
	public Boolean getMain() {
		return this.main;
	}

	public void setMain(Boolean main) {
		this.main = main;
	}

}