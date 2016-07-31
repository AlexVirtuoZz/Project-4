package commands;


public enum CommandList {
	FIND_ALL_USERS(new FindAllUsersCommand()),
	FIND_USER(new FindUserCommand()),
	CHOOSE_FACULTY(new ChooseFacultyCommand()),
	REGISTER_USER(new RegisterUserCommand()),
	CHOOSE_LANGUAGE(new ChooseLanguageCommand()),
	EDIT_USER_INFO(new EditUserInfoCommand()),
	EDIT_USER_RESULTS(new EditUserResultsCommand()),
	USER_APPLY( new EditUserApplicationsCommand()),
	VIEW_USER_RESULTS(new ViewUserResultsCommand()),
	VIEW_USER_APPLICATIONS(new ViewUserApplicationsCommand()),
	QUIT(new QuitCommand()),
	VERIFY_ACCOUNT(new VerifyAccountCommand());
	
	private Command command;
	
	CommandList(Command command){
		this.command = command;
	}
	
	public Command getCommand() {
		return command;
	}
}
