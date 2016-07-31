package dao;

import java.util.List;

import entities.Application;

public interface ApplicationDAO extends GenericDAO<Application> {
	List<Application> findAllByUserId(int userId);
}
