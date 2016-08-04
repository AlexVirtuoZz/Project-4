package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseLanguageCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String chosenLanguage = (String) request.getParameter(Constants.CHOSEN_LANGUAGE);
		
		switch (chosenLanguage) {
			case (Constants.ENG) : request.getSession().setAttribute(Constants.LANG, Constants.EN_US);
			break;
			case (Constants.URK) : request.getSession().setAttribute(Constants.LANG, Constants.UK_UA);
			break;
		}
		return Constants.WELCOME_PAGE;
	}

}
