package dev.happinessfield.lifegame;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Lifegame test = new Lifegame(10, 10);

		int generations = 1;
		Gson gson = new Gson();
		FileWriter fw;
		for (int i = 0; i < generations; i++) {
			System.out.println("generation " + i + ": " + test.getLivingCells());
			try {
				fw = new FileWriter("gen" + i +".json");
				fw.write(gson.toJson(test));
				fw.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			test.step();
		}
	}
}