package dao.jdbc;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import dao.UserDAO;
import entities.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import view.GlobalConstants;

public class JdbcUserDAO implements UserDAO {

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
			e.printStackTrace();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		throw new NotImplementedException();
	}

	@Override
	public User read(int id) {
		try {
			Connection cn = JdbcDAOFactory.getConnection();
			PreparedStatement statement = cn.prepareStatement(Queries.USER_FIND_BY_ID);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return new User( resultSet.getString("name"),
					resultSet.getString("second_name"),
					resultSet.getString("third_name"));
		} catch (SQLException e) {
			e.printStackTrace();
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
				tmp.setPassword(resultSet.getString(GlobalConstants.PASSWORD));
				users.add(tmp);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
		User tmp = null;
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.USER_FIND_BY_LOGIN);
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				tmp = new User(resultSet.getString(Constants.DB_NAME), resultSet.getString(Constants.DB_SECOND_NAME),
						resultSet.getString(Constants.DB_THIRD_NAME));
				tmp.setId(resultSet.getInt(GlobalConstants.ID));
				tmp.setLogin(resultSet.getString(GlobalConstants.LOGIN));
				tmp.setPassword(resultSet.getString(GlobalConstants.PASSWORD));
				tmp.setAdmin(resultSet.getBoolean(Constants.DB_ADMIN));
			}
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return null;
	}

}
