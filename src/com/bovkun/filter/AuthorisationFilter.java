package com.bovkun.filter;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bovkun.commands.QuitCommand;
import com.bovkun.constants.GlobalConstants;
import com.bovkun.entities.User;

@WebFilter("/AuthorisationFilter")
public class AuthorisationFilter implements Filter {
	Map<String, Boolean> adminCommands;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String commandName = req.getParameter(GlobalConstants.COMMAND);
		User user = (User) req.getSession().getAttribute(GlobalConstants.USER);
		
		if (commandName != null && user != null && !user.isAdmin()){
			if (adminCommands.get(commandName) != null)
			resp.sendRedirect(new QuitCommand().execute(req, resp));
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		adminCommands = new HashMap<>(); 
		
		adminCommands.put("ADMIN_VIEW_APPLICATIONS", true); 
		adminCommands.put("ADMIN_VIEW_USERS", true);
		adminCommands.put("ADMIN_VIEW_FACULTIES", true);
		adminCommands.put("ADMIN_SET_ADMIN", true);
		adminCommands.put("ADMIN_VIEW_APPLIED_STUDENTS", true);
		
	}

}
