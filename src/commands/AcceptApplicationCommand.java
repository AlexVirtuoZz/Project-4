package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.GlobalConstants;
import model.ApplicationService;

public class AcceptApplicationCommand implements Command {
	Logger logger = LogManager.getLogger(AcceptApplicationCommand.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Integer appId = Integer.valueOf(request.getParameter(GlobalConstants.APPLICATION));
		Boolean accept = Boolean.valueOf(request.getParameter(GlobalConstants.ACCEPT));
		ApplicationService applicationService = ApplicationService.getInstance();
		if (accept==true){
			logger.info(appId+" application accepted");
			applicationService.acceptApplication(appId);
		}
		else {
			logger.info(appId+" application declined");
			applicationService.declineApplication(appId);
		}
		return new ViewAdminApplications().execute(request, response);
	}

}
