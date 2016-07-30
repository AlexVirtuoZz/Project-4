package model;

import java.util.List;

import dao.DAOFactory;
import dao.UserDAO;
import entities.User;

public class UserService {

	private static UserService userDAO = new UserService();
	public static UserService getInstance() {
		return userDAO;
	}
	
	public List<User> findAll(){
		
		UserDAO userDAO = createUserDAO();
		return userDAO.findAll();
		
	}
	
	public void update(User user){
		UserDAO userDAO = createUserDAO();
		userDAO.update(user);
	}
	
	public void create(User user){
		UserDAO userDAO = createUserDAO();
		userDAO.create(user);
	}
	
	public User find(final String login){
		UserDAO userDAO = createUserDAO();
		return userDAO.findByLogin(login);
	}
	
	public boolean checkAvailableLogin(String login){
		UserDAO userDAO = createUserDAO();
		return userDAO.checkAvailableLogin(login); 
	}
	
	private UserDAO createUserDAO(){
		return DAOFactory.getFactory().createUserDAO();
	}
	
}
