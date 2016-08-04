package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import constants.GlobalConstants;
import dao.SubjectDAO;
import entities.User;

public class JdbcSubjectDAO implements SubjectDAO {

	@Override
	public void create(String e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(String e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String read(int id) {
		// TODO Auto-generated method stub
		return null;
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
			return subjects;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		return null;
	}

}
