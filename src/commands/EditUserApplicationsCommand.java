package commands;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.GlobalConstants;
import constants.LoggerConstants;
import entities.Application;
import entities.Faculty;
import entities.User;
import model.ApplicationService;
import model.FacultyService;

public class EditUserApplicationsCommand implements Command{
	Logger logger = LogManager.getLogger(EditUserApplicationsCommand.class);

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
			return Constants.USER_APPLICATIONS;
		}
		
		Application application = new Application();
		application.setFacultyId(faculty.getId());
		application.setUserId(user.getId());
		application.setResult(mark1+mark2+mark3);
		applicationService.createApplication(application);
		
		logger.trace(LoggerConstants.studentApplied+LoggerConstants.studentId+user.getId()+LoggerConstants.facultyId+faculty.getId());
		return new ViewUserApplicationsCommand().execute(request, response);
	}

}
