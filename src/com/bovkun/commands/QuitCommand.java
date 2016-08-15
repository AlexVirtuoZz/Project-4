package com.bovkun.commands;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bovkun.constants.GlobalConstants;
import com.bovkun.constants.LoggerConstants;
import com.bovkun.entities.User;
/**
 * A command to quit user from system
 * Get all attribute names from session and remove attributes according to name
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return welcome page
 * @author Alexander
 *
 */
public class QuitCommand implements Command{
	private static final Logger logger = LogManager.getLogger(QuitCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> sessionAttNames = request.getSession().getAttributeNames();
		User user = (User) request.getSession().getAttribute(GlobalConstants.USER);
		
		if (user.isAdmin())
			logger.info(LoggerConstants.ADMIN_DISCONNECTED+user.getId());
		else 
			logger.info(LoggerConstants.USER_DISCONNECTED+user.getId());
		while(sessionAttNames.hasMoreElements()){
			request.getSession().removeAttribute(sessionAttNames.nextElement());
		}
		
		return Constants.WELCOME_PAGE;
	}

}
