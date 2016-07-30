package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import model.UserService;

public class FindUserCommand implements Command {
	private UserService userService = UserService.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String name = (String) request.getAttribute("name");
		User
		users = userService.find(name);
		request.setAttribute("users", users);
		return /*page*/ null;
	}
}
