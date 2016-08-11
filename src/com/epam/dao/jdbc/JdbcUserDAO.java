package com.epam.dao.jdbc;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.GlobalConstants;
import com.epam.constants.LoggerConstants;
import com.epam.dao.UserDAO;
import com.epam.entities.User;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * Realization of {@link UserDAO} interface
 * A class to manage information related to Application class from database
 * @author Alexander
 */
public class JdbcUserDAO implements UserDAO {
	private static final Logger logger = LogManager.getLogger();
	@Override
	public void create(User user) {
		if (!checkAvailableLogin(user.getLogin()))
			return;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.USER_CREATE);
			statement.setString(1, user.getName());
			statement.setString(2, user.getSecondName());
			statement.setString(3, user.getThirdName());
			statement.setString(4, user.getLogin());
			statement.setString(5, user.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}

	}

	@Override
	public boolean update(User user) {
		Connection connection = null;
		PreparedStatement statement = null;
		try { 
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.USER_UPDATE);
			statement.setString(1, user.getName());
			statement.setString(2, user.getSecondName());
			statement.setString(3, user.getThirdName());
			statement.setString(4, user.getLogin());
			statement.setString(5, user.getPassword());
			statement.setInt(6, user.getId());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			return false;
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
	}

	@Override
	public boolean delete(int id) {
		logger.warn(LoggerConstants.METHOD_DELETE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public User read(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.USER_FIND_BY_ID);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return new User( resultSet.getString(Constants.DB_NAME),
					resultSet.getString(Constants.DB_SECOND_NAME),
					resultSet.getString(Constants.DB_THIRD_NAME));
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		List<User> users = new LinkedList<>();
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.USER_FIND_ALL);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User tmp = new User(resultSet.getString(GlobalConstants.NAME), resultSet.getString(GlobalConstants.SECOND_NAME),
				resultSet.getString(GlobalConstants.THIRD_NAME));
				tmp.setId(resultSet.getInt(GlobalConstants.ID));
				tmp.setLogin(resultSet.getString(GlobalConstants.LOGIN));
				tmp.setAdmin(resultSet.getBoolean(GlobalConstants.ADMIN));
				tmp.setPassword(resultSet.getString(GlobalConstants.PASSWORD));
				users.add(tmp);
			}
			return users;
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return null;
	}

	public boolean checkAvailableLogin(String login){	
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.USER_FIND_BY_LOGIN);
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			return (!resultSet.next());
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return false;
	}

	@Override
	public User findByLogin(String login) {
		Connection connection = null;
		PreparedStatement statement = null;
		User user = null;
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.USER_FIND_BY_LOGIN);
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getString(Constants.DB_NAME), resultSet.getString(Constants.DB_SECOND_NAME),
						resultSet.getString(Constants.DB_THIRD_NAME));
				user.setId(resultSet.getInt(GlobalConstants.ID));
				user.setLogin(resultSet.getString(GlobalConstants.LOGIN));
				user.setPassword(resultSet.getString(GlobalConstants.PASSWORD));
				user.setAdmin(resultSet.getBoolean(Constants.DB_ADMIN));
			}
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return user;
	}

}
