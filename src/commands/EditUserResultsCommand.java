package commands;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import model.ApplicationService;
import view.GlobalConstants;


public class EditUserResultsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> subjects = request.getParameterNames();
		ApplicationService resultService = ApplicationService.getInstance();
		User user = (User) request.getSession().getAttribute(GlobalConstants.USER);
		Map<String, Integer> grades = user.getResult();
		Map<String, Integer> tmp = new HashMap<String, Integer>();

		while(subjects.hasMoreElements()){
			String subjectName = subjects.nextElement();
			try{
			Integer mark = new Integer(request.getParameter(subjectName));
			if (mark < 0 || mark > 200){
				request.setAttribute(Constants.INCORRECT_MARK_ERROR, new Boolean(true));
				return new ViewUserResultsCommand().execute(request, response);
			}
			
			if (grades.get(subjectName) != mark)
				tmp.put(subjectName, mark);
			
			} catch (NumberFormatException e){
				continue;
			}
		}
		resultService.updateResult(tmp, user.getId());
		return Constants.USER_PANEL_PAGE;
	}

}
