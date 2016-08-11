package com.epam.commands;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.GlobalConstants;
import com.epam.constants.LoggerConstants;
import com.epam.entities.Application;
import com.epam.entities.Faculty;
import com.epam.entities.User;
import com.epam.model.ApplicationService;
import com.epam.model.FacultyService;
/**
 * A command to edit user's application
 * Allow user to apply onto chosen faculty, if marks match
 * if marks don't match - return error
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return current page
 * @author Alexander
 *
 */
public class EditUserApplicationsCommand implements Command{
	private static final Logger logger = LogManager.getLogger(EditUserApplicationsCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute(GlobalConstants.USER); 
		String chosenFaculty = (String) request.getParameter(GlobalConstants.FACULTY);
		
		ApplicationService applicationService = ApplicationService.getInstance();
		FacultyService facultyService = FacultyService.getInstance();
		
		Faculty faculty = facultyService.findByName(chosenFaculty);
		Map<String, Integer> grades = (Map<String, Integer>) applicationService.readResultByUserId(user.getId());
		
		Integer mark1 = grades.get(faculty.getSubjectOne());
		Integer mark2 = grades.get(faculty.getSubjectTwo());
		Integer mark3 = grades.get(faculty.getSubjectThree());
		
		request.setAttribute(GlobalConstants.FACULTIES, facultyService.findAll());
		
		if (mark1 == null || mark2 == null || mark3 == null){
			request.setAttribute(Constants.MARK_NULL_ERROR, new Boolean(true));
			return Constants.USER_APPLICATIONS_PAGE;
		}
		
		Application application = new Application();
		application.setFacultyId(faculty.getId());
		application.setUserId(user.getId());
		application.setResult(mark1+mark2+mark3);
		applicationService.createApplication(application);
		
		logger.trace(LoggerConstants.STUDENT_APPLIED+LoggerConstants.STUDENT_ID+user.getId()+LoggerConstants.FACULTY_ID+faculty.getId());
		return new ViewUserApplicationsCommand().execute(request, response);
	}

}
