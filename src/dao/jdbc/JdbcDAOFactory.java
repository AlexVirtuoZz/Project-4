package dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dao.ApplicationDAO;
import dao.DAOFactory;
import dao.FacultyDAO;
import dao.ResultDAO;
import dao.SubjectDAO;
import dao.UserDAO;

public class JdbcDAOFactory extends DAOFactory {
	private static DataSource dataSource;
	
	public JdbcDAOFactory() {
    	try {
    		Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/selection_committee");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public UserDAO createUserDAO() {
		return new JdbcUserDAO();
	}
	
	@Override
	public FacultyDAO createFacultyDAO(){
		return new JdbcFacultyDAO();
	}
	
	@Override
	public ApplicationDAO createApplicationDAO(){
		return new JdbcApplicationDAO();
	}
	
	@Override
	public ResultDAO createResultDAO(){
		return new JdbcResultDAO();
	}
	

	@Override
	public SubjectDAO createSubjectDAO() {
		return new JdbcSubjectDAO();
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public static void closeConnection(Connection connection){
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	public static void closeStatement(Statement statement){
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	
}
