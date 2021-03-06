package com.bovkun.commands;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bovkun.constants.GlobalConstants;
import com.bovkun.entities.Faculty;
import com.bovkun.entities.User;
import com.bovkun.model.ApplicationService;
import com.bovkun.model.FacultyService;
/**
 * A command to display students who applied
 * Can be used by user with admin rights
 * According to chosen faculty, display all accepted (!) applications for this faculty
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return page with students, who applied for chosen faculty
 * @author Alexander
 *
 */
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
		return Constants.ADMIN_APPLIED_STUDENTS_PAGE;
	}

}
