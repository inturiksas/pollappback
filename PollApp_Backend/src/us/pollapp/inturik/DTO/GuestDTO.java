package us.pollapp.inturik.DTO;

public class GuestDTO {

	private int id;
	private String email;
	private boolean accepted;
	private boolean invitationSent;
	private PollaDTO pollaDTO;
	private UserDTO user;
	private UserDTO userAdmin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PollaDTO getPollaDTO() {
		return pollaDTO;
	}

	public void setPollaDTO(PollaDTO pollaDTO) {
		this.pollaDTO = pollaDTO;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public UserDTO getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(UserDTO userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isInvitationSent() {
		return invitationSent;
	}

	public void setInvitationSent(boolean invitationSent) {
		this.invitationSent = invitationSent;
	}

}
