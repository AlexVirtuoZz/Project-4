package commands;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.GlobalConstants;
import constants.LoggerConstants;
import entities.User;
import model.ApplicationService;
import model.UserService;

public class VerifyAccountCommand implements Command{
	Logger logger = LogManager.getLogger(VerifyAccountCommand.class);
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
			logger.info(LoggerConstants.adminConnected+user.getId());
			return Constants.ADMIN_PANEL_PAGE;
		}	
		
		ApplicationService applicationService = ApplicationService.getInstance();
		user.setResult(applicationService.readResultByUserId(user.getId()));
		request.getSession().setAttribute(GlobalConstants.APPLICATIONS, applicationService.findAllByUserId(user.getId()));
		logger.info(LoggerConstants.userConnected+user.getId());
		return Constants.USER_PANEL_PAGE;
	}

}
