// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class Entry {
	private String name;
	private Calendar dateAndTime;
	private float distance;

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
	 */
	public Entry(String n, int d, int m, int y, int h, int min, int s, float dist) {
		name = n;
		Calendar inst = Calendar.getInstance();
		inst.set(y, m - 1, d, h, min, s);
		dateAndTime = inst;
		distance = dist;
	} // constructor

	/**
	 * Get the value of the day variable.
	 * 
	 * @return the value of the day variable
	 */
	public String getName() {
		return name;
	} // getName

	/**
	 * Get the value of the day variable.
	 * 
	 * @return the value of the day variable
	 */
	public int getDay() {
		return dateAndTime.get(Calendar.DATE);
	} // getDay

	/**
	 * Get the value of the month variable.
	 * 
	 * @return the value of the month variable
	 */
	public int getMonth() {
		int month = dateAndTime.get(Calendar.MONTH) + 1;
		return month;
	} // getMonth

	/**
	 * Get the value of the year variable.
	 * 
	 * @return the value of the year variable
	 */
	public int getYear() {
		return dateAndTime.get(Calendar.YEAR);
	} // getYear

	/**
	 * Get the value of the hour variable.
	 * 
	 * @return the value of the hour variable
	 */
	public int getHour() {
		return dateAndTime.get(Calendar.HOUR);
	} // getHour

	/**
	 * Get the value of the minute variable.
	 * 
	 * @return the value of the minute variable
	 */
	public int getMin() {
		return dateAndTime.get(Calendar.MINUTE);
	} // getMin

	/**
	 * Get the value of the second variable.
	 * 
	 * @return the value of the second variable
	 */
	public int getSec() {
		return dateAndTime.get(Calendar.SECOND);
	} // getSec

	/**
	 * Get the value of the distance variable.
	 * 
	 * @return the value of the distance variable
	 */
	public float getDistance() {
		return distance;
	} // getDistance

	/**
	 * Get a string representation of the entry.
	 * 
	 * @return the representation
	 */
	public String getEntry() {
		String result = getName() + " ran " + getDistance() + " km in " + getHour() + ":" + getMin() + ":" + getSec()
				+ " on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
		return result;
	} // getEntry

} // Entry