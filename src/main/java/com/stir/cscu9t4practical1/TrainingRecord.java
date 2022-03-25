// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
	private List<Entry> tr;

	/**
	 * Constructor for a training record. Initialises the ArrayList used to hold the entries.
	 */
	public TrainingRecord() {
		tr = new ArrayList<Entry>();
	} // constructor

	/**
	 * Adds a entry to the training record.
	 *
	 * @param e the entry to be added to the training record
	 */
	public void addEntry(Entry e) {
		boolean found = false;
		for (Entry x : tr) {
			if (x.getName().equalsIgnoreCase(e.getName()) && x.getDay() == e.getDay() && x.getMonth() == e.getMonth()
					&& x.getYear() == e.getYear()) {
				found = true;
			}
		}
		if (!found)
			tr.add(e);
	} // addClass

	/**
	 * Finds the first entry from the provided day, month, and year.
	 *
	 * @param d the day to be searched
	 * @param m the month to be searched
	 * @param y the year to be searched
	 * @return the string representation of the first entry found, or a default
	 *         string if none were found
	 */
	public String lookupEntry(int d, int m, int y) {
		ListIterator<Entry> iter = tr.listIterator();
		String result = "No entries found";
		while (iter.hasNext()) {
			Entry current = iter.next();
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
				result = current.getEntry();
		}
		return result;
	} // lookupEntry

	/**
	 * Finds all entries from the provided day, month, and year.
	 *
	 * @param d the day to be searched
	 * @param m the month to be searched
	 * @param y the year to be searched
	 * @return the string representation of all entries found, or a default string
	 *         if none were found
	 */
	// look up all entries of a given day and month
	public String lookupEntries(int d, int m, int y) {
		boolean found = false;
		String result = "";
		for (Entry x : tr) {
			if (x.getDay() == d && x.getMonth() == m && x.getYear() == y) {
				result = result + x.getEntry();
				found = true;
			}
		}
		if (found) {
			return result;
		} else {
			return "Sorry couldn't find anything for this date";
		}
	} // lookupEntries

	/**
	 * Finds all entries given the provided name. Partial matching is ued to handle
	 * edge cases - different formatting of names, last names being
	 * included/excluded, etc.
	 *
	 * @param n the name to be searched
	 * @return the string representation of all entries found, or a default string
	 *         if none were found
	 */
	public String lookupEntriesByName(String n) {
		boolean found = false;
		String result = "";
		for (Entry x : tr) {
			if (x.getName().toLowerCase().contains(n.toLowerCase())) {
				result = result + x.getEntry();
				found = true;
			}
		}
		if (found) {
			return result;
		} else {
			return "Sorry couldn't find anything for this name";
		}
	} // lookupEntriesByName

	/**
	 * Finds the entry (if it exists) of a given name from a given day, month, and
	 * year, and removes it from the training record
	 * 
	 * @param d the day to be searched
	 * @param m the month to be searched
	 * @param y the year to be searched
	 * @param n the name to be searched
	 * @return a string describing if the removal was successful or not.
	 */
	public String removeEntry(int d, int m, int y, String n) {
		boolean found = false;
		for (Entry x : tr) {
			if (x.getName().equalsIgnoreCase(n) && x.getDay() == d && x.getMonth() == m && x.getYear() == y) {
				found = true;
				tr.remove(x);
			}
		}
		if (found) {
			return "Removed successfully";
		} else {
			return "No matching records present";
		}
	} // lookupEntriesByName

	/**
	 * Finds the number of entries present within the training record.
	 * 
	 * @return the number of entries
	 */
	public int getNumberOfEntries() {
		return tr.size();
	}

	/**
	 * Deletes all entries within the training record.
	 */
	public void clearAllEntries() {
		tr.clear();
	}

} // TrainingRecord