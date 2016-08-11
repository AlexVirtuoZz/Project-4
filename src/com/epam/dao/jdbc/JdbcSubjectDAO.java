package com.epam.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.GlobalConstants;
import com.epam.constants.LoggerConstants;
import com.epam.dao.SubjectDAO;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * Realization of {@link SubjectDAO} interface
 * A class to manage information related to Application class from database
 * @author Alexander
 */
public class JdbcSubjectDAO implements SubjectDAO {
	private static final Logger logger = LogManager.getLogger();
	@Override
	public void create(String e) {
		logger.warn(LoggerConstants.METHOD_CREATE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public boolean update(String e) {
		logger.warn(LoggerConstants.METHOD_UPDATE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public boolean delete(int id) {
		logger.warn(LoggerConstants.METHOD_DELETE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public String read(int id) {
		logger.warn(LoggerConstants.METHOD_READ_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public List<String> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		List<String> subjects = new LinkedList<>();
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.SUBJECT_FIND_ALL);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				subjects.add(resultSet.getString(GlobalConstants.NAME));
			}
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return subjects;
	}

}
