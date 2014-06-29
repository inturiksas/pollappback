package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.GuestDTO;

public class MsgGetGuestByUserResponse {

	private ContextResponseDTO contextResponse;
	private List<GuestDTO> lstGuestDTO;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public List<GuestDTO> getLstGuestDTO() {
		return lstGuestDTO;
	}

	public void setLstGuestDTO(List<GuestDTO> lstGuestDTO) {
		this.lstGuestDTO = lstGuestDTO;
	}

}
