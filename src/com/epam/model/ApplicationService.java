package com.epam.model;

import java.util.List;
import java.util.Map;

import com.epam.dao.ApplicationDAO;
import com.epam.dao.DAOFactory;
import com.epam.dao.ResultDAO;
import com.epam.dao.SubjectDAO;
import com.epam.entities.Application;
import com.epam.entities.User;
/**
 * Class to manage ApplicationDAO and SubjectDAO methods
 * @author Alexander
 *
 */
public class ApplicationService {
	private static ApplicationService resultService = new ApplicationService();
	public static ApplicationService getInstance(){
		return resultService;
	}
	/**
	 * @see ApplicationDAO#create(Application)
	 * @param application
	 */
	public void createApplication(Application application){
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		applicationDAO.create(application);
	}
	/**
	 * @see ResultDAO#update(Map)
	 * @param results map of subject name (key) and result (value) 
	 * @param userId user's id
	 */
	public void updateResult(Map<String, Integer> results, int userId){
		ResultDAO resultDAO = DAOFactory.getFactory().createResultDAO();
		resultDAO.update(results, userId);
	}
	/**
	 * @see ResultDAO#readByUserId(int)
	 * @param userId user's id
	 * @return map of subject name (key) and result (value)
	 */
	public Map<String, Integer> readResultByUserId(int userId) {
		ResultDAO resultDAO = DAOFactory.getFactory().createResultDAO();
		return resultDAO.readByUserId(userId);
	}
	/**
	 * @see ApplicationDAO#findAllByUserId(int)
	 * @param userId user's id
	 * @return list of all applications related to specified user
	 */
	public List<Application> findAllByUserId(int userId){
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		return applicationDAO.findAllByUserId(userId);
	}
	/**
	 * @see SubjectDAO#findAll()
	 * @return list of all available subjects (names)
	 */
	public List<String> findAllSubjects(){
		SubjectDAO subjectDAO = DAOFactory.getFactory().createSubjectDAO();
		return subjectDAO.findAll();
	}
	/**
	 * @see ApplicationDAO#findAll()
	 * @return list of all available applications
	 */
	public List<Application> findAllApplications(){
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		return applicationDAO.findAll();
	}
	/**
	 * @see ApplicationDAO#acceptApplication(int)
	 * @param appId - application's id
	 */
	public void acceptApplication(Integer appId) {
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		applicationDAO.acceptApplication(appId);
	}
	/**
	 * @see ApplicationDAO#findAppliedStudents(int)
	 * @param facultyId - id of faculty, on what students've applied
	 * @return map of user (key) and his result on current faculty (value)
	 */
	public Map<User, Integer> findAppliedStudent (int facultyId){
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		return applicationDAO.findAppliedStudents(facultyId);
	}
	/**
	 * @see ApplicationDAO#cancelApplication(int)
	 * @param appId - application's id
	 */
	public void cancelApplication(Integer appId) {
		ApplicationDAO applicationDAO = DAOFactory.getFactory().createApplicationDAO();
		applicationDAO.cancelApplication(appId);
	}
}
