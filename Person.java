
public class Person {
	/*
	 * This class represents a Person
	 */
	String name, birthDate, birthPlace;
	int id;
	static int currentId = 1; // Static field for auto increment id

	public Person(String name, String birthDate, String birthPlace) {
		// Constructor
		id = currentId++; // Auto increment id.
		this.name = name;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
	}

	// GET AND SET METHODS

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
