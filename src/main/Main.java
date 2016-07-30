package main;

import java.util.List;

import dao.DAOFactory;
import dao.FacultyDAO;
import dao.UserDAO;
import entities.User;
import entities.faculty.Faculty;

public class Main {

	public static void main(String[] args) {

			DAOFactory jdbcDAOFactory = DAOFactory.getFactory();
			UserDAO userDAO = jdbcDAOFactory.createUserDAO();
			FacultyDAO facultyDAO = jdbcDAOFactory.createFacultyDAO();
			
			for (Faculty faculty : facultyDAO.findAll())
				System.out.println(faculty);
	}

}
