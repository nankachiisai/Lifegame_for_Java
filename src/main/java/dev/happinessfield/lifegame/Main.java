package dev.happinessfield.lifegame;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Lifegame test = new Lifegame(50, 50);

		int generations = 50;
		Gson gson = new Gson();
		BufferedWriter bw = null;
		for (int i = 0; i < generations; i++) {
			System.out.println("generation " + i + ": " + test.getLivingCells());
			try {
				bw = new BufferedWriter(new FileWriter("gen" + i +".json"));
				bw.write(gson.toJson(test));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				if (bw != null) {
					try {
						bw.close();
					}
					catch (IOException e) {
					}
				}
			}
			test.step();
		}
	}
}