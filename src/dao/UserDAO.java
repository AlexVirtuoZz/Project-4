package dao;


import entities.User;

public interface UserDAO extends GenericDAO<User>{

	boolean checkAvailableLogin(String login);
	User findByLogin(String login);
}
