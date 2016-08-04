package commands;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.GlobalConstants;
import constants.LoggerConstants;
import entities.User;
import model.UserService;

public class EditUserInfoCommand implements Command{
	Logger logger = LogManager.getLogger(EditUserInfoCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		String name = request.getParameter(GlobalConstants.NAME);
		String secondName = request.getParameter(GlobalConstants.SECOND_NAME);
		String thirdName = request.getParameter(GlobalConstants.THIRD_NAME);
		String login = request.getParameter(GlobalConstants.LOGIN);
		String password = request.getParameter(GlobalConstants.PASSWORD);
		User user = (User) request.getSession().getAttribute(GlobalConstants.USER);
		user.setName(name);
		user.setSecondName(secondName);
		user.setThirdName(thirdName);
		user.setLogin(login);
		user.setPassword(DigestUtils.md5Hex(password));
			
		UserService userService = UserService.getInstance();
		userService.update(user);
		request.getSession().setAttribute(GlobalConstants.USER, user);
		logger.info(LoggerConstants.infoChanged+user.getId());
		return Constants.USER_PANEL_PAGE;
	}

}
