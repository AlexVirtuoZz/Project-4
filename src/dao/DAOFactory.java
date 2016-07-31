package dao;

public abstract class DAOFactory {
	
	public abstract UserDAO createUserDAO();
	public abstract FacultyDAO createFacultyDAO();
	public abstract ApplicationDAO createApplicationDAO();
	public abstract ResultDAO createResultDAO();
	public abstract SubjectDAO createSubjectDAO();
	
	public static DAOFactory getFactory(){
		
			try {
				return (DAOFactory) Class.forName("dao.jdbc.JdbcDAOFactory").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
}
