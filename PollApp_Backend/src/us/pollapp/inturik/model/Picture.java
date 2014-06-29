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

@Entity
@Table(name = "tblpicture", catalog = "bdpollapp")
public class Picture implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String picture;
	private Boolean active;
	private Set<PictureModel> pictureModels = new HashSet<PictureModel>(0);

	// Constructors

	/** default constructor */
	public Picture() {
	}

	/** minimal constructor */
	public Picture(String picture, Boolean active) {
		this.picture = picture;
		this.active = active;
	}

	/** full constructor */
	public Picture(String picture, Boolean active,
			Set<PictureModel> pictureModels) {
		this.picture = picture;
		this.active = active;
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

	@Column(name = "picture", nullable = false, length = 500)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "active", nullable = false)
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "picture")
	public Set<PictureModel> getPictureModels() {
		return this.pictureModels;
	}

	public void setPictureModels(Set<PictureModel> pictureModels) {
		this.pictureModels = pictureModels;
	}
}