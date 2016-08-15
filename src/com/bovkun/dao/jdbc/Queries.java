package com.bovkun.dao.jdbc;
/**
 * Constants of SQL queries used in 'com.bovkun.dao.jdbc' package
 * @author Alexander
 *
 */
interface Queries {
	// For faculties
	String FACULTIES_FIND_ALL = "SELECT * FROM faculties";
	String FACULTIES_FIND_ID_BY_NAME = "SELECT id FROM faculties WHERE name=?";
	String FACULTIES_FIND_BY_ID = "SELECT * FROM faculties WHERE id=?";
	String FACULTIES_FIND_BY_NAME = "SELECT * FROM faculties WHERE name=?";
	
	// For users
	String USER_FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
	String USER_FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
	String USER_CREATE = "INSERT INTO users (name, second_name, third_name, login, password) VALUES (?,?,?,?,?)";
	String USER_FIND_ALL = "SELECT * FROM users";
	String USER_UPDATE = "UPDATE users SET name=?, second_name=?, third_name=?, login=?, password=? WHERE id=?";
	String USER_SET_ADMIN = "UPDATE users SET admin=1 WHERE id=?";
	String USER_REMOVE_ADMIN = "UPDATE users SET admin=0 WHERE id=?";
	
	// For applications
	String APPLICATIONS_FIND_ALL = "SELECT * FROM applications";
	String APPLICATIONS_FIND_BY_ID = "SELECT * FROM applications WHERE id = ?";
	String APPLICATIONS_CREATE = "INSERT INTO applications (user_id, faculty_id, result) VALUES (?, ?, ?)";
	String APPLICATIONS_DELETE = "DELETE FROM applications WHERE id=?";
	String APPLICATIONS_ACCEPT = "UPDATE applications SET accepted=1 WHERE id=?";
	String APPLICATIONS_DECLINE = "UPDATE applications SET accepted=0 WHERE id=?";
	String APPLICATIONS_FIND_ALL_BY_USER_ID = "SELECT * FROM applications WHERE user_id=?";
	String APPLICATIONS_UPSERT = "insert into applications (user_id, faculty_id, result) values (?, ?, ?) ON DUPLICATE KEY UPDATE result=values(result)";
	String APPLICATIONS_FIND_APPLIED_STUDENTS = "SELECT users.name, users.second_name, users.third_name, result FROM applications FULL JOIN users ON users.id = user_id WHERE faculty_id=? AND accepted=1 ORDER BY result DESC";
	
	// For results
	String RESULT_FIND_BY_USER_ID = "SELECT grade, subjects.name FROM results RIGHT JOIN subjects ON subject_id = subjects.id WHERE user_id = ?";
	String RESULT_CREATE = "INSERT INTO results(user_id, subject_id, grade) VALUES (?, ?, ?)";
	String RESULT_UPSERT = "INSERT INTO results (subject_id, user_id, grade) VALUES ((SELECT id FROM subjects WHERE name=?), ?, ?) ON DUPLICATE KEY UPDATE grade = values(grade)";
	
	// For subjects
	String SUBJECT_FIND_ALL = "SELECT * FROM subjects";
	}
