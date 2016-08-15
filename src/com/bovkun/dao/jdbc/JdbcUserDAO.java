package com.bovkun.dao.jdbc;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bovkun.constants.LoggerConstants;
import com.bovkun.dao.UserDAO;
import com.bovkun.entities.User;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * Realization of {@link UserDAO} interface
 * A class to manage information related to Application class from database
 * @author Alexander
 */
public class JdbcUserDAO implements UserDAO {
	private static final Logger logger = LogManager.getLogger(JdbcUserDAO.class);
	@Override
	public void create(User user) {
		if (!checkAvailableLogin(user.getLogin()))
			return;
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.USER_CREATE);) {
			connection.setAutoCommit(false);
			try {
				statement.setString(1, user.getName());
				statement.setString(2, user.getSecondName());
				statement.setString(3, user.getThirdName());
				statement.setString(4, user.getLogin());
				statement.setString(5, user.getPassword());
				statement.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				throw new SQLException();
			}			
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		} 
	}

	@Override
	public boolean update(User user) {
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.USER_UPDATE);) { 
			connection.setAutoCommit(false);
			try { 
				statement.setString(1, user.getName());
				statement.setString(2, user.getSecondName());
				statement.setString(3, user.getThirdName());
				statement.setString(4, user.getLogin());
				statement.setString(5, user.getPassword());
				statement.setInt(6, user.getId());
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
	public boolean delete(int id) {
		logger.warn(LoggerConstants.METHOD_DELETE_NOT_IMPL);
		throw new NotImplementedException();
	}

	@Override
	public User read(int id) {
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.USER_FIND_BY_ID);) {
			
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return new User( resultSet.getString(Constants.DB_NAME),
					resultSet.getString(Constants.DB_SECOND_NAME),
					resultSet.getString(Constants.DB_THIRD_NAME));
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		} 
	}

	@Override
	public List<User> findAll() {
		List<User> users = new LinkedList<>();
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.USER_FIND_ALL);) {
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User tmp = new User(resultSet.getString(Constants.DB_NAME),
				resultSet.getString(Constants.DB_SECOND_NAME),
				resultSet.getString(Constants.DB_THIRD_NAME));
				tmp.setId(resultSet.getInt(Constants.DB_ID));
				tmp.setLogin(resultSet.getString(Constants.DB_LOGIN));
				tmp.setAdmin(resultSet.getBoolean(Constants.DB_ADMIN));
				tmp.setPassword(resultSet.getString(Constants.DB_PASSWORD));
				users.add(tmp);
			}
			return users;
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		} 
	}

	public boolean checkAvailableLogin(String login){	
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.USER_FIND_BY_LOGIN);) {
			
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			return (!resultSet.next());
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		}
	}

	@Override
	public User findByLogin(String login) {
		
		User user = null;
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.USER_FIND_BY_LOGIN);) {
			
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getString(Constants.DB_NAME), 
				resultSet.getString(Constants.DB_SECOND_NAME),
				resultSet.getString(Constants.DB_THIRD_NAME));
				user.setId(resultSet.getInt(Constants.DB_ID));
				user.setLogin(resultSet.getString(Constants.DB_LOGIN));
				user.setPassword(resultSet.getString(Constants.DB_PASSWORD));
				user.setAdmin(resultSet.getBoolean(Constants.DB_ADMIN));
			}
		} catch (SQLException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_SQL, e);
			throw new RuntimeException();
		} 
		return user;
	}

	@Override
	public boolean setAdmin(int id) {
		
		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.USER_SET_ADMIN);) { 
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
	public boolean removeAdmin(int id) {

		try (Connection connection = JdbcDAOFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.USER_REMOVE_ADMIN);) { 
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

}
