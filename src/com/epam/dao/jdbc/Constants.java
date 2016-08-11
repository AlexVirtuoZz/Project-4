package com.epam.dao.jdbc;
/**
 * All constans which are used in 'com.epam.dao.jdbc' package
 * @author Alexander
 *
 */
interface Constants {
	// Constants to work with database
	String DB_NAME = "name";
	String DB_SECOND_NAME = "second_name";
	String DB_THIRD_NAME = "third_name";
	String DB_ADMIN = "admin";
	String DB_CAPACITY = "capacity";
	String DB_SUBJECT_ONE = "subject_one";
	String DB_SUBJECT_TWO = "subject_two";
	String DB_SUBJECT_THREE = "subject_three";
	String DB_ID = "id";
	String DB_GRADE = "grade";
	String DB_USER_ID = "user_id";
	String DB_SUBJECT_ID = "subject_id";
	String DB_FACULTY_ID = "faculty_id";
	String DB_RESULT = "result";
	String DB_ACCEPTED = "accepted";
	
	// Utility constants
	String LOOKUP_SOURCE = "java:comp/env/jdbc/selection_committee";
}
