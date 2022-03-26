package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {

	private int repetitions;
	private int recovery;

	/**
	 * Constructor for a swim entry. Uses the Entry constructor, then stores the
	 * repetition and recovery variables themselves separately.
	 * 
	 * @param n    the name to be stored
	 * @param d    the day to be stored
	 * @param m    the month to be stored
	 * @param y    the year to be stored
	 * @param h    the hour to be stored
	 * @param min  the minute to be stored
	 * @param s    the second to be stored
	 * @param dist the distance to be stored
	 * @param re   the number of repetitions to be stored
	 * @param rec  the length of recovery time between repetitions (in minutes) to be stored
	 */
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int re, int rec) {
		super(n, d, m, y, h, min, s, dist);
		this.repetitions = re;
		this.recovery = rec;
	}

	/**
	 * Get the value of the repetitions variable.
	 * 
	 * @return the value of the repetitions variable
	 */
	public int getRepetitions() {
		return this.repetitions;
	}

	/**
	 * Get the value of the recovery variable.
	 * 
	 * @return the value of the recovery variable
	 */
	public int getRecovery() {
		return this.recovery;
	}

	/**
	 * Get a string representation of the entry.
	 * 
	 * @return the representation
	 */
	public String getEntry() {
		String result = getName() + " sprinted " + getRepetitions() + "x" + ((int) getDistance()) + "m in " + getHour()
				+ ":" + getMin() + ":" + getSec() + " with " + getRecovery() + " minutes recovery on " + getDay() + "/"
				+ getMonth() + "/" + getYear() + "\n";
		return result;
	}
}
