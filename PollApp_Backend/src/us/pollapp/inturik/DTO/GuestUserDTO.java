package us.pollapp.inturik.DTO;

public class GuestUserDTO {

	private UserDTO user;
	private boolean accepted;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

}
