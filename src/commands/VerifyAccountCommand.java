package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.User;
import model.ApplicationService;
import model.UserService;
import view.GlobalConstants;

public class VerifyAccountCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String login = (String) request.getParameter(GlobalConstants.LOGIN);
		String password = (String) request.getParameter(GlobalConstants.PASSWORD);
		UserService userService = UserService.getInstance();
		User user = userService.find(login);
		
		if (user == null || login.equals(GlobalConstants.EMPTY) || password.equals(GlobalConstants.EMPTY) 
			|| userService.checkAvailableLogin(login) || !password.equals(user.getPassword())){
			request.getSession().setAttribute(Constants.VERIFICATION_ERROR, new Boolean(true));
			return Constants.WELCOME_PAGE;
		} 
		if (user.isAdmin()){
			return Constants.ADMIN_PANEL_PAGE;
		}	
		ApplicationService applicationService = ApplicationService.getInstance();

		user.setResult(applicationService.readResultByUserId(user.getId()));
		request.getSession().setAttribute(GlobalConstants.USER, user);
		request.getSession().setAttribute(GlobalConstants.APPLICATIONS, applicationService.findAllByUserId(user.getId()));
		return Constants.USER_PANEL_PAGE;
	}

}
