package commands;

public interface Constants {
	// Pages
	String WELCOME_PAGE = "index.jsp";
	String REGISTRATION_PAGE = "registration.jsp"; 
	String FACULTIES_PAGE = "/WEB-INF/views/faculties.jsp";
	String USER_EDITOR_PAGE = "/WEB-INF/views/userEditor.jsp";
	String USER_PANEL_PAGE = "userPanel.jsp";
	String ADMIN_PANEL_PAGE = "adminPanel.jsp";
	String USER_RESULTS = "/WEB-INF/views/userResults.jsp";
	String USER_APPLICATIONS = "/WEB-INF/views/userApplications.jsp";
	String ADMIN_APPLICATIONS = "/WEB-INF/views/adminApplications.jsp";
	String ADMIN_FACULTIES = "/WEB-INF/views/adminFaculties.jsp";
	String ADMIN_APPLIED_STUDENTS = "/WEB-INF/views/appliedStudents.jsp";

	
	//Errors
	String LOGIN_TAKEN_ERROR = "loginTaken";
	String LOG_PASS_ERROR = "logPassError";
	String VERIFICATION_ERROR = "verificationError";
	String MARK_NULL_ERROR = "markNullError";
	String INCORRECT_MARK_ERROR = "incorrectMarkError";

	
	//Utility
	String LANG = "lang";
	String ENG = "ENG";
	String URK = "UKR";
	String UK_UA = "uk_UA";
	String EN_US = "en_US";
	String CHOSEN_LANGUAGE = "chosenLanguage";
}
