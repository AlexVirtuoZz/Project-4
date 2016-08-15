package com.bovkun.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bovkun.constants.LoggerConstants;
import com.bovkun.dao.ApplicationDAO;
import com.bovkun.entities.Application;
import com.bovkun.entities.User;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * Realization of {@link ApplicationDAO} interface
 * A class to manage information related to Application class from database
 * @author Alexander
 */
public class JdbcApplicationDAO implements ApplicationDAO {
	private final static Logger logger = LogManager.getLogger(JdbcApplicationDAO.class);
	
	@Override
	public void create(Application application) {		
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.APPLICATIONS_UPSERT);) {
			connection.setAutoCommit(false);
			try {
				statement.setInt(1, application.getUserId());
				statement.setInt(2, application.getFacultyId());
				statement.setInt(3, application.getResult());
				statement.executeUpdate();
				connection.commit();
			} catch (SQLException e){
				connection.rollback();
				throw new SQLException();
			}
			
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		} 
	}

	@Override
	public boolean update(Application e) {
		logger.warn(LoggerConstants.METHOD_UPDATE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public boolean delete(int id) {
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.APPLICATIONS_DELETE);){
			connection.setAutoCommit(false);
			try {
				statement.setInt(1, id);
				statement.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				throw new SQLException();
			}
			return true;
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		}
	}

	@Override
	public Application read(int id) {
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.APPLICATIONS_FIND_BY_ID);) {
			
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			Application tmp = new Application();
				tmp.setId(resultSet.getInt(Constants.DB_ID));
				tmp.setUserId(resultSet.getInt(Constants.DB_USER_ID));
				tmp.setFacultyId(resultSet.getInt(Constants.DB_FACULTY_ID));
				tmp.setResult(resultSet.getInt(Constants.DB_RESULT));
			return tmp;	
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		} 
	}

	@Override
	public List<Application> findAll() {
		
		List<Application> applications = new LinkedList<>();
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.APPLICATIONS_FIND_ALL);) {
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()){
			Application tmp = new Application();
				tmp.setId(resultSet.getInt(Constants.DB_ID));
				tmp.setUserId(resultSet.getInt(Constants.DB_USER_ID));
				tmp.setFacultyId(resultSet.getInt(Constants.DB_FACULTY_ID));
				tmp.setResult(resultSet.getInt(Constants.DB_RESULT));
				tmp.setAccepted(resultSet.getBoolean(Constants.DB_ACCEPTED));
				applications.add(tmp);	
			} 
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		} 
		return applications;
	}
	
	 
	@Override
	public List<Application> findAllByUserId(int userId) {
		
		List<Application> applications = new LinkedList<>();
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.APPLICATIONS_FIND_ALL_BY_USER_ID);) {
			
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()){
			Application tmp = new Application();
				tmp.setId(resultSet.getInt(Constants.DB_ID));
				tmp.setUserId(resultSet.getInt(Constants.DB_USER_ID));
				tmp.setFacultyId(resultSet.getInt(Constants.DB_FACULTY_ID));
				tmp.setResult(resultSet.getInt(Constants.DB_RESULT));
				tmp.setAccepted(resultSet.getBoolean(Constants.DB_ACCEPTED));
				applications.add(tmp);	
			} 
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		}
		return applications;
	}

	@Override
	public void acceptApplication(int appId) {
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.APPLICATIONS_ACCEPT);) {
			connection.setAutoCommit(false);
			try {
				statement.setInt(1, appId);
				statement.executeUpdate();
				connection.commit();
			} catch (SQLException e){
				connection.rollback();
				throw new SQLException();
			}
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		}
	}

	@Override
	public void cancelApplication(int appId) {
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.APPLICATIONS_DECLINE);) {
			connection.setAutoCommit(false);
			try {
				statement.setInt(1, appId);
				statement.executeUpdate();
				connection.commit();
			} catch (SQLException e){
				connection.rollback();
				throw new SQLException();
			}
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		}
	}

	@Override
	public Map<User, Integer> findAppliedStudents(int facultyId) {
		
		Map<User, Integer> appliedStudents = new LinkedHashMap<>();
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.APPLICATIONS_FIND_APPLIED_STUDENTS);) {
			
			statement.setInt(1, facultyId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				User tmp = new User(resultSet.getString(Constants.DB_NAME),
						resultSet.getString(Constants.DB_SECOND_NAME),
						resultSet.getString(Constants.DB_THIRD_NAME));
				appliedStudents.put(tmp, resultSet.getInt(Constants.DB_RESULT));
			}
			return appliedStudents;
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		} 
	}

}
