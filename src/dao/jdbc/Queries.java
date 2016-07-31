package dao.jdbc;

interface Queries {
	// For faculties
	String FACULTIES_FIND_ALL = "SELECT * FROM faculties";
	String FACULTIES_FIND_ID_BY_NAME = "SELECT id FROM faculties WHERE name=?";
	String FACULTIES_FIND_BY_ID = "SELECT * FROM faculties WHERE id=?";

	
	// For users
	String USER_FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
	String USER_FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
	String USER_CREATE = "INSERT INTO users (name, second_name, third_name, login, password) VALUES (?,?,?,?,?)";
	String USER_FIND_ALL = "SELECT * FROM users";
	String USER_UPDATE = "UPDATE users SET name=?, second_name=?, third_name=?, login=?, password=? WHERE id=?";
	
	// For applications
	String APPLICATIONS_FIND_ALL = "SELECT * FROM applications";
	String APPLICATIONS_FIND_BY_ID = "SELECT * FROM applications WHERE id = ?";
	String APPLICATIONS_CREATE = "INSERT INTO applications (user_id, faculty_id, result) VALUES (?, ?, ?)";
	String APPLICATIONS_DELETE = "DELETE FROM applications WHERE id=?";
	String APPLICATIONS_FIND_ALL_BY_USER_ID = "SELECT * FROM applications WHERE user_id=?";
	String APPLICATIONS_UPSERT = "insert into applications (user_id, faculty_id, result) values (?, ?, ?) ON DUPLICATE KEY UPDATE result=values(result)";

	
	// For results
	String RESULT_FIND_BY_USER_ID = "SELECT grade, subjects.name FROM results RIGHT JOIN subjects ON subject_id = subjects.id WHERE user_id = ?";
	String RESULT_CREATE = "INSERT INTO results(user_id, subject_id, grade) VALUES (?, ?, ?)";
	String RESULT_UPSERT = "INSERT INTO results (subject_id, user_id, grade) VALUES ((SELECT id FROM subjects WHERE name=?), ?, ?) ON DUPLICATE KEY UPDATE grade = values(grade)";
	
	// For subjects
	String SUBJECT_FIND_ALL = "SELECT * FROM subjects";
	}
