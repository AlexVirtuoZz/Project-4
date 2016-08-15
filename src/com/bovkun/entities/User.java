package com.bovkun.entities;


import java.util.Map;

/**
 * A class to manage users
 * Contains of id, full name, login, password, result (result for exams) and flag if user is admin
 * @author Alexander
 *
 */
public class User {
	
	private int id;
	private String name;
	private String secondName;
	private String thirdName;
	private Map<String, Integer> result;
	private String login;
	private String password;
	private boolean admin;
	
	public User( String name, String secondName, String thirdName) {
		this.name = name;
		this.secondName = secondName;
		this.thirdName = thirdName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	public Map<String, Integer> getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Map<String, Integer> result) {
		this.result = result;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
