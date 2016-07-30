package dao.jdbc;

interface Queries {
	// For faculties
	String FACULTIES_FIND_ALL = "SELECT * FROM faculties";
	
	// For users
	String USER_FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
	String USER_FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
	String USER_CREATE = "INSERT INTO users (name, second_name, third_name, login, password) VALUES (?,?,?,?,?)";
	String USER_FIND_ALL = "SELECT * FROM users";
	String USER_UPDATE = "UPDATE users SET name=?, second_name=?, third_name=?, login=?, password=? WHERE id=?";
}
