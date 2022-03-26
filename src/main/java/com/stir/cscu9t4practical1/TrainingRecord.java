// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
	private List<Entry> tr;

	/**
	 * Constructor for a training record. Initialises the ArrayList used to hold the
	 * entries.
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
		// Initialise a variable to store if a matching entry was found.
		boolean found = false;
		// Iterate over each entry in the training record.
		for (Entry x : tr) {
			// If an entry with the same date and name as the provided entry is detected,
			// mark that a matching entry was found and break the loop.
			if (x.getName().equalsIgnoreCase(e.getName()) && x.getDay() == e.getDay() && x.getMonth() == e.getMonth()
					&& x.getYear() == e.getYear()) {
				found = true;
				break;
			}
		}
		// If a matching entry was not found, add the provided entry to the training
		// record.
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
		// Initialise a new iterator for the training record list.
		ListIterator<Entry> iter = tr.listIterator();
		// Initialise the results string, with a default message if no matches are
		// found.
		String result = "No entries found";
		// Run the following code while the iterator has more entries to return.
		while (iter.hasNext()) {
			// Get the next entry from the iterator.
			Entry current = iter.next();
			// If the entry has the provided day, month, and year, store a string
			// representation of it in the results string.
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
				result = current.getEntry();
		}
		// Return the results string.
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
		// Initialise a variable to store if any matching entries was found.
		boolean found = false;
		// Initialise an empty results string.
		String result = "";
		// Iterate over each entry in the training record.
		for (Entry x : tr) {
			// If the entry has the provided day, month, and year, add the string
			// representation of it to the results string, and mark that an entry was found.
			if (x.getDay() == d && x.getMonth() == m && x.getYear() == y) {
				result = result + x.getEntry();
				found = true;
			}
		}
		// If at least one entry was found, return the results string, and return a
		// message if not.
		if (found) {
			return result;
		} else {
			return "Sorry, couldn't find anything for this date";
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
		// Initialise a variable to store if any matching entries was found.
		boolean found = false;
		// Initialise an empty results string.
		String result = "";
		// Iterate over each entry in the training record.
		for (Entry x : tr) {
			// If the entry has the provided name, add the string representation of it to
			// the results string, and mark that an entry was found.
			if (x.getName().toLowerCase().contains(n.toLowerCase())) {
				result = result + x.getEntry();
				found = true;
			}
		}
		// If at least one entry was found, return the results string, and return a
		// message if not.
		if (found) {
			return result;
		} else {
			return "Sorry, couldn't find anything for this name";
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
		// Initialise a variable to store if any matching entries was found.
		boolean found = false;
		// Iterate over each entry in the training record.
		for (Entry x : tr) {
			// If an entry with the same date and name as the provided entry is detected,
			// mark that a matching entry was found, delete it, and break the loop.
			if (x.getName().equalsIgnoreCase(n) && x.getDay() == d && x.getMonth() == m && x.getYear() == y) {
				found = true;
				tr.remove(x);
				break;
			}
		}
		// If the entry was found and deleted, return a message to that effect, and a
		// different method if no matching record was found.
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