package com.bovkun.model;

import java.util.List;

import com.bovkun.dao.DAOFactory;
import com.bovkun.dao.FacultyDAO;
import com.bovkun.entities.Faculty;
/**
 * A class to manage FacultyDAO methods
 * @author Alexander
 *
 */
public class FacultyService {
	private static FacultyService facultyService = new FacultyService();
	public static FacultyService getInstance(){
		return facultyService;
	}
	/**
	 * @see FacultyDAO#findAll()
	 * @return list of all available faculties
	 */
	public List<Faculty> findAll(){
		FacultyDAO facultyDAO = DAOFactory.getFactory().createFacultyDAO();
		return facultyDAO.findAll();
	}
	/**
	 * @see FacultyDAO#findByName(String)
	 * @param name - faculty's name
	 * @return specified Faculty object
	 */
	public Faculty findByName(String name){
		FacultyDAO facultyDAO = DAOFactory.getFactory().createFacultyDAO();
		return facultyDAO.findByName(name);
	}
	/**
	 * @see FacultyDAO#read(int)
	 * @param id faculty's id
	 * @return specified Faculty object
	 */
	public Faculty findById(int id){
		FacultyDAO facultyDAO = DAOFactory.getFactory().createFacultyDAO();
		return facultyDAO.read(id);
	}
	
}
