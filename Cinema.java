
public class Cinema {
	/*
	 * This class represents whole Cinema System.
	 */
	Saloon saloons[];
	Person[] Directors;
	Person[] Stars;
	Movie[] Movies;
	double totalRevenue, studentRen, regularRen;

	public Cinema() {
		// Constructor for Cinema
		saloons = new Saloon[3];
		saloons[0] = new Saloon("s1", "2D");
		saloons[1] = new Saloon("s2", "3D");
		saloons[2] = new Saloon("s3", "Imax");
		Directors = new Person[0];
		Stars = new Person[0];
		Movies = new Movie[0];
		totalRevenue = 0;
		studentRen = 0;
		regularRen = 0;

	}

	public void addDirector(String name, String birthDate, String birthPlace) {
		// Creating a director and adding it to cinema system.
		Person d = new Person(name, birthDate, birthPlace);
		Directors = addElement(Directors, d);

	}

	public void addStar(String name, String birthDate, String birthPlace) {
		// Creating a Actor and adding it to cinema system.
		Person s = new Person(name, birthDate, birthPlace);
		Stars = addElement(Stars, s);
	}

	public void addMovie(String title, String genre, Person director, double duration, Person[] stars) {
		// Creating a Movie and adding it to cinema system.
		Movie m = new Movie(title, genre, director, duration, stars);
		Movies = addElement(Movies, m);
	}

	public void updateSaloon(String sId, int mId) {
		// Add a movie to a specific saloon
		int i = getSaloonIndex(sId);
		if (i == -1) {// Check saloon index
			System.err.println("Saloon not found");
			return;
		}

		Movie m = getMovie(mId);
		if (m == null) {// Check movie exists
			System.err.println("Movie cannot be found");
			return;
		}
		saloons[i].setMovie(m);

	}

	public void updateShowtime(String sId, String showTime, double price) {
		// Add showtime details.

		int i = getSaloonIndex(sId);
		if (i == -1) {// Check saloon index
			System.err.println("Saloon not found");
			return;
		}
		if (saloons[i].getMovie() == null) {// Check movie exists
			System.err.println("Movie cannot be found");
			return;
		}
		Showtime sTime = new Showtime(saloons[i], showTime, price, saloons[i].getMovie());// Create
																							// and
																							// add
																							// showtime
																							// object
		saloons[i].setShowTime(sTime);

	}

	public void sellTicket(String saloonId, String showTime, String seat, String type) {
		// Sell a ticket
		int i = getSaloonIndex(saloonId);
		if (i == -1) {
			System.err.println("Saloon not found");
			return;
		}
		// Find showtime, set seat as not empty, add viewer numbers, revenue and
		// income.
		Showtime st = saloons[i].getShowtime(showTime);
		saloons[i].setSeat(showTime, seat, false);
		saloons[i].getShowtime(showTime).addCountShowtime(1);
		totalRevenue += st.getPrice();
		if (type.equalsIgnoreCase("student")) {
			studentRen += st.getPrice();
		}
		if (type.equalsIgnoreCase("regular")) {
			regularRen += st.getPrice();
		}
		getMovie(st.movie.id).income += st.price;

	}

	public void cancelTicket(String saloonId, String showTime, String seat) {
		// Cancel a ticket
		int i = getSaloonIndex(saloonId);
		if (i == -1) {
			System.err.println("Bir hata oluþtu");
			return;
		}
		// Find showtime, set seat as empty, extract viewer numbers, revenue and
		// income.
		Showtime st = saloons[i].getShowtime(showTime);
		saloons[i].setSeat(showTime, seat, true);
		saloons[i].getShowtime(showTime).addCountShowtime(-1);
		totalRevenue -= st.getPrice();
		getMovie(st.movie.id).income -= st.price;

	}

	public String mostWatchedMovie() {
		// Find most watched movie, return it as a String.
		int max = 0;
		Saloon maxSal = saloons[0];
		for (int i = 0; i < saloons.length; i++) {
			if (saloons[i].totalViewer > max) {
				maxSal = saloons[i];
				max = saloons[i].getTotalViewer();
			}
		}
		return "\"" + maxSal.movie.title + "\"";
	}

	public String mostWatchedShowtime() {
		// Find most watched showtime, return it as a String.
		int max = 0;
		Showtime maxShow = saloons[0].morning;
		for (int i = 0; i < saloons.length; i++) {
			if (saloons[i].morning != null && saloons[i].morning.count > max) {
				maxShow = saloons[i].morning;
				max = saloons[i].morning.count;
			}
			if (saloons[i].evening != null && saloons[i].evening.count > max) {
				maxShow = saloons[i].evening;
				max = saloons[i].evening.count;
			}
			if (saloons[i].noon != null && saloons[i].noon.count > max) {
				maxShow = saloons[i].noon;
				max = saloons[i].noon.count;
			}
		}
		return maxShow.saloon.saloonName + "-" + maxShow.time;
	}

	public String mostIncomeMovie() {
		// Find the movie bringing most income, return it as a String.
		int maxIncome = 0;
		Movie maxMov = Movies[0];
		for (Movie m : Movies) {
			if (m.income >= maxIncome) {
				maxIncome = m.income;
				maxMov = m;
			}
		}
		return "\"" + maxMov.title + "\" - " + maxIncome;
	}

	private Movie getMovie(int mId) {
		// Get a movie via its id
		for (Movie m : Movies) {
			if (m.getId() == mId) {
				return m;
			}
		}
		return null;
	}

	public Person getStar(int sId) {
		// Get a Actor via its id
		for (Person s : Stars) {
			if (s.getId() == sId) {
				return s;
			}
		}
		return null;
	}

	public Person getDirector(int dId) {
		// Get a director via its id
		for (Person d : Directors) {
			if (d.getId() == dId) {
				return d;
			}
		}
		return null;
	}

	private int getSaloonIndex(String id) {
		// Get a saloon's index in saloons[] array via its id
		for (int i = 0; i < saloons.length; i++) {
			if (id.equalsIgnoreCase(saloons[i].saloonName)) {
				return i;
			}
		}
		return -1;
	}

	public void displayActors() {
		for (Person person : Stars) {
			System.out.println(person.id + " " + person.name);
		}
	}

	public void displayDirectors() {
		for (Person person : Directors) {
			System.out.println(person.id + " " + person.name);
		}
	}

	public void displayMovies() {
		for (Movie m : Movies) {
			System.out.println(m.id + " " + m.title);
		}
	}

	public void printSeats() {
		System.out.println("Morning: ");
		Saloon.printSeats(saloons[0].morningSeats, saloons[1].morningSeats, saloons[2].morningSeats);
		System.out.println("Noon: ");
		Saloon.printSeats(saloons[0].noonSeats, saloons[1].noonSeats, saloons[2].noonSeats);
		System.out.println("Evening: ");
		Saloon.printSeats(saloons[0].eveningSeats, saloons[1].eveningSeats, saloons[2].eveningSeats);
	}

	public static Person[] addElement(Person[] arr, Person p) {
		// Add element to a Person array
		Person[] temp = new Person[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		temp[arr.length] = p;
		return temp;
	}

	public static Movie[] addElement(Movie[] arr, Movie m) {
		// Add element to a Movie array
		Movie[] temp = new Movie[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		temp[arr.length] = m;
		return temp;
	}

}
