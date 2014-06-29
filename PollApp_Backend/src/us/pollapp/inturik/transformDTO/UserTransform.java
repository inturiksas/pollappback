package us.pollapp.inturik.transformDTO;

import us.pollapp.inturik.DTO.UserDTO;
import us.pollapp.inturik.model.User;
import us.pollapp.inturik.transformDTO.Utils.Transformer;

public class UserTransform extends Transformer<UserDTO, User> {

	@Override
	public UserDTO transformDTO(User model) {
		UserDTO userDTO = new UserDTO();

		if (model != null) {

			userDTO.setId(model.getId());
			userDTO.setName(model.getName());
			userDTO.setLastName(model.getLastname());
			userDTO.setEmail(model.getEmail());			

		}
		return userDTO;
	}

	@Override
	public User transformModel(UserDTO dto) {
		return null;
	}

}
