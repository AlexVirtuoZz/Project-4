package com.epam.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * An interface to generalize commands
 * Got only 1 executing method {@link #execute(HttpServletRequest, HttpServletResponse)}
 * @return next page for user to go with processed information
 * @author Alexander
 *
 */
public interface Command {
	String execute (HttpServletRequest request, HttpServletResponse response);
}
