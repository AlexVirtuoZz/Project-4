package dao;

import java.util.Map;

public interface ResultDAO extends GenericDAO<Map<String, Integer>> {
	Map<String, Integer> readByUserId(int userId);
	void update(Map<String, Integer> grades, int i);
}
