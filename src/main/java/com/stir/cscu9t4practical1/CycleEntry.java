package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class CycleEntry extends Entry {

	private String terrain;
	private String tempo;

	/**
	 * Constructor for a swim entry. Uses the Entry constructor, then stores the
	 * location variable itself separately.
	 * 
	 * @param n       the name to be stored
	 * @param d       the day to be stored
	 * @param m       the month to be stored
	 * @param y       the year to be stored
	 * @param h       the hour to be stored
	 * @param min     the minute to be stored
	 * @param s       the second to be stored
	 * @param dist    the distance to be stored
	 * @param ter     the cycling terrain to be stored
	 * @param terrain the cycling tempo to be stored
	 */
	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String tem) {
		super(n, d, m, y, h, min, s, dist);
		this.terrain = ter;
		this.tempo = tem;
	}

	/**
	 * Get the value of the terrain variable.
	 * 
	 * @return the value of the terrain variable
	 */
	public String getTerrain() {
		return this.terrain;
	} // getTerrain

	/**
	 * Get the value of the tempo variable.
	 * 
	 * @return the value of the tempo variable
	 */
	public String getTempo() {
		return this.tempo;
	} // getTempo

	/**
	 * Get a string representation of the entry.
	 * 
	 * @return the representation
	 */
	public String getEntry() {
		String result = getName() + " cycled " + getDistance() + " km in " + getHour() + ":" + getMin() + ":" + getSec()
				+ " on " + getDay() + "/" + getMonth() + "/" + getYear() + " on " + getTerrain() + " at " + getTempo()
				+ " tempo\n";
		return result;
	} // getEntry

}
