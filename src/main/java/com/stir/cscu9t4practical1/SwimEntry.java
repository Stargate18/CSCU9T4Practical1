package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

	private String where;

	/**
	 * Constructor for a swim entry. Uses the Entry constructor, then stores the
	 * location variable itself separately.
	 * 
	 * @param n    the name to be stored
	 * @param d    the day to be stored
	 * @param m    the month to be stored
	 * @param y    the year to be stored
	 * @param h    the hour to be stored
	 * @param min  the minute to be stored
	 * @param s    the second to be stored
	 * @param dist the distance to be stored
	 * @param w    the location to be stored
	 */
	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String w) {
		super(n, d, m, y, h, min, s, dist);
		this.where = w;
	}

	/**
	 * Get the value of the location variable, altered for better formatting if the
	 * location is a pool.
	 * 
	 * @return the value of the location variable
	 */
	public String getWhere() {
		if (this.where.contains("pool")) {
			return "in a pool";
		}
		return this.where;
	}

	/**
	 * Get a string representation of the entry.
	 * 
	 * @return the representation
	 */
	public String getEntry() {
		String result = getName() + " swam " + getDistance() + " km " + getWhere() + " in " + getHour() + ":" + getMin()
				+ ":" + getSec() + " on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
		return result;
	}

}
