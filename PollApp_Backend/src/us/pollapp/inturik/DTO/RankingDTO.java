package us.pollapp.inturik.DTO;


public class RankingDTO {

	private int idPollaUser;
	private int totalScore;
	private UserDTO userDTO;

	public int getIdPollaUser() {
		return idPollaUser;
	}

	public void setIdPollaUser(int idPollaUser) {
		this.idPollaUser = idPollaUser;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
