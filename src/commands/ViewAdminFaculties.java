package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstants;
import model.FacultyService;


public class ViewAdminFaculties implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FacultyService facultyService = FacultyService.getInstance();
		request.setAttribute(GlobalConstants.FACULTIES, facultyService.findAll());
		return Constants.ADMIN_FACULTIES;
	}
	
}
