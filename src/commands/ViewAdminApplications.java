package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstants;
import model.ApplicationService;

public class ViewAdminApplications implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ApplicationService applicationService = ApplicationService.getInstance();
		request.setAttribute(GlobalConstants.APPLICATIONS, applicationService.findAllApplications());
		return Constants.ADMIN_APPLICATIONS;
	}

}
