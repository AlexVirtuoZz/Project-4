package com.bovkun.commands;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bovkun.constants.GlobalConstants;
import com.bovkun.constants.LoggerConstants;
import com.bovkun.model.UserService;

public class AdminSetAdminCommand implements Command{
	private static final Logger logger = LogManager.getLogger(AdminSetAdminCommand.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Boolean accept = Boolean.valueOf(request.getParameter(GlobalConstants.ACCEPT));
		Integer id = Integer.valueOf(request.getParameter(GlobalConstants.ID));
		UserService userService = UserService.getInstance();
		if (accept == false){
			logger.info(LoggerConstants.ADMIN_REMOVED + id);
			userService.removeAdmin(id);
		} else {
			logger.info(LoggerConstants.ADMIN_ADDED + id);
			userService.setAdmin(id);
		}
		return new AdminViewUsersCommand().execute(request, response);
	}

}
