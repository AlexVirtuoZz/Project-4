package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


import commands.Command;
import commands.CommandList;
import entities.faculty.Subject;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Command command = CommandList.valueOf((String)req.getParameter("command")).getCommand();
		String nextPage = command.execute(req, resp);
		req.getRequestDispatcher(nextPage).forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute("subjects", Subject.values());
		super.init();
	}
}
