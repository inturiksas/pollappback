package us.pollapp.inturik.DTO;

public class ModelDTO {

	private int id;	
	private String name;
	private int score;
	private String nameCountry;
	private PictureModelDTO[] picturesModel;

	public ModelDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public PictureModelDTO[] getPicturesModel() {
		return picturesModel;
	}

	public void setPicturesModel(PictureModelDTO[] picturesModel) {
		this.picturesModel = picturesModel;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}

}
