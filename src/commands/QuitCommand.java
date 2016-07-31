package commands;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> sessionAttNames = request.getSession().getAttributeNames();
		
		while(sessionAttNames.hasMoreElements()){
			request.getSession().removeAttribute(sessionAttNames.nextElement());
		}
		
		return Constants.WELCOME_PAGE;
	}

}
