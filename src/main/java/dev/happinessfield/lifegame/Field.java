package dev.happinessfield.lifegame;

import java.util.ArrayList;
import dev.happinessfield.lifegame.Exceptions.OutOfFieldException;

public class Field implements Cloneable {
	private int x;
	private int y;
	private ArrayList<Cell> field;

	public Field(int sizex, int sizey) {
		this.x = sizex;
		this.y = sizey;

		field = new ArrayList<Cell>();
		for (int i = 0; i < this.x * this.y; i++) {
			field.add(new Cell());
		}
	}

	public Cell getCell(int x, int y) throws OutOfFieldException {
		if (x < 0 || x >= this.x) {
			throw new OutOfFieldException();
		}
		if (y < 0 || y >= this.y) {
			throw new OutOfFieldException();
		}

		// System.out.println(x + " " + y);
		return field.get(this.x * y + x);
	}

	public void setCell(Cell c, int x, int y) throws OutOfFieldException {
		if (x < 0 || x > this.x) {
			throw new OutOfFieldException();
		}
		if (y < 0 || y > this.y) {
			throw new OutOfFieldException();
		}

		field.set(this.x * y + x, c);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public Field clone() {
		Field copy = new Field(this.x, this.y);

		int i = 0;
		for (Cell c : this.field) {
			copy.field.set(i, c);
			i++;
		}

		return copy;
	}
}