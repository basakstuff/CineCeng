
public class Saloon {

	/*
	 * This class represents a single Saloon
	 */
	Seat[][] morningSeats;
	Seat[][] noonSeats;
	Seat[][] eveningSeats;
	String saloonName, presentationTech;
	Movie movie;
	Showtime morning, noon, evening;
	int totalViewer;

	public Saloon(String saloonName, String presentationTech) {
		morningSeats = new Seat[5][5];
		noonSeats = new Seat[5][5];
		eveningSeats = new Seat[5][5];
		initializeSeats(morningSeats);
		initializeSeats(eveningSeats);
		initializeSeats(noonSeats);
		movie = null;
		totalViewer = 0;
		this.saloonName = saloonName;
		this.presentationTech = presentationTech;
	}

	public void setShowTime(Showtime showtime) {
		// Sets a showtime to time that argument represents.
		if (showtime.getTime().equals("morning")) {
			morning = showtime;
		}
		if (showtime.getTime().equals("evening")) {
			evening = showtime;
		}
		if (showtime.getTime().equals("noon")) {
			noon = showtime;
		}

	}

	public Showtime getShowtime(String id) {
		// Returns a showtime according to time that argument represents.
		if (id.equals("morning")) {
			return morning;
		}
		if (id.equals("evening")) {
			return evening;
		}
		if (id.equals("noon")) {
			return noon;
		}
		return null;
	}

	public void initializeSeats(Seat[][] seats) {
		// Inýtialize seats rows and columns.
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j] = new Seat(i + 49, j + 65);
			}
		}
	}

	public void printSeats(Seat[][] seats) {
		// Print seats of a showtime.
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].isEmpty) {
					System.out.print("O ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}

	public static void printSeats(Seat[][] seats1, Seat[][] seats2, Seat[][] seats3) {
		// Print seats of 3 showtimes.
		for (int i = 0; i < seats1.length; i++) {
			for (int j = 0; j < seats1[i].length; j++) {
				if (seats1[i][j].isEmpty) {
					System.out.print("O ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.print("\t");
			for (int j = 0; j < seats2[i].length; j++) {
				if (seats2[i][j].isEmpty) {
					System.out.print("O ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.print("\t");
			for (int j = 0; j < seats3[i].length; j++) {
				if (seats3[i][j].isEmpty) {
					System.out.print("O ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}

	// GET AND SET METHODS
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getSaloonName() {
		return saloonName;
	}

	public void setSaloonName(String saloonName) {
		this.saloonName = saloonName;
	}

	public String getPresentationTech() {
		return presentationTech;
	}

	public void setPresentationTech(String presentationTech) {
		this.presentationTech = presentationTech;
	}

	public void setSeat(String showTime, String seat, boolean isEmpty) {
		// Set a seat whether empty or not empty
		if (showTime.equals("morning")) {
			getSeat(seat, morningSeats).setEmpty(isEmpty);
		}
		if (showTime.equals("evening")) {
			getSeat(seat, eveningSeats).setEmpty(isEmpty);
		}
		if (showTime.equals("noon")) {
			getSeat(seat, noonSeats).setEmpty(isEmpty);
		}
		if (isEmpty) {
			totalViewer--;
		} else {
			totalViewer++;
		}

	}

	public int getTotalViewer() {
		return totalViewer;
	}

	public Seat getSeat(String seat, Seat[][] seats) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].column == seat.charAt(1) && seats[i][j].row == seat.charAt(0)) {
					return seats[i][j];
				}
			}
		}
		return null;
	}

}
