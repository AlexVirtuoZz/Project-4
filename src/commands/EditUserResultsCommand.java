package commands;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.GlobalConstants;
import entities.User;
import model.ApplicationService;


public class EditUserResultsCommand implements Command {
	Logger logger = LogManager.getLogger(EditUserResultsCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ApplicationService applicationService = ApplicationService.getInstance();
		User user = (User) request.getSession().getAttribute(GlobalConstants.USER);
		Map<String, Integer> grades = user.getResult();
		Map<String, Integer> tmp = new HashMap<String, Integer>();
		List<String> subjects = applicationService.findAllSubjects();
		
		for (String subject : subjects){
			String markString = request.getParameter(subject);
			Integer mark = null;
			if (!markString.equals(GlobalConstants.EMPTY)){
				mark = Integer.valueOf(markString);	
				if (mark < 0 || mark > 200){
					request.setAttribute(Constants.INCORRECT_MARK_ERROR, new Boolean(true));
					return new ViewUserResultsCommand().execute(request, response);
				}
				tmp.put(subject, mark);
			}
		}
		
		/*while(paramNames.hasMoreElements()){
			String subjectName = paramNames.nextElement();
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
		}*/
		user.setResult(tmp);
		applicationService.updateResult(tmp, user.getId());
		logger.info(user.getLogin()+" user's changed marks");
		return Constants.USER_PANEL_PAGE;
		}
	}

