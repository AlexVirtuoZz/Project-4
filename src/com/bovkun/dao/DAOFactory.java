package com.bovkun.dao;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bovkun.constants.LoggerConstants;

/**
 * Abstract class for creating specific Data Access Objects
 * @author Alexander
 *
 */
public abstract class DAOFactory {
	private static final Logger logger = LogManager.getLogger();
	
	public abstract UserDAO createUserDAO();
	public abstract FacultyDAO createFacultyDAO();
	public abstract ApplicationDAO createApplicationDAO();
	public abstract ResultDAO createResultDAO();
	public abstract SubjectDAO createSubjectDAO();
	
	public static DAOFactory getFactory(){
		
			try {
				return (DAOFactory) Class.forName(Constants.JDBC_FACTORY_PATH).newInstance();
			} catch (InstantiationException e) {
				logger.log(Level.ERROR, LoggerConstants.EXCEPTION_INSTANTIATION, e);
			} catch (IllegalAccessException e) {
				logger.log(Level.WARN, LoggerConstants.EXCEPTION_ILLEGAL_ACCESS, e);
			} catch (ClassNotFoundException e) {
				logger.log(Level.ERROR, LoggerConstants.EXCEPTION_CLASS_NOT_FOUND, e);
			}
			return null;
	}
	
}
