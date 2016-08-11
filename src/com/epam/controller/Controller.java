package com.epam.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.epam.commands.Command;
import com.epam.commands.CommandList;
import com.epam.constants.GlobalConstants;
/**
 * A main servlet to process events
 * Entire work is based on command pattern with {@link #doGet(HttpServletRequest, HttpServletResponse)} method
 * Each command returns specified web page path
 * All available command can be found on 
 * @see com.epam.commands.CommandList
 * @author Alexander
 *
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Main method to process all users' requests and go to the according web page
	 * @param req user's request
	 * @param resp user's response 
	 * @throws ServletException if error's occur while executing
	 * @throws IOException if error's occur with connection
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Command command = CommandList.valueOf((String)req.getParameter(GlobalConstants.COMMAND)).getCommand();
		String nextPage = command.execute(req, resp);
		req.getRequestDispatcher(nextPage).forward(req, resp);	
	}
	/**
	 * A method to hide url and delegate executing to {@link #doGet(HttpServletRequest, HttpServletResponse)} method
	 * @param req user's request
	 * @param resp user's response 
	 * @throws ServletException if error's occur while executing
	 * @throws IOException if error's occur with connection
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
