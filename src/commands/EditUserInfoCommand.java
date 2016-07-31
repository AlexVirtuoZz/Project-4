package commands;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import model.UserService;
import view.GlobalConstants;

public class EditUserInfoCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = request.getParameter(GlobalConstants.NAME);
		String secondName = request.getParameter(GlobalConstants.SECOND_NAME);
		String thirdName = request.getParameter(GlobalConstants.THIRD_NAME);
		String login = request.getParameter(GlobalConstants.LOGIN);
		String password = request.getParameter(GlobalConstants.PASSWORD);
		
		User tmp = (User) request.getSession().getAttribute(GlobalConstants.USER);
		tmp.setName(name);
		tmp.setSecondName(secondName);
		tmp.setThirdName(thirdName);
		tmp.setLogin(login);
		tmp.setPassword(password);
			
		UserService userService = UserService.getInstance();
		userService.update(tmp);
		request.getSession().setAttribute(GlobalConstants.USER, tmp);
		return Constants.USER_PANEL_PAGE;
	}

}
