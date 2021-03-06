package us.pollapp.inturik.businesslogic;

import java.util.List;
import java.util.logging.Logger;

import us.pollapp.inturik.dao.EntityManagerHelper;
import us.pollapp.inturik.dao.GuestDAO;
import us.pollapp.inturik.dao.IGuestDAO;
import us.pollapp.inturik.model.Guest;
import us.pollapp.inturik.model.Pollas;
import us.pollapp.inturik.model.User;
import us.pollapp.inturik.util.Constant;
import us.pollapp.inturik.util.Email;
import us.pollapp.inturik.util.Messages;

public class LGuest {

	private static final Logger log = Logger.getLogger(LGuest.class.getName());

	/**
	 * Registra una invitación a la polla
	 * 
	 * @param email
	 *            Email del invitado
	 * @param idPolla
	 *            Polla a la cual esta siendo invitado
	 * @param idUser
	 *            Usuario invitado
	 * @throws Exception
	 */
	public void addGuest(String email, int idPolla, int idUser)
			throws Exception {

		try {

			// TODO: validaciones

			log.info("Se insertara como invitado. Email :" + email);

			Pollas objPollas = new Pollas();
			objPollas.setId(idPolla);

			Guest objGuest = new Guest();
			objGuest.setAccepted(false);
			objGuest.setEmail(email);
			objGuest.setInvitationSent(true);
			objGuest.setPollas(objPollas);
			objGuest.setReplied(false);

			if (idUser != 0) {
				User objUser = new User();
				objUser.setId(idUser);
				objGuest.setUser(objUser);
			}

			IGuestDAO objGuestDAO = new GuestDAO();
			objGuestDAO.save(objGuest);

		} catch (Exception e) {
			log.info("Error = " + e.getMessage());
			throw e;
		}

	}

	/**
	 * Actualiza el estado aceptado de una invitación
	 * 
	 * @param idPolla
	 * @param idUser
	 * @param accepted
	 * @throws Exception
	 */
	public void updateAcceptedInvitation(int idPolla, int idUser,
			boolean accepted) throws Exception {

		try {

			// TODO: validaciones

			log.info("Se actualiza estado de la invitación. IdUser = " + idUser
					+ " IdPolla = " + idPolla);

			IGuestDAO objGuestDAO = new GuestDAO();
			Guest objGuest = objGuestDAO.findByPollaByUser(idPolla, idUser);

			if (objGuest != null) {
				try {

					objGuest.setAccepted(accepted);
					objGuest.setReplied(true);
					objGuestDAO.update(objGuest);

					log.info("Se actualiza correctamente el estado de la invitación");

				} catch (Exception e) {
					log.info("Error = " + e.getMessage());
					throw e;
				}
			}

		} catch (Exception e) {
			log.info("Error = " + e.getMessage());
			throw e;
		}

	}

	/**
	 * Actualiza invitación
	 * 
	 * @param idGuest
	 * @param accepted
	 * @param idUser
	 * @param invitationSent
	 * @throws Exception
	 */
	public void updateGuest(int idGuest, boolean accepted, int idUser,
			boolean invitationSent) throws Exception {

		try {

			// TODO: validaciones

			IGuestDAO objGuestDAO = new GuestDAO();
			Guest objGuest = objGuestDAO.findById(idGuest);

			User userGuest = objGuest.getUser();

			if (userGuest == null) {
				userGuest = new User();
				userGuest.setId(idUser);
				objGuest.setUser(userGuest);
			}

			objGuest.setAccepted(accepted);
			objGuest.setInvitationSent(invitationSent);

			objGuestDAO.update(objGuest);

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Busca si tiene invitaciones pendientes y si las tiene actualiza los datos
	 * de la invitación
	 * 
	 * @param emailUser
	 * @param idUser
	 * @return
	 * @throws Exception
	 */
	public boolean hasPendingInvitation(String emailUser, int idUser)
			throws Exception {

		try {

			// TODO: validaciones

			boolean hasPendingInvitation = false;

			IGuestDAO objGuestDAO = new GuestDAO();
			List<Guest> lstGuest = objGuestDAO.findByEmail(emailUser, null);

			if (lstGuest != null && !lstGuest.isEmpty()) {

				for (Guest guest : lstGuest) {
					updateGuest(guest.getId(), false, idUser, true);
				}

				hasPendingInvitation = true;
			}

			return hasPendingInvitation;

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Elimina la invitación
	 * 
	 * @param idGuest
	 * @throws Exception
	 */
	public void deleteGuest(int idGuest) throws Exception {

		try {

			// TODO: validaciones

			log.info("Se eliminara la invitación. Id = " + idGuest);

			IGuestDAO objGuestDAO = new GuestDAO();
			Guest guest = objGuestDAO.findById(idGuest);

			if (guest != null && guest.getAccepted() == false) {

				try {
					EntityManagerHelper.beginTransaction();

					objGuestDAO.delete(guest);

					log.info("Invitación eliminada");

					EntityManagerHelper.commit();

				} catch (Exception e) {
					log.info("Error = " + e.getMessage());
					EntityManagerHelper.rollback();
					throw e;
				}
			} else {
				throw new Exception(Messages.MSG_00002);
			}

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene todas las invitaciones realizadas a un usuario no aceptadas
	 * 
	 * @param idUser
	 * @return
	 * @throws Exception
	 */
	public List<Guest> getGuestByUser(int idUser) throws Exception {

		try {

			// TODO: validaciones					

			IGuestDAO objGuestDAO = new GuestDAO();
			List<Guest> lstGuest = objGuestDAO.findByUser(idUser);

			return lstGuest;

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene los usuarios de las invitaciones de una polla
	 * 
	 * @param idPolla
	 * @return List<User> Lista de usuarios
	 * @throws Exception
	 */
	public List<Guest> getGuestByPolla(int idPolla) throws Exception {

		try {

			// TODO: validaciones						

			IGuestDAO objGuestDAO = new GuestDAO();
			List<Guest> lstGuest = objGuestDAO.findByPolla(idPolla);

			return lstGuest;

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Obtiene los usuarios de las invitaciones de una polla por email
	 * 
	 * @param idPolla
	 * @return List<User> Lista de usuarios
	 * @throws Exception
	 */
	public List<Guest> getGuestByPollaByEmail(int idPolla, String email)
			throws Exception {

		try {

			// TODO: validaciones			
			
			IGuestDAO objGuestDAO = new GuestDAO();
			List<Guest> lstGuest = objGuestDAO.findByPollaByEmail(idPolla,
					email);

			return lstGuest;

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Envia los correos a los invitados de la polla
	 * 
	 * @param emails
	 *            Correos de los invitados
	 * @param nameCompleteUser
	 *            Nombre completo del amigo que los invita
	 * @param namePolla
	 *            Nombre de la polla
	 * @throws Exception
	 */
	public void sendEmailGuestUsers(List<String> emails, String nameCompleteUser, String namePolla)
			throws Exception {

		try {

			Email.sendEmail(emails,
					String.format(Constant.EMAIL_BODY_GUEST, nameCompleteUser, namePolla),
					String.format(Constant.EMAIL_SUBJECT_GUEST, nameCompleteUser, namePolla));

		} catch (Exception e) {
			log.info("Error = " + e.getMessage());
			throw e;
		}

	}

}
