package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DAOFactory;
import dao.FacultyDAO;
import entities.Faculty;

public class FacultyService {
	private static FacultyService facultyService = new FacultyService();
	
	public static FacultyService getInstance(){
		return facultyService;
	}
	
	public List<Faculty> findAll(){
		FacultyDAO facultyDAO = DAOFactory.getFactory().createFacultyDAO();
		return facultyDAO.findAll();
	}
	
	public Faculty findByName(String name){
		FacultyDAO facultyDAO = DAOFactory.getFactory().createFacultyDAO();
		List<Faculty> tmp = facultyDAO.findAll();
		for (Faculty faculty : tmp)
			if (faculty.getName().equalsIgnoreCase(name))
				return faculty;
		return null;			
	}
	
	public Faculty findById(int id){
		FacultyDAO facultyDAO = DAOFactory.getFactory().createFacultyDAO();
		return facultyDAO.read(id);
	}
	
}
