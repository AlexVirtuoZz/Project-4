package com.epam.dao;

import java.util.List;
/**
 * Generic interface for Data Access Object realization
 * @author Alexander
 * @param <E>
 */
interface GenericDAO<E> {
	/**
	 * A method to make new record in database
	 * @param e - values to be inserted into database
	 */
	void create(E e);
	/**
	 * A method to update information in database
	 * @param e - values to be updated in database 
	 * @return true, if updated successfully
	 */
	boolean update(E e);
	/**
	 * A method to delete information from database
	 * @param id - id of column to be deleted
	 * @return true if deleted successfully
	 */
	boolean delete(int id);
	/**
	 * A method to get an object E with values from database
	 * @param id - id of column (object) to be read
	 * @return specified object 
	 */
	E read(int id);
	/**
	 * A method to find all available objects from database
	 * @return list of objects E
	 */
	List<E> findAll();
}
