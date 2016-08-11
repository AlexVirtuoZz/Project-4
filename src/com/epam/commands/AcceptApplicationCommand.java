package com.epam.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.GlobalConstants;
import com.epam.constants.LoggerConstants;
import com.epam.model.ApplicationService;
/**
 * A command to accept or cancel user application
 * Can be used by user with admin rights
 * If current application is not accepted - accept it. Otherwise - cancel it
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return current page 
 * @author Alexander
 */
public class AcceptApplicationCommand implements Command {
	private static final Logger logger = LogManager.getLogger(AcceptApplicationCommand.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Integer appId = Integer.valueOf(request.getParameter(GlobalConstants.APPLICATION));
		Boolean accept = Boolean.valueOf(request.getParameter(GlobalConstants.ACCEPT));
		ApplicationService applicationService = ApplicationService.getInstance();
		if (accept==true){
			logger.info(LoggerConstants.APPLICATION_ACCEPTED+appId);
			applicationService.acceptApplication(appId);
		}
		else {
			logger.info(LoggerConstants.APPLICATION_CANCELED+appId);
			applicationService.cancelApplication(appId);
		}
		return new ViewAdminApplications().execute(request, response);
	}

}
