package com.bovkun.model;

import java.util.List;

import com.bovkun.dao.DAOFactory;
import com.bovkun.dao.UserDAO;
import com.bovkun.entities.User;
/**
 * A class to manage UserDAO methods
 * @author Alexander
 *
 */
public class UserService {

	private static UserService userDAO = new UserService();
	public static UserService getInstance() {
		return userDAO;
	}
	/**
	 * @see UserDAO#findAll()
	 * @return list of all available users
	 */
	public List<User> findAll(){
		UserDAO userDAO = createUserDAO();
		return userDAO.findAll();
		
	}
	/**
	 * @see UserDAO#update(User)
	 * @param user - specified user
	 */
	public void update(User user){
		UserDAO userDAO = createUserDAO();
		userDAO.update(user);
	}
	/**
	 * @see UserDAO#create(User)
	 * @param user - specified user
	 */
	public void create(User user){
		UserDAO userDAO = createUserDAO();
		userDAO.create(user);
	}
	/**
	 * @see UserDAO#findByLogin(String)
	 * @param login - user's login
	 * @return specified user
	 */
	public User find(final String login){
		UserDAO userDAO = createUserDAO();
		return userDAO.findByLogin(login);
	}
	/**
	 * @see UserDAO#checkAvailableLogin(String)
	 * @param login - user's login
	 * @return true, if specified user login doesn't exist
	 */
	public boolean checkAvailableLogin(String login){
		UserDAO userDAO = createUserDAO();
		return userDAO.checkAvailableLogin(login); 
	}
	/**
	 * @see UserDAO#setAdmin(int)
	 * @param id - user's id
	 * @return true if operation succeed
	 */
	public boolean setAdmin(int id){
		UserDAO userDAO = createUserDAO();
		return userDAO.setAdmin(id);
	}
	/**
	 * @see UserDAO#removeAdmin(int)
	 * @param id - user's id
	 * @return true if operation succeed
	 */
	public boolean removeAdmin(int id){
		UserDAO userDAO = createUserDAO();
		return userDAO.removeAdmin(id);
	}
	/**
	 * A method to get realization of UserDAO interface
	 * @return JdbcUserDAO
	 * @since 10.08.16
	 */
	protected UserDAO createUserDAO(){
		return DAOFactory.getFactory().createUserDAO();
	}
}
