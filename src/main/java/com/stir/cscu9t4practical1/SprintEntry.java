package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {

	private int repetitions;
	private int recovery;

	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int re, int rec) {
		super(n, d, m, y, h, min, s, dist);
		this.repetitions = re;
		this.recovery = rec;
	}
	
	public int getRepetitions() {
		return this.repetitions;
	}
	
	public int getRecovery() {
		return this.recovery;
	}
	
	public String getEntry() {
		String result = getName() + " sprinted " + getRepetitions() + "x" +((int) getDistance()) + "m in " + getHour() + ":" + getMin() + ":" + getSec()
				+ " with " + getRecovery() + " minutes recovery on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
		return result;
	}
}
