package com.bovkun.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bovkun.constants.LoggerConstants;
import com.bovkun.dao.FacultyDAO;
import com.bovkun.entities.Faculty;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * Realization of {@link FacultyDAO} interface
 * A class to manage information related to Application class from database
 * @author Alexander
 */
public class JdbcFacultyDAO implements FacultyDAO {
	private static final Logger logger = LogManager.getLogger(JdbcFacultyDAO.class);
	@Override
	public void create(Faculty e) {
		logger.warn(LoggerConstants.METHOD_CREATE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public boolean update(Faculty e) {
		logger.warn(LoggerConstants.METHOD_UPDATE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public boolean delete(int id) {
		logger.warn(LoggerConstants.METHOD_DELETE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public Faculty read(int id) {
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.FACULTIES_FIND_BY_ID);) {
			
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			
			return new Faculty().setId(resultSet.getInt(Constants.DB_ID))
					.setCapacity(resultSet.getInt(Constants.DB_CAPACITY))
					.setName(resultSet.getString(Constants.DB_NAME))
					.setSubjectOne(resultSet.getString(Constants.DB_SUBJECT_ONE))
					.setSubjectTwo(resultSet.getString(Constants.DB_SUBJECT_TWO))
					.setSubjectThree(resultSet.getString(Constants.DB_SUBJECT_THREE));
		} catch (SQLException e) {
			logger.log(Level.ERROR, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		} 
	}

	@Override
	public List<Faculty> findAll() {
		
		List<Faculty> faculties = new LinkedList<>();
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.FACULTIES_FIND_ALL);) {
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Faculty tmp = new Faculty().setName(resultSet.getString(Constants.DB_NAME))
						.setSubjectOne(resultSet.getString(Constants.DB_SUBJECT_ONE))
						.setSubjectTwo(resultSet.getString(Constants.DB_SUBJECT_TWO))
						.setSubjectThree(resultSet.getString(Constants.DB_SUBJECT_THREE))
						.setCapacity(resultSet.getInt(Constants.DB_CAPACITY))
						.setId(resultSet.getInt(Constants.DB_ID));
				faculties.add(tmp);
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		}
		return faculties;
	}

	@Override
	public Faculty findByName(String name) {
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.FACULTIES_FIND_BY_NAME);) {
			
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			
			return new Faculty().setId(resultSet.getInt(Constants.DB_ID))
					.setCapacity(resultSet.getInt(Constants.DB_CAPACITY))
					.setName(resultSet.getString(Constants.DB_NAME))
					.setSubjectOne(resultSet.getString(Constants.DB_SUBJECT_ONE))
					.setSubjectTwo(resultSet.getString(Constants.DB_SUBJECT_TWO))
					.setSubjectThree(resultSet.getString(Constants.DB_SUBJECT_THREE));
		} catch (SQLException e) {
			logger.log(Level.ERROR, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		}
	}
	
}
