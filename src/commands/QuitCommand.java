package commands;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.GlobalConstants;
import constants.LoggerConstants;
import entities.User;

public class QuitCommand implements Command{
	Logger logger = LogManager.getLogger(AcceptApplicationCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> sessionAttNames = request.getSession().getAttributeNames();
		
		User user = (User) request.getSession().getAttribute(GlobalConstants.USER);
		if (user.isAdmin())
			logger.info(LoggerConstants.adminDisconnected+user.getId());
		else 
			logger.info(LoggerConstants.userDisconnected+user.getId());
		while(sessionAttNames.hasMoreElements()){
			request.getSession().removeAttribute(sessionAttNames.nextElement());
		}
		
		return Constants.WELCOME_PAGE;
	}

}
