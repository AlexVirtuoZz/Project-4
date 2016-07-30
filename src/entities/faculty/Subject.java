package entities.faculty;

public enum Subject {
	MATH(Constants.MATH),
	PHYSICS(Constants.PHYSICS),
	BIOLOGY(Constants.BIOLOGY),
	GEOGRAPHY(Constants.GEOGRAPHY),
	UKRAINIAN(Constants.UKRAINIAN),
	HISTORY(Constants.HISTORY),
	CHEMISTRY(Constants.CHEMISTRY),
	ENGLISH(Constants.ENGLISH);
	
	private String name;
	
	Subject (String s){
		name = s;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
