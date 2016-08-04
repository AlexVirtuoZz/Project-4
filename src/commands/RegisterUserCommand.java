package commands;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.GlobalConstants;
import constants.LoggerConstants;
import entities.User;
import model.UserService;

public class RegisterUserCommand implements Command{
	Logger logger = LogManager.getLogger(AcceptApplicationCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = UserService.getInstance();

		String login = (String) request.getParameter(GlobalConstants.LOGIN);
		String password = (String) request.getParameter(GlobalConstants.PASSWORD);
		
		if (login.equals(GlobalConstants.EMPTY) || password.equals(GlobalConstants.EMPTY)){
			request.setAttribute(Constants.LOG_PASS_ERROR, new Boolean(true));
			return Constants.REGISTRATION_PAGE;
		} else if (!userService.checkAvailableLogin(login)){
			request.setAttribute(Constants.LOGIN_TAKEN_ERROR, new Boolean(true));
			return Constants.REGISTRATION_PAGE;
		}
		
		String name = (String) request.getParameter(GlobalConstants.NAME);
		String secondName = (String) request.getParameter(GlobalConstants.SECOND_NAME);
		String thirdName = (String) request.getParameter(GlobalConstants.THIRD_NAME); 
		System.out.println(name);

		User user = new User(name, secondName, thirdName);
		user.setLogin(login);
		user.setPassword(DigestUtils.md5Hex(password));

		userService.create(user);
		logger.info(LoggerConstants.userRegistered+login);
		request.getSession().setAttribute(GlobalConstants.USER, user);
		return Constants.WELCOME_PAGE;
	}

}
