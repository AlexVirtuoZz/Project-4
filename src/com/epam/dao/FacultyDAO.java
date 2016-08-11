package com.epam.dao;

import com.epam.entities.Faculty;
/**
 * Interface for realization Faculty Data Access Object
 * @see GenericDAO
 * @author Alexander
 *
 */
public interface FacultyDAO extends GenericDAO<Faculty> {
	/**
	 * A method to get Faculty object from database by its name
	 * @param name - faculty's name
	 * @return Faculty object
	 */
	Faculty findByName(String name);
}
