package lifegame;

import lifegame.Exceptions.OutOfFieldException;
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

		for (int i = 0; i < field.getX(); i++) {
			for (int j = 0; j < field.getY(); j++) {
				int lives = 0;

				try {
					if (beforeField.getCell(i - 1, j - 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
						// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(i, j - 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(i + 1, j - 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(i - 1, j).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(i - 1, j).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(i - 1, j + 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				try {
					if (beforeField.getCell(i + 1, j + 1).getLive()) {
						lives++;
					}
				}
				catch (OutOfFieldException e) {
					// 範囲外に関しては死んだセルとみなす
				}

				// 生きているセルに対する判定
				if (field.getCell(i, j).getLive()) {
					if (lives <= 1) {
						field.setCell(new Cell(false), i, j);
					}
					else if (lives == 2 || lives == 3) {
						field.setCell(new Cell(true), i, j);
					}
					else if (lives >= 4) {
						field.setCell(new Cell(false), i, j);
					}
				}

				// 死んでいるセルに対する判定
				else {
					if (lives == 3) {
						field.setCell(new Cell(true), i, j);
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