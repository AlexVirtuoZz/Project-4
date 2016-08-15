package com.bovkun.dao;

import java.util.Map;
/**
 * Interface for realization Result Data Access Object
 * @see GenericDAO
 * @author Alexander
 *
 */
public interface ResultDAO extends GenericDAO<Map<String, Integer>> {
	/**
	 * A method to get user results by user id
	 * @param userId - user's id
	 * @return Map <subject name, result value>
	 */
	Map<String, Integer> readByUserId(int userId);
	/**
	 * A method to update results information
	 * @param grades Map<subject name, result value>
	 * @param i - new result value
	 */
	void update(Map<String, Integer> grades, int i);
}
