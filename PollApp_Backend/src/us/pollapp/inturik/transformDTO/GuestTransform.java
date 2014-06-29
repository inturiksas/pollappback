package us.pollapp.inturik.transformDTO;

import us.pollapp.inturik.DTO.GuestDTO;
import us.pollapp.inturik.model.Guest;
import us.pollapp.inturik.transformDTO.Utils.Transformer;

public class GuestTransform extends Transformer<GuestDTO, Guest> {

	@Override
	public GuestDTO transformDTO(Guest model) {

		GuestDTO objGuestDTO = new GuestDTO();

		if (model != null) {

			objGuestDTO.setId(model.getId());
			objGuestDTO.setEmail(model.getEmail());
			objGuestDTO.setAccepted(model.getAccepted());
			objGuestDTO.setInvitationSent(model.getInvitationSent());

			if (model.getPollas() != null) {
				PollaTransform objPollaTransform = new PollaTransform();
				objGuestDTO.setPollaDTO(objPollaTransform.transformDTO(model
						.getPollas()));
			}

			if (model.getUser() != null) {
				UserTransform objUserTransform = new UserTransform();
				objGuestDTO.setUser(objUserTransform.transformDTO(model
						.getUser()));
			}
		}

		return objGuestDTO;

	}

	@Override
	public Guest transformModel(GuestDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
