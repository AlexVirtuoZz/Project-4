package com.epam.dao.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.LoggerConstants;
import com.epam.dao.ResultDAO;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * Realization of {@link ResultDAO} interface
 * A class to manage information related to Application class from database
 * @author Alexander
 */
public class JdbcResultDAO implements ResultDAO{
	private static final Logger logger = LogManager.getLogger();
	@Override
	public void create(Map<String, Integer> e) {
		logger.warn(LoggerConstants.METHOD_CREATE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public boolean update(Map<String, Integer> e) {
		logger.warn(LoggerConstants.METHOD_UPDATE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public boolean delete(int id) {
		logger.warn(LoggerConstants.METHOD_DELETE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public Map<String, Integer> read(int id) {
		logger.warn(LoggerConstants.METHOD_READ_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public List<Map<String, Integer>> findAll() {
		logger.warn(LoggerConstants.METHOD_FINDALL_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public Map<String, Integer> readByUserId(int userId) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		HashMap<String, Integer> grades = new HashMap<>();
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.RESULT_FIND_BY_USER_ID);
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				grades.put(resultSet.getString(Constants.DB_NAME), resultSet.getInt(Constants.DB_GRADE));
			}
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return grades;
	}

	@Override
	public void update(Map<String, Integer> grades, int userId) {
		Connection connection = null;
		PreparedStatement statement = null;
		for (Entry<String, Integer> grade : grades.entrySet()){
			try {
				connection = JdbcDAOFactory.getConnection();
				statement = connection.prepareStatement(Queries.RESULT_UPSERT);
				statement.setString(1, grade.getKey());
				statement.setInt(2, userId);
				statement.setInt(3, grade.getValue());
				statement.executeUpdate();
			} catch (SQLException e) {
				logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			} finally {
				JdbcDAOFactory.closeStatement(statement);
				JdbcDAOFactory.closeConnection(connection);
			}
		}
	}

	
}
