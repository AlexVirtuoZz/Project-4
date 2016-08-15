package com.bovkun.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bovkun.entities.User;
import com.bovkun.model.UserService;

public class AdminViewUsersCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = UserService.getInstance();
		List<User> users = userService.findAll();
		request.setAttribute(Constants.USERS, users);
		return Constants.ADMIN_USERS_EDITOR_PAGE;
	}
}
