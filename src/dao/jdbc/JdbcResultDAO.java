package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import dao.DAOFactory;
import dao.ResultDAO;
public class JdbcResultDAO implements ResultDAO{

	@Override
	public void create(Map<String, Integer> e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(Map<String, Integer> e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Integer> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Integer>> findAll() {
		// TODO Auto-generated method stub
		return null;
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
			return grades;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcDAOFactory.closeStatement(statement);
			JdbcDAOFactory.closeConnection(connection);
		}
		
		return null;
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
				e.printStackTrace();
			} finally {
				JdbcDAOFactory.closeStatement(statement);
				JdbcDAOFactory.closeConnection(connection);
			}
		}
	}

	
}
