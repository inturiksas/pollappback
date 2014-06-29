package us.pollapp.inturik.endpoints.utils;

import java.util.Date;

import us.pollapp.inturik.DTO.ContextRequestDTO;
import us.pollapp.inturik.DTO.ContextResponseDTO;

public class UtilContext {

	public static ContextResponseDTO getFillContextResponseDTOBasic(
			ContextRequestDTO request) {

		ContextResponseDTO contextResponse = new ContextResponseDTO();
		contextResponse.setIdTransaccion(request.getIdTransaction());
		contextResponse.setTransactionDate(new Date());
		contextResponse.setTransactionState(true);

		return contextResponse;

	}
	
	public static ContextResponseDTO getFillContextResponseDTOBasic(
			String idTransaction) {

		ContextResponseDTO contextResponse = new ContextResponseDTO();
		contextResponse.setIdTransaccion(idTransaction);
		contextResponse.setTransactionDate(new Date());
		contextResponse.setTransactionState(true);

		return contextResponse;

	}

}
