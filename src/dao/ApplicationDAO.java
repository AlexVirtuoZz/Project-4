package dao;

import java.util.List;
import java.util.Map;

import entities.Application;
import entities.User;

public interface ApplicationDAO extends GenericDAO<Application> {
	List<Application> findAllByUserId(int userId);
	void acceptApplication(int appId);
	void declineApplication(int appId);
	Map<User, Integer> findAppliedStudents(int facultyId);
}
