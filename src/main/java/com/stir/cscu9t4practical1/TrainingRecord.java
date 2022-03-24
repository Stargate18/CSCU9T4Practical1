// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
	private List<Entry> tr;

	public TrainingRecord() {
		tr = new ArrayList<Entry>();
	} // constructor

	// add a record to the list
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

	// look up the entry of a given day, month and year
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

// look up all entries of a given name
	public String lookupEntriesByName(String n) {
		boolean found = false;
		String result = "";
		for (Entry x : tr) {
			System.out.println(x.getName());
			if (x.getName().toLowerCase().contains(n.toLowerCase())) {
				result = result + x.getEntry();
				found = true;
			}
		}
		if (found) {
			return result;
		} else {
			return "Sorry couldn't find anything for this date";
		}
	} // lookupEntriesByName
	
	// look up all entries of a given name
		public String removeEntry(int d, int m, int y, String n) {
			boolean found = false;
			for (Entry x : tr) {
				if (x.getName().equalsIgnoreCase(n) && x.getDay() == d && x.getMonth() == m
						&& x.getYear() == y) {
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

	// Count the number of entries
	public int getNumberOfEntries() {
		return tr.size();
	}

	// Clear all entries
	public void clearAllEntries() {
		tr.clear();
	}

} // TrainingRecord