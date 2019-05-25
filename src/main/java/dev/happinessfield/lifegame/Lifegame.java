package dev.happinessfield.lifegame;

import dev.happinessfield.lifegame.Exceptions.OutOfFieldException;
import java.util.Random;

public class Lifegame {
	private Field field;

	public Lifegame(int x, int y) {
		field = new Field(x, y);
		Random rand = new Random();

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				Cell c = new Cell(rand.nextBoolean());
				field.setCell(c, i, j);
			}
		}
	}

	public void step() {
		Field beforeField = field.clone();

		for (int i = 0; i < beforeField.getY(); i++) {
			for (int j = 0; j < beforeField.getX(); j++) {
				int lives = 0;

				try {
					if (beforeField.getCell(j - 1, i - 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
						// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(j, i - 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(j + 1, i - 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(j - 1, i).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(j + 1, i).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(j - 1, i + 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(j, i + 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(j + 1, i + 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				// 生きているセルに対する判定
				if (beforeField.getCell(j, i).getLive()) {
					if (lives <= 1) {
						field.setCell(new Cell(false), j, i);
					}
					else if (lives == 2 || lives == 3) {
						field.setCell(new Cell(true), j, i);
					}
					else {
						field.setCell(new Cell(false), j, i);
					}
				}

				// 死んでいるセルに対する判定
				else {
					if (lives == 3) {
						field.setCell(new Cell(true), j, i);
					}
				}
			}
		}
	}

	public int getLivingCells() {
		int livingCells = 0;

		for (int i = 0; i < field.getX(); i++) {
			for (int j = 0; j < field.getY(); j++) {
				if (field.getCell(i, j).getLive()) {
					livingCells++;
				}
			}
		}

		return livingCells;
	}
}