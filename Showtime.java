
public class Showtime {
	/*
	 * This class represents a showtime.
	 */
	Saloon saloon;
	String time;
	double price;
	Movie movie;
	int count;

	public Showtime(Saloon saloon, String time, double price, Movie m) {
		this.saloon = saloon;
		this.time = time;
		this.price = price;
		movie = m;
		count = 0;
	}

	public void addCountShowtime(int a) {
		// Add a viewer to showtime.
		count += a;
	}

	public boolean equals(Showtime s) {
		return s.saloon.equals(this.getSaloon()) && s.time.equals(this.getTime());
	}

	// GET AND SET METHODS
	public Saloon getSaloon() {
		return saloon;
	}

	public void setSaloon(Saloon saloon) {
		this.saloon = saloon;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
