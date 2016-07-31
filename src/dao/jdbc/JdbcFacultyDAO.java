package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dao.FacultyDAO;
import entities.faculty.Faculty;

public class JdbcFacultyDAO implements FacultyDAO {

	@Override
	public void create(Faculty e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(Faculty e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Faculty read(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.FACULTIES_FIND_BY_ID);
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
			e.printStackTrace();
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return null;
	}

	@Override
	public List<Faculty> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Faculty> faculties = new LinkedList<>();
		try {
			connection = JdbcDAOFactory.getConnection();
			statement = connection.prepareStatement(Queries.FACULTIES_FIND_ALL);
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
			return faculties;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return null;
	}
	
}
