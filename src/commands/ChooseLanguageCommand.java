package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseLanguageCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String chosenLanguage = (String) request.getParameter("chosenLanguage");
		
		switch (chosenLanguage) {
			case ("ENG") : request.getSession().setAttribute("lang", "en_US");
			break;
			case ("UKR") : request.getSession().setAttribute("lang", "uk_UA");
			break;
		}
		return "index.jsp";
	}

}
