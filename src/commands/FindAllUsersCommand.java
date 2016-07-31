package commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import model.UserService;

public class FindAllUsersCommand implements Command{
	private UserService userService = UserService.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<User> users = userService.findAll();
		request.setAttribute("users", users);
		return Constants.USER_EDITOR_PAGE;
	}

}
