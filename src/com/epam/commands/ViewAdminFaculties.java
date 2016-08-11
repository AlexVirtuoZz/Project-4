package com.epam.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.constants.GlobalConstants;
import com.epam.model.FacultyService;

/**
 * A command to display all faculties
 * Can be used by user with admin rights
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return page with all faculties 
 * @author Alexander
 *
 */
public class ViewAdminFaculties implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FacultyService facultyService = FacultyService.getInstance();
		request.setAttribute(GlobalConstants.FACULTIES, facultyService.findAll());
		return Constants.ADMIN_FACULTIES_PAGE;
	}
	
}
