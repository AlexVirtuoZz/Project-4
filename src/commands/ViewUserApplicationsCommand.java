package commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstants;
import entities.Application;
import entities.Faculty;
import entities.User;
import model.ApplicationService;
import model.FacultyService;

public class ViewUserApplicationsCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute(GlobalConstants.USER);
		
		ApplicationService applicationService = ApplicationService.getInstance();
		List<Application> applications = applicationService.findAllByUserId(user.getId());
		FacultyService facultyService = FacultyService.getInstance();
		
		Map<String, Application> appMap = new HashMap<>();
		
		for (Application application : applications){
			Faculty faculty = facultyService.findById(application.getFacultyId());
			appMap.put(faculty.getName(), application);
		}
		
		request.setAttribute(GlobalConstants.APPLICATIONS, appMap);
		request.setAttribute(GlobalConstants.FACULTIES, facultyService.findAll());
		return Constants.USER_APPLICATIONS;
	}
	

}
