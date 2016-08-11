package com.epam.dao;

import java.util.List;
import java.util.Map;

import com.epam.entities.Application;
import com.epam.entities.User;
/**
 * Interface for realization Application Data Access Object
 * @see GenericDAO
 * @author Alexander
 *
 */
public interface ApplicationDAO extends GenericDAO<Application> {
	/**
	 * A method to find all applications related to the user in database
	 * @param userId - user's id
	 * @return list of Application objects
	 */
	List<Application> findAllByUserId(int userId);
	/**
	 * A method to accept application in database
	 * @param appId - application's id
	 */
	void acceptApplication(int appId);
	/**
	 * A method to cancel application in database
	 * @param appId - application's id
	 */
	void cancelApplication(int appId);
	/**
	 * A method to find all users (students) who applied for specified faculty
	 * @param facultyId - id of specified faculty
	 * @return map of user and user's result
	 */
	Map<User, Integer> findAppliedStudents(int facultyId);
}
