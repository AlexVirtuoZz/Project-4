package entities.faculty;

public class Faculty {
	private int id;
	private String name;
	private Subject subjectOne;
	private Subject subjectTwo;
	private Subject subjectThree;
	private int capacity;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public Faculty setName(String name) {
		this.name = name;
		return this;
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
	public Faculty setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public Faculty setCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	/**
	 * @return the subjectOne
	 */
	public Subject getSubjectOne() {
		return subjectOne;
	}

	/**
	 * @param subjectOne the subjectOne to set
	 */
	public Faculty setSubjectOne(Subject subjectOne) {
		this.subjectOne = subjectOne;
		return this;
	}

	/**
	 * @return the subjectTwo
	 */
	public Subject getSubjectTwo() {
		return subjectTwo;
	}

	/**
	 * @param subjectTwo the subjectTwo to set
	 */
	public Faculty setSubjectTwo(Subject subjectTwo) {
		this.subjectTwo = subjectTwo;
		return this;
	}

	/**
	 * @return the subjectThree
	 */
	public Subject getSubjectThree() {
		return subjectThree;
	}

	/**
	 * @param subjectThree the subjectThree to set
	 */
	public Faculty setSubjectThree(Subject subjectThree) {
		this.subjectThree = subjectThree;
		return this;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Faculty [name = ").append(name).append(",subjectOne=");
		builder.append(subjectOne);
		builder.append(", subjectTwo=");
		builder.append(subjectTwo);
		builder.append(", subjectThree=");
		builder.append(subjectThree);
		builder.append(", capacity=");
		builder.append(capacity);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
