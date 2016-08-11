package com.epam.commands;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.constants.GlobalConstants;
import com.epam.constants.LoggerConstants;
import com.epam.entities.User;
import com.epam.model.ApplicationService;

/**
 * A command to edit user's results
 * Read all values from form
 * Get all subject names 
 * For each subject :
 * 		Get parameter value according to subject name
 * 		Check if it's not empty and matches mark pattern (-1 < mark < 201)
 * 		@return error if mark doesn't match pattern
 * 		set new mark value
 * @see Command#execute(HttpServletRequest, HttpServletResponse)
 * @return user control panel page
 * @author Alexander
 *
 */
public class EditUserResultsCommand implements Command {
	private static final Logger logger = LogManager.getLogger(EditUserResultsCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ApplicationService applicationService = ApplicationService.getInstance();
		User user = (User) request.getSession().getAttribute(GlobalConstants.USER);
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
		
		user.setResult(tmp);
		applicationService.updateResult(tmp, user.getId());
		logger.info(LoggerConstants.USER_CHANGED_MARKS+user.getId());
		return Constants.USER_PANEL_PAGE;
		}
	}

