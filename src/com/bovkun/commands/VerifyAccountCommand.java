package com.bovkun.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bovkun.constants.GlobalConstants;
import com.bovkun.constants.LoggerConstants;
import com.bovkun.entities.User;
import com.bovkun.model.ApplicationService;
import com.bovkun.model.UserService;
/**
 * A command to verify user's data
 * Read values from form (login and password)
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return error if field are empty or if password doesn't match login
 * @return admin control panel page if current user's got admin rights
 * @return user control panel page if current user's got non-admin rights
 * @author Alexander
 *
 */
public class VerifyAccountCommand implements Command{
	private static final Logger logger = LogManager.getLogger(VerifyAccountCommand.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String login = (String) request.getParameter(GlobalConstants.LOGIN);
		String password = (String) request.getParameter(GlobalConstants.PASSWORD);

		UserService userService = UserService.getInstance();
		User user = userService.find(login);

		if (user == null || login.equals(GlobalConstants.EMPTY) || password.equals(GlobalConstants.EMPTY) 
			|| userService.checkAvailableLogin(login) ||
			!DigestUtils.md5Hex(password).equals(user.getPassword())){
			request.getSession().setAttribute(Constants.VERIFICATION_ERROR, new Boolean(true));
			return Constants.WELCOME_PAGE;
		} 

		request.getSession().setAttribute(GlobalConstants.USER, user);
		
		if (user.isAdmin()){
			logger.info(LoggerConstants.ADMIN_CONNECTED+user.getId());
			return Constants.ADMIN_PANEL_PAGE;
		}	
		
		ApplicationService applicationService = ApplicationService.getInstance();
		user.setResult(applicationService.readResultByUserId(user.getId()));
		
		request.getSession().setAttribute(GlobalConstants.APPLICATIONS, applicationService.findAllByUserId(user.getId()));
		logger.info(LoggerConstants.USER_CONNECTED+user.getId());
		return Constants.USER_PANEL_PAGE;
	}

}
