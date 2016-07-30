package commands;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.faculty.Faculty;
import model.FacultyService;
import view.GlobalConstants;

public class ChooseFacultyCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String faculty = (String) request.getParameter(Constants.CHOSEN_FACULTY);
		FacultyService service = FacultyService.getInstance();
		List<Faculty> faculties = service.findAll();
		request.setAttribute(Constants.FACULTIES, faculties);
		request.setAttribute(GlobalConstants.FACULTY, service.findByName(faculty));
		return Constants.FACULTIES_PAGE;
	}

}
