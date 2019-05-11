package lifegame;

import java.util.Random;

public class Lifegame {
	private Field field;

	public Lifegame(int x, int y) {
		field = new Field(x, y);

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				Random rand = new Random();
				Cell c = new Cell(rand.nextBoolean());
				field.setCell(c, i, j);
			}
		}
	}

	public void step() {
		
	}
}