
public class Movie {
	/*
	 * This class stands for a Movie
	 */
	static int currentMaxId = 1, currentIndex = 0;// For auto incremented id and
													// index
	int id;
	String title, genre;
	double duration;
	Person[] stars;

	Person director;
	int income;

	public Movie(String title, String genre, Person director, double duration) {
		// Constructor with no array argument
		this.id = currentMaxId++;
		this.duration = duration;
		this.title = title;
		this.genre = genre;
		this.stars = new Person[1];
		this.director = director;
		income = 0;
	}

	public Movie(String title, String genre, Person director, double duration, Person[] stars) {
		// Constructor with array argument
		this.id = currentMaxId++;
		this.duration = duration;
		this.title = title;
		this.genre = genre;
		this.stars = stars;
		this.director = director;
		income = 0;
	}

	public void addStar(Person star) {
		// Add new actor to a movie
		stars = Cinema.addElement(stars, star);
	}

	public boolean validateMovie() {
		// Validate if Movie has <=2 Actors and a Director.
		return stars.length >= 2 && director != null;
	}

	// GET AND SET METHODS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Person[] getStars() {
		return stars;
	}

	public void setStars(Person[] stars) {
		this.stars = stars;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public Person getDirector() {
		return director;
	}

	public void setDirector(Person director) {
		this.director = director;
	}

}
