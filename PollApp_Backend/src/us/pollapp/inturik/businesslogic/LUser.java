package us.pollapp.inturik.businesslogic;

import java.util.List;
import java.util.logging.Logger;

import us.pollapp.inturik.dao.IUserDAO;
import us.pollapp.inturik.dao.UserDAO;
import us.pollapp.inturik.model.User;

/**
 * @author Juan Guillermo Gómez
 */
public class LUser {

	private static final Logger log = Logger.getLogger(LGuest.class.getName());

	private IUserDAO userDAO;

	public LUser() {
		userDAO = new UserDAO();

	}

	public User getUserById(int idUser) throws Exception {

		try {
			User user = userDAO.findById(idUser);
			return user;
		} catch (Exception e) {
			throw e;
		}

	}

	public void addUser(String name, String lastName, String email,
			String password) throws Exception {

		try {
			User objUser = new User();
			objUser.setName(name);
			objUser.setLastname(lastName);
			objUser.setEmail(email);
			objUser.setPassword(password);

			userDAO.save(objUser);

		} catch (Exception e) {
			throw e;
		}

	}

	public User getUserByEmail(String email) throws Exception {

		try {
			List<User> lstUser = userDAO.findByEmail(email, null);

			if (lstUser != null && lstUser.size() > 0) {
				return lstUser.get(0);
			}

			return null;

		} catch (Exception e) {
			throw e;
		}

	}

	public User getUserByEmailByPassword(String email, String password)
			throws Exception {

		try {

			log.info("Buscando el usuario por email y password");
			log.info(email);
			log.info(password);

			return userDAO.findByEmailByPassword(email, password);

		} catch (Exception e) {
			throw e;
		}

	}

}
