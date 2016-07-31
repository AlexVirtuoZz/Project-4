package commands;

public interface Constants {
	// Pages
	String WELCOME_PAGE = "index.jsp";
	String REGISTRATION_PAGE = "registration.jsp"; 
	String FACULTIES_PAGE = "/WEB-INF/views/faculties.jsp";
	String USER_EDITOR_PAGE = "/WEB-INF/views/userEditor.jsp";
	String USER_PANEL_PAGE = "userPanel.jsp";
	String ADMIN_PANEL_PAGE = "/WEB-INF/views/adminPanel.jsp";
	String USER_RESULTS = "/WEB-INF/views/userResults.jsp";
	String USER_APPLICATIONS = "/WEB-INF/views/userApplications.jsp";
	
	//Errors
	String LOGIN_TAKEN_ERROR = "loginTaken";
	String LOG_PASS_ERROR = "logPassError";
	String VERIFICATION_ERROR = "verificationError";
	String MARK_NULL_ERROR = "markNullError";
	String INCORRECT_MARK_ERROR = "incorrectMarkError";

	
	//Utility
	String FACULTIES = "faculties";
	String CHOSEN_FACULTY = "chosenFaculty";
	String SUBJECTS = "subjects";
}
