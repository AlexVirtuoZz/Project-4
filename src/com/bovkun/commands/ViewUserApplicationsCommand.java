package com.bovkun.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bovkun.constants.GlobalConstants;
import com.bovkun.entities.Application;
import com.bovkun.entities.Faculty;
import com.bovkun.entities.User;
import com.bovkun.model.ApplicationService;
import com.bovkun.model.FacultyService;
/**
 * A command to display all user's applications
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return page with all user's applications
 * @author Alexander
 *
 */
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
		return Constants.USER_APPLICATIONS_PAGE;
	}
	

}
