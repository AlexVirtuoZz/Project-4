package com.epam.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.GlobalConstants;
import com.epam.constants.LoggerConstants;
import com.epam.entities.User;
import com.epam.model.UserService;

/**
 * A command to edit user's information
 * Read all values from form, set them into current user and update current user info
 * If trying to set new password - check if current password and password from form match
 * If passwords match - encode new password and set user's new password
 * @return error if passwords don't match
 * @return user control panel page
 * @author Alexander
 *
 */
public class EditUserInfoCommand implements Command{
	private static final Logger logger = LogManager.getLogger(EditUserInfoCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		String name = request.getParameter(GlobalConstants.NAME);
		String secondName = request.getParameter(GlobalConstants.SECOND_NAME);
		String thirdName = request.getParameter(GlobalConstants.THIRD_NAME);
		String login = request.getParameter(GlobalConstants.LOGIN);
		String password = request.getParameter(GlobalConstants.PASSWORD);
		String newPassword = request.getParameter(GlobalConstants.NEW_PASSWORD);
		User user = (User) request.getSession().getAttribute(GlobalConstants.USER);
		
		if (!newPassword.equals(GlobalConstants.EMPTY)){
			if (user.getPassword().equals(DigestUtils.md5Hex(password))){
				user.setPassword(DigestUtils.md5Hex(newPassword));
			} else {
				request.setAttribute(Constants.PAS_MISMATCH_ERROR, new Boolean(true));
				return Constants.USER_INFO_PAGE;
			}
		}
		user.setName(name);
		user.setSecondName(secondName);
		user.setThirdName(thirdName);
		user.setLogin(login);	
			
		UserService userService = UserService.getInstance();
		userService.update(user);
		request.getSession().setAttribute(GlobalConstants.USER, user);
		logger.trace(LoggerConstants.INFO_CHANGED+user.getId());
		return Constants.USER_PANEL_PAGE;
	}

}
