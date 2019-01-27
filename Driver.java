import java.io.*;
import enigma.core.Enigma;

public class Driver {
	/*
	 * This class includes Main method so that whole program executes.
	 */
	public static void main(String[] args) throws IOException {
		// Main method
		Cinema cineCeng = new Cinema(); // Create cinema

		enigma.console.Console cn = Enigma.getConsole("Cinema");

		// Needs for reading a txt file.
		File file = new File("input.txt");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String satir = reader.readLine();

		while (satir != null) { // Reading txt file loop, while it has nextLine.
			// Lines splited by ";"
			String[] satirArray = satir.split(";");

			// Below if statements calls necessary methods according to commands
			// in file.
			if (satirArray[0].equalsIgnoreCase("addStar")) {
				cineCeng.addStar(satirArray[1], satirArray[2], satirArray[3]);
			} else if (satirArray[0].equalsIgnoreCase("addMovie")) {
				Person dir = cineCeng.getDirector(Integer.parseInt(satirArray[4]));
				Person[] stars = new Person[satirArray.length - 5];
				int j = 0;
				for (int i = 5; i < satirArray.length; i++) {
					stars[j] = cineCeng.getStar(Integer.parseInt(satirArray[i]));
					j++;
				}

				cineCeng.addMovie(satirArray[1], satirArray[2], dir, Double.parseDouble(satirArray[3]), stars);
			} else if (satirArray[0].equalsIgnoreCase("addDirector")) {
				cineCeng.addDirector(satirArray[1], satirArray[2], satirArray[3]);
			} else if (satirArray[0].equalsIgnoreCase("updateSaloon")) {
				cineCeng.updateSaloon(satirArray[1], Integer.parseInt(satirArray[2]));
			} else if (satirArray[0].equalsIgnoreCase("updateShowtime")) {
				cineCeng.updateShowtime(satirArray[1], satirArray[2], Double.parseDouble(satirArray[3]));
			} else if (satirArray[0].equalsIgnoreCase("sellTicket")) {
				cineCeng.sellTicket(satirArray[1], satirArray[2], satirArray[3], satirArray[4]);
			} else if (satirArray[0].equalsIgnoreCase("cancelTicket")) {
				cineCeng.cancelTicket(satirArray[1], satirArray[2], satirArray[3]);
			} else if (satirArray[0].equalsIgnoreCase("displayActors")) {
				cineCeng.displayActors();
			} else if (satirArray[0].equalsIgnoreCase("displayDirectors")) {
				cineCeng.displayDirectors();
			} else if (satirArray[0].equalsIgnoreCase("displayMovies")) {
				cineCeng.displayMovies();
			} else if (satirArray[0].equalsIgnoreCase("endTheDay")) {
				break;
			} else {
				System.err.println("Something s wrong");
				break;
			}

			satir = reader.readLine();
		}

		reader.close();

		// End day info.
		System.out.println("The most-watched movie : " + cineCeng.mostWatchedMovie());
		System.out.println("Total revenue of CineCeng: " + cineCeng.totalRevenue + " (Student: " + cineCeng.studentRen
				+ ", Regular: " + cineCeng.regularRen + ")");
		System.out.println("The most-filled showtime : " + cineCeng.mostWatchedShowtime());
		System.out.println("The highest-income movie : " + cineCeng.mostIncomeMovie());
		System.out.println();
		System.out.println("   s1  \t\t    s2\t    \ts3");

		cineCeng.printSeats();
	}

}
