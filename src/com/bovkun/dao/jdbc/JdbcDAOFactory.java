package com.bovkun.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bovkun.constants.LoggerConstants;
import com.bovkun.dao.ApplicationDAO;
import com.bovkun.dao.DAOFactory;
import com.bovkun.dao.FacultyDAO;
import com.bovkun.dao.ResultDAO;
import com.bovkun.dao.SubjectDAO;
import com.bovkun.dao.UserDAO;
/**
 * Class realization of DAOFactory
 * @see DAOFactory
 * Used to return dataSource to allow connection to database , close statements and connection 
 * and to create objects of required DAO class
 * @author Alexander
 *
 */
public class JdbcDAOFactory extends DAOFactory {
	private static DataSource dataSource;
	private static final Logger logger = LogManager.getLogger(JdbcDAOFactory.class);
	/**
	 * JdbcDAOFactory constructor
	 * initialize data source by context from specified source path
	 */
	public JdbcDAOFactory() {
    	try {
    		Context context = new InitialContext();
			dataSource = (DataSource) context.lookup(Constants.LOOKUP_SOURCE);
		} catch (NamingException e) {
			logger.log(Level.WARN, LoggerConstants.EXCEPTION_NAMING, e);
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
	/**
	 * A method to return connecting from data source
	 * @return Connection to the data source
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
}
