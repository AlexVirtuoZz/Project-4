package model;

import java.util.List;
import java.util.Map;

import dao.ApplicationDAO;
import dao.DAOFactory;
import dao.ResultDAO;
import dao.SubjectDAO;
import entities.Application;
import entities.User;

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
	
	public List<Application> findAllApplications(){
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		return applicationDAO.findAll();
	}

	public void acceptApplication(Integer appId) {
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		applicationDAO.acceptApplication(appId);
	}
	
	public Map<User, Integer> findAppliedStudent (int facultyId){
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		return applicationDAO.findAppliedStudents(facultyId);
	}
	
	public void declineApplication(Integer appId) {
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		applicationDAO.declineApplication(appId);
	}
}
