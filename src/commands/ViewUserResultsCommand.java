package commands;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstants;
import model.ApplicationService;

public class ViewUserResultsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ApplicationService service = ApplicationService.getInstance();
		request.setAttribute(GlobalConstants.SUBJECTS, service.findAllSubjects());
		
		return Constants.USER_RESULTS;
	}

}
