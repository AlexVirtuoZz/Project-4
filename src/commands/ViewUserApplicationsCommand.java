package commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.Application;
import entities.User;
import entities.faculty.Faculty;
import model.ApplicationService;
import model.FacultyService;
import view.GlobalConstants;

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
		request.setAttribute(Constants.FACULTIES, facultyService.findAll());
		return Constants.USER_APPLICATIONS;
	}
	

}
