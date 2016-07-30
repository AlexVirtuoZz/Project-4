package entities;


public abstract class User {
	
	private int id;
	private String name;
	private String secondName;
	private String thirdName;
	private int result;
	private String login;
	private String password;
	private boolean admin;
	
	public User( String name, String secondName, String thirdName) {
		this.name = name;
		this.secondName = secondName;
		this.thirdName = thirdName;
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}
	/**
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	/**
	 * @return the thirdName
	 */
	public String getThirdName() {
		return thirdName;
	}
	/**
	 * @param thirdName the thirdName to set
	 */
	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}
	
	
	
	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", secondName=" + secondName + ", thirdName=" + thirdName
				+ ", result=" + result + "]";
	}

	
	
	
	
}
