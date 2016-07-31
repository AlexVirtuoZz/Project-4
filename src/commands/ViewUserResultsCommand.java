package commands;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ApplicationService;

public class ViewUserResultsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ApplicationService service = ApplicationService.getInstance();
		request.setAttribute(Constants.SUBJECTS, service.findAllSubjects());
		
		return Constants.USER_RESULTS;
	}

}
