package com.epam.dao;

import com.epam.entities.User;
/**
 * Interface for realization User Data Access Object
 * @see GenericDAO
 * @author Alexander
 *
 */
public interface UserDAO extends GenericDAO<User>{
	/**
	 * A method to check if specified login is taken or not
	 * @param login - specified login
	 * @return true if specified login is not taken
	 */
	boolean checkAvailableLogin(String login);
	
	/**
	 * A method to get User by its login
	 * @param login - user's login in database
	 * @return new User object
	 */
	User findByLogin(String login);
}
