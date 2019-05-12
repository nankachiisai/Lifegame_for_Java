import lifegame.Lifegame;

public class Main {
	public static void main(String[] args) {
		Lifegame test = new Lifegame(100, 100);

		int generations = 200;
		for (int i = 0; i < generations; i++) {
			System.out.println("generation " + i + ": " + test.getLivingCells());
			test.step();
		}
	}
}