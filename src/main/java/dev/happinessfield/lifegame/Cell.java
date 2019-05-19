package dev.happinessfield.lifegame;

public class Cell {
	private boolean live;

	public Cell() {
		live = false;
	}

	public Cell(boolean live) {
		this.live = live;
	}

	public boolean getLive() {
		return this.live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	@Override
	public String toString() {
		return Boolean.toString(live);
	}
}

