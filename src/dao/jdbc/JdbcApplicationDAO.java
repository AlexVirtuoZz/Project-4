package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.ApplicationDAO;
import entities.Application;

public class JdbcApplicationDAO implements ApplicationDAO {

	@Override
	public void create(Application application) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.APPLICATIONS_UPSERT);
			statement.setInt(1, application.getUserId());
			statement.setInt(2, application.getFacultyId());
			statement.setInt(3, application.getResult());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		
	}

	@Override
	public boolean update(Application e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Application read(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.APPLICATIONS_FIND_BY_ID);
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
			e.printStackTrace();
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return null;
	}

	@Override
	public List<Application> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Application> findAllByUserId(int userId) {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Application> applications = new LinkedList<>();
		try{
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.APPLICATIONS_FIND_ALL_BY_USER_ID);
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
			e.printStackTrace();
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return applications;
	}

}
