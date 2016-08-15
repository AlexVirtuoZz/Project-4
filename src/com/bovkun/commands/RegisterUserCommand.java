package com.bovkun.commands;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bovkun.constants.GlobalConstants;
import com.bovkun.constants.LoggerConstants;
import com.bovkun.entities.User;
import com.bovkun.model.UserService;
/**
 * A command to register new user
 * Read all values from form
 * Encode password and create new user according to values from form and add it into database with user rights
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return error, if login or password are empty or login is already taken
 * @return welcome page
 * @author Alexander
 *
 */
public class RegisterUserCommand implements Command{
	private static final Logger logger = LogManager.getLogger(RegisterUserCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = UserService.getInstance();

		String login = (String) request.getParameter(GlobalConstants.LOGIN);
		String password = (String) request.getParameter(GlobalConstants.PASSWORD);
		String name = (String) request.getParameter(GlobalConstants.NAME);
		String secondName = (String) request.getParameter(GlobalConstants.SECOND_NAME);
		String thirdName = (String) request.getParameter(GlobalConstants.THIRD_NAME); 
		
		if (login.equals(GlobalConstants.EMPTY) || password.equals(GlobalConstants.EMPTY)
			|| name.equals(GlobalConstants.EMPTY) || secondName.equals(GlobalConstants.EMPTY)
			|| thirdName.equals(GlobalConstants.EMPTY)){
			request.setAttribute(Constants.LOG_PASS_ERROR, new Boolean(true));
			return Constants.REGISTRATION_PAGE;
		} else if (!userService.checkAvailableLogin(login)){
			request.setAttribute(Constants.LOGIN_TAKEN_ERROR, new Boolean(true));
			return Constants.REGISTRATION_PAGE;
		}

		User user = new User(name, secondName, thirdName);
		user.setLogin(login);
		user.setPassword(DigestUtils.md5Hex(password));

		userService.create(user);
		logger.info(LoggerConstants.USER_REGISTERED+login);
		return Constants.WELCOME_PAGE;
	}

}
