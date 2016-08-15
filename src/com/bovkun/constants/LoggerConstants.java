package com.bovkun.constants;


/**
 * List of constants which are used to log events
 * @author Alexander
 *
 */
public interface LoggerConstants {
	String USER_CONNECTED = "User connected. id: ";
	String ADMIN_CONNECTED = "Admin connected. id: ";
	String USER_REGISTERED = "User created. login: ";
	String USER_DISCONNECTED = "User disconnected. id: ";
	String ADMIN_DISCONNECTED = "Admin disconnected. id: ";
	String APPLICATION_ACCEPTED = "Application has been accepted. id: ";
	String APPLICATION_CANCELED = "Application has been canceled. id: ";
	String ADMIN_ADDED = "Admin rights were given to user. id: ";
	String ADMIN_REMOVED = "Admin rights were removed from user. id: ";
	String STUDENT_APPLIED = "Student's applied for faculty. ";
	String STUDENT_ID = " Student id: ";
	String FACULTY_ID = " Faculty id: ";
	String INFO_CHANGED = "User information's changed. id: ";
	String USER_CHANGED_MARKS = "User's changed marks. id: ";
	String METHOD_CREATE_NOT_IMPL = "Error occur while calling unimplemented method create";
	String METHOD_UPDATE_NOT_IMPL = "Error occur while calling unimplemented method update";
	String METHOD_DELETE_NOT_IMPL = "Error occur while calling unimplemented method delete";		
	String METHOD_READ_NOT_IMPL = "Error occur while calling unimplemented method read";
	String METHOD_FINDALL_NOT_IMPL = "Error occur while calling unimplemented method findAll";
	String EXCEPTION_SQL = "SQL exception: ";
	String EXCEPTION_NAMING = "Naming exception: ";
	String EXCEPTION_CLASS_NOT_FOUND = "Class not found exception: ";
	String EXCEPTION_ILLEGAL_ACCESS = "Illegal access exception: ";
	String EXCEPTION_INSTANTIATION = "Instantiation exception: ";
	
}
