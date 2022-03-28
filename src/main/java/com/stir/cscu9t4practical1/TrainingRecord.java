// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.time.Duration;
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
	public String addEntry(Entry e) {
		// Initialise a variable to store if a matching entry was found.
		boolean found = false;
		// Iterate over each entry in the training record.
		for (Entry x : tr) {
			// If an entry with the same date and name as the provided entry is detected,
			// mark that a matching entry was found and break the loop.
			if (x.getName().toLowerCase().contains(e.getName().toLowerCase()) && x.getDay() == e.getDay()
					&& x.getMonth() == e.getMonth() && x.getYear() == e.getYear()) {
				found = true;
				break;
			}
		}
		// If a matching entry was not found, add the provided entry to the training
		// record and return the success message. If not, return the failure message.
		if (!found) {
			tr.add(e);
			return "Record added";
		} else {
			return "Sorry, a similar record already existed";
		}
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
			if (x.getName().toLowerCase().contains(n.toLowerCase()) && x.getDay() == d && x.getMonth() == m
					&& x.getYear() == y) {
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
	} // removeEntry

	public String weeklyDistance() {
		// Initialise a variable to store if any matching entries was found.
		boolean found = false;
		// Initialise a new calendar which, by default, has the current date/time.
		Calendar inst = Calendar.getInstance();
		// Initialise another calendar, to compare the current date/time with.
		Calendar compare = Calendar.getInstance();
		// INitialize variables to hold the difference between two dates, as well as the
		// totals for each type of entry.
		int diff = 0;
		double runtotal = 0.0;
		double cycletotal = 0.0;
		double swimtotal = 0.0;
		// Initialise an empty results string.
		String result = "";
		// Iterate over each entry in the training record.
		for (Entry x : tr) {
			// Set the comparison calendar to the provided date, and get the difference
			// between the two.
			compare.set((x.getYear()), (x.getMonth()) - 1, (x.getDay()));
			diff = (int) Duration.between(inst.toInstant(), compare.toInstant()).toDays();
			// If the difference is within the limits, run the contained code.
			if (diff >= -6 && diff <= 0) {
				// Add the representation of the result onto the results string.
				result = result + x.getEntry();
				// Mark that at least one has been found.
				found = true;
				// If the entry is a sprint, divide the distance by 1000 (as sprints are
				// measured in meters, and multiply by the number of repetitions, then add the
				// total to the total running distance.
				if (x.getClass().getName().contains("Sprint")) {
					SprintEntry s = (SprintEntry) x;
					runtotal = runtotal + ((s.getDistance() / 1000) * s.getRepetitions());
				}
				// If the entry is a cycle entry, then add the total to the total cycling
				// distance.
				else if (x.getClass().getName().contains("Cycle")) {
					cycletotal = cycletotal + x.getDistance();
				}
				// If the entry is a swimming entry, then add the total to the total swimming
				// distance.
				else if (x.getClass().getName().contains("Swim")) {
					swimtotal = swimtotal + x.getDistance();
				}
				// If the entry is a running entry (as no other options exist), then add the
				// total to the total running distance.
				else {
					runtotal = runtotal + x.getDistance();
				}
			}
		}
		// Print the results, rounding the totals to avoid floating point errors.
		result = result + "Total running: " + (Math.round(runtotal * 1000) / 1000.0) + "km\nTotal cycling: "
				+ (Math.round(cycletotal * 1000) / 1000.0) + "km\nTotal swimming: "
				+ (Math.round(swimtotal * 1000) / 1000.0) + "km";
		// If at least one entry was found, return the results string, and return a
		// message if not.
		if (found) {
			return result;
		} else {
			return "Sorry, couldn't find anything in the last week";
		}
	} // lookupEntries

	/**
	 * Finds the number of entries present within the training record.
	 * 
	 * @return the number of entries
	 */
	public int getNumberOfEntries() {
		return tr.size();
	} // getNumberOfEntries

	/**
	 * Deletes all entries within the training record.
	 */
	public void clearAllEntries() {
		tr.clear();
	} // clearAllEntries

} // TrainingRecord