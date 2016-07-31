package model;

import java.util.List;
import java.util.Map;

import dao.ApplicationDAO;
import dao.DAOFactory;
import dao.ResultDAO;
import dao.SubjectDAO;
import entities.Application;

public class ApplicationService {
	private static ApplicationService resultService = new ApplicationService();
	public static ApplicationService getInstance(){
		return resultService;
	}
	
	public void createApplication(Application application){
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		applicationDAO.create(application);
	}
	
	public void updateResult(Map<String, Integer> results, int userId){
		ResultDAO resultDAO = DAOFactory.getFactory().createResultDAO();
		resultDAO.update(results, userId);
	}
	
	public Map<String, Integer> readResultByUserId(int userId) {
		ResultDAO resultDAO = DAOFactory.getFactory().createResultDAO();
		return resultDAO.readByUserId(userId);
	}
	
	public List<Application> findAllByUserId(int userId){
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		return applicationDAO.findAllByUserId(userId);
	}
	
	public List<String> findAllSubjects(){
		SubjectDAO subjectDAO = DAOFactory.getFactory().createSubjectDAO();
		return subjectDAO.findAll();
	}
}
