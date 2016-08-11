package com.epam.commands;

/**
 * List of all available Commands
 * @see Command
 * @author Alexander
 *
 */
public enum CommandList {
	
	REGISTER_USER(new RegisterUserCommand()),
	CHOOSE_LANGUAGE(new ChooseLanguageCommand()),
	EDIT_USER_INFO(new EditUserInfoCommand()),
	EDIT_USER_RESULTS(new EditUserResultsCommand()),
	USER_APPLY( new EditUserApplicationsCommand()),
	VIEW_USER_RESULTS(new ViewUserResultsCommand()),
	VIEW_USER_APPLICATIONS(new ViewUserApplicationsCommand()),
	ADMIN_VIEW_APPLICATIONS(new ViewAdminApplications()),
	ADMIN_VIEW_FACULTIES(new ViewAdminFaculties()),
	ADMIN_VIEW_APPLIED_STUDENTS(new ViewAppliedStudentsCommand()),
	QUIT(new QuitCommand()),
	ACCEPT_APPLICATION(new AcceptApplicationCommand()),
	VERIFY_ACCOUNT(new VerifyAccountCommand());
	
	private Command command;
	
	CommandList(Command command){
		this.command = command;
	}
	
	public Command getCommand() {
		return command;
	}
}
