package commands;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstants;
import entities.Faculty;
import entities.User;
import model.ApplicationService;
import model.FacultyService;

public class ViewAppliedStudentsCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Integer facultyId = Integer.valueOf(request.getParameter(GlobalConstants.FACULTY));
		FacultyService facultyService = FacultyService.getInstance();
		ApplicationService applicationService = ApplicationService.getInstance();
		Faculty faculty = facultyService.findById(facultyId);
		Map<User, Integer> students = applicationService.findAppliedStudent(facultyId);
		
		request.setAttribute(GlobalConstants.FACULTY, faculty);
		request.setAttribute(GlobalConstants.APPLIED_STUDENTS, students);
		return Constants.ADMIN_APPLIED_STUDENTS;
	}

}
