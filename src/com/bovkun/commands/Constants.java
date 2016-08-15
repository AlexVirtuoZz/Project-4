package com.bovkun.commands;

/**
 * All constants used only in 'com.bovkun.commands' package
 * Include pages, errors and utility constants
 * @author Alexander
 *
 */
interface Constants {
	// Pages
	String WELCOME_PAGE = "index.jsp";
	String REGISTRATION_PAGE = "registration.jsp"; 
	String FACULTIES_PAGE = "/WEB-INF/views/faculties.jsp";
	String USER_INFO_PAGE = "userInfo.jsp";
	String USER_PANEL_PAGE = "userPanel.jsp";
	String ADMIN_PANEL_PAGE = "adminPanel.jsp";
	String USER_RESULTS_PAGE = "/WEB-INF/views/userResults.jsp";
	String USER_APPLICATIONS_PAGE = "/WEB-INF/views/userApplications.jsp";
	String ADMIN_APPLICATIONS_PAGE = "/WEB-INF/views/adminApplications.jsp";
	String ADMIN_FACULTIES_PAGE = "/WEB-INF/views/adminFaculties.jsp";
	String ADMIN_APPLIED_STUDENTS_PAGE = "/WEB-INF/views/appliedStudents.jsp";
	String ADMIN_USERS_EDITOR_PAGE = "/WEB-INF/views/adminUsers.jsp";
	
	//Errors
	String LOGIN_TAKEN_ERROR = "loginTaken";
	String LOG_PASS_ERROR = "logPassError";
	String VERIFICATION_ERROR = "verificationError";
	String MARK_NULL_ERROR = "markNullError";
	String INCORRECT_MARK_ERROR = "incorrectMarkError";
	String PAS_MISMATCH_ERROR = "passMismatchError";
	String CERTIFICATE_MARK_ERROR = "certificateMarkError";
	
	//Utility
	String LANG = "lang";
	String ENG = "ENG";
	String URK = "UKR";
	String UK_UA = "uk_UA";
	String EN_US = "en_US";
	String CHOSEN_LANGUAGE = "chosenLanguage";
	String CERTIFICATE = "Certificate";
	String USERS = "users";
}
