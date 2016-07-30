package commands;

public interface Constants {
	// Pages
	String WELCOME_PAGE = "index.jsp";
	String REGISTRATION_PAGE = "registration.jsp"; 
	String FACULTIES_PAGE = "/WEB-INF/views/faculties.jsp";
	String USER_EDITOR_PAGE = "/WEB-INF/views/userEditor.jsp";
	String USER_PANEL_PAGE = "pages/userPanel.jsp";
	String ADMIN_PANEL_PAGE = "/WEB-INF/views/adminPanel.jsp";

	
	//Errors
	String LOGIN_TAKEN = "loginTaken";
	String LOG_PASS_ERROR = "logPassError";
	String VERIFICATION_ERROR = "verificationError";
	
	//Utility
	String FACULTIES = "faculties";
	String CHOSEN_FACULTY = "chosenFaculty";
}
