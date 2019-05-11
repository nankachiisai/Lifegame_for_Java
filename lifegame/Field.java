package lifegame;

import java.util.ArrayList;

public class Field {
	private int x;
	private int y;
	private ArrayList<Cell> field;

	public Field(int sizex, int sizey) {
		this.x = sizex;
		this.y = sizey;

		field = new ArrayList<Cell>(this.x * this.y);
	}

	public Cell getCell(int x, int y) throws IllegalArgumentException {
		if (x > this.x || y > this.y) {
			throw new IllegalArgumentException();
		}

		return field.get(this.x * y + x);
	}

	public void setCell(Cell c, int x, int y) throws IllegalArgumentException {
		if (x > this.x || y > this.y) {
			throw new IllegalArgumentException();
		}

		field.set(this.x * y + x, c);
	}
}