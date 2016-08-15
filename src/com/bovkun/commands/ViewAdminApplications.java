package com.bovkun.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bovkun.constants.GlobalConstants;
import com.bovkun.model.ApplicationService;
/**
 * A command to display all applications
 * Can be used by user with admin rights
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return page with all applications 
 * @author Alexander
 *
 */
public class ViewAdminApplications implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ApplicationService applicationService = ApplicationService.getInstance();
		request.setAttribute(GlobalConstants.APPLICATIONS, applicationService.findAllApplications());
		return Constants.ADMIN_APPLICATIONS_PAGE;
	}

}
