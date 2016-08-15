package com.bovkun.commands;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bovkun.constants.GlobalConstants;
import com.bovkun.model.ApplicationService;
/**
 * A command to display user's results
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return page with all user's results according to subjects
 * @author Alexander
 *
 */
public class ViewUserResultsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ApplicationService service = ApplicationService.getInstance();
		request.setAttribute(GlobalConstants.SUBJECTS, service.findAllSubjects());
		
		return Constants.USER_RESULTS_PAGE;
	}

}
