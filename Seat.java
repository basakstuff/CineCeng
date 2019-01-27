
public class Seat {
	/*
	 * This class represents a Seat.
	 */
	char row, column;
	boolean isEmpty;

	public Seat(int i, int j) {
		this.row = (char) j;
		this.column = (char) i;
		isEmpty = true;
	}

	// GET AND SET METHODS
	public char getRow() {
		return row;
	}

	public void setRow(char row) {
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

}
