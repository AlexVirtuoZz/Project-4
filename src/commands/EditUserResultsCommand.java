package commands;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.faculty.Subject;

public class EditUserResultsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> subjects = request.getParameterNames();
		while(subjects.hasMoreElements()){
			String subjectName = subjects.nextElement();
			System.out.println(subjectName);
			try{
			Integer mark = new Integer(request.getParameter(subjectName));
			System.out.println(mark);
			} catch (NumberFormatException e){
				System.out.println("fail");
				continue;
			}
		}
		
		return null;
	}

}
