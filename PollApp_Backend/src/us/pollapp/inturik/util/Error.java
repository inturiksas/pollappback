package us.pollapp.inturik.util;

import java.util.logging.Logger;

public class Error {

	private static final Logger log = Logger.getLogger(Error.class.getName());

	public static void SendError(String message) {

		try {

			log.info(message);
			log.severe(message);

			Email.sendEmail(Constant.EMAIL_SEND_ERROR, message,
					"Error backend Pollapp !!");

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}
