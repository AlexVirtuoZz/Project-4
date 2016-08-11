package com.epam.entities;
/**
 * Class allows to manage applications, which students apply on faculties
 * Contains user id, faculty id and user result on specified faculty
 * Has own id and flag if it is accepted by admin
 * @author Alexander
 *
 */
public class Application {
	
	private int id;
	private int userId;
	private int facultyId;
	private int result;
	private boolean accepted;
	
	/**
	 * @return the accepted
	 */
	public boolean isAccepted() {
		return accepted;
	}

	/**
	 * @param accepted the accepted to set
	 */
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the facultyId
	 */
	public int getFacultyId() {
		return facultyId;
	}
	/**
	 * @param facultyId the facultyId to set
	 */
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
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
	
	
}
