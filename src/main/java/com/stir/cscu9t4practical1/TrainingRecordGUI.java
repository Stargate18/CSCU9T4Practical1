// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.util.List;

public class TrainingRecordGUI extends JFrame implements ActionListener {
	private String[] data = { "Run", "Sprint", "Cycle", "Swim" };
	private JComboBox<String> types = new JComboBox<String>(data);
	private JTextField name = new JTextField(30);
	private JTextField day = new JTextField(2);
	private JTextField month = new JTextField(2);
	private JTextField year = new JTextField(4);
	private JTextField hours = new JTextField(2);
	private JTextField mins = new JTextField(2);
	private JTextField secs = new JTextField(2);
	private JTextField dist = new JTextField(4);
	private JTextField terr = new JTextField(8);
	private JTextField temp = new JTextField(8);
	private JTextField where = new JTextField(5);
	private JTextField repet = new JTextField(4);
	private JTextField reco = new JTextField(4);
	private JLabel labn = new JLabel(" Name:");
	private JLabel labd = new JLabel(" Day:");
	private JLabel labm = new JLabel(" Month:");
	private JLabel laby = new JLabel(" Year:");
	private JLabel labh = new JLabel(" Hours:");
	private JLabel labmm = new JLabel(" Mins:");
	private JLabel labs = new JLabel(" Secs:");
	private JLabel labdist = new JLabel(" Distance (km):");
	private JLabel labter = new JLabel(" Terrain:");
	private JLabel labtem = new JLabel(" Tempo:");
	private JLabel labwhe = new JLabel(" Where:");
	private JLabel labrep = new JLabel(" Repetitions:");
	private JLabel labrec = new JLabel(" Recovery:");
	private JButton addR = new JButton("Add");
	private JButton lookUpByDate = new JButton("Look Up");
	private JButton findAllByDate = new JButton("Find By Date");
	private JButton findAllByName = new JButton("Find By Name");
	private JButton removeEntry = new JButton("Remove By Date/Name");
	private JButton weeklyDistance = new JButton("Weekly Distance?");
	private TrainingRecord myAthletes = new TrainingRecord();

	private JTextArea outputArea = new JTextArea(5, 50);

	/**
	 * The function called upon execution. Creates a new instancw of the class.
	 */
	public static void main(String[] args) {
		TrainingRecordGUI applic = new TrainingRecordGUI();
	} // main

	/**
	 * Constructor for the GUI. Adds all elements to the GUI, makes fields editable,
	 * and enables listeners.
	 */
	public TrainingRecordGUI() {
		super("Training Record");
		setLayout(new FlowLayout());
		add(types);
		types.addActionListener(this);
		add(labn);
		add(name);
		name.setEditable(true);
		add(labd);
		add(day);
		day.setEditable(true);
		add(labm);
		add(month);
		month.setEditable(true);
		add(laby);
		add(year);
		year.setEditable(true);
		add(labh);
		add(hours);
		hours.setEditable(true);
		add(labmm);
		add(mins);
		mins.setEditable(true);
		add(labs);
		add(secs);
		secs.setEditable(true);
		add(labdist);
		add(dist);
		dist.setEditable(true);
		add(labter);
		labter.setVisible(false);
		add(terr);
		terr.setVisible(false);
		terr.setEditable(true);
		add(labtem);
		labtem.setVisible(false);
		add(temp);
		temp.setVisible(false);
		temp.setEditable(true);
		add(labwhe);
		labwhe.setVisible(false);
		add(where);
		where.setVisible(false);
		where.setEditable(true);
		add(labrep);
		labrep.setVisible(false);
		add(repet);
		repet.setVisible(false);
		repet.setEditable(true);
		add(labrec);
		labrec.setVisible(false);
		add(reco);
		reco.setVisible(false);
		reco.setEditable(true);
		add(addR);
		addR.addActionListener(this);
		add(lookUpByDate);
		lookUpByDate.addActionListener(this);
		add(findAllByDate);
		findAllByDate.addActionListener(this);
		add(findAllByName);
		findAllByName.addActionListener(this);
		add(removeEntry);
		removeEntry.addActionListener(this);
		add(weeklyDistance);
		weeklyDistance.addActionListener(this);
		lookUpByDate.setEnabled(false);
		findAllByDate.setEnabled(false);
		findAllByName.setEnabled(false);
		removeEntry.setEnabled(false);
		weeklyDistance.setEnabled(false);
		add(outputArea);
		outputArea.setEditable(false);
		setSize(720, 200);
		setVisible(true);
		blankDisplay();
	} // constructor

	/**
	 * Listens for and responds to GUI events.
	 *
	 * @param event the action that occurred
	 */
	public void actionPerformed(ActionEvent event) {
		// Set a default message for if nothing is changed.
		String message = "";
		// If the selector for the type of entry is changed, run this code.
		if (event.getSource() == types) {
			// If it is a sprint, change the distance label to use the appropriate unit,
			// and make the sprint-exclusive fields and labels visible.
			// If the type selected is not this, change the unit back and hide the fields
			// and labels.
			if (types.getSelectedItem().toString().equals("Sprint")) {
				labdist.setText(" Distance (m):");
				labrep.setVisible(true);
				repet.setVisible(true);
				labrec.setVisible(true);
				reco.setVisible(true);
			} else {
				labdist.setText(" Distance (km):");
				labrep.setVisible(false);
				repet.setVisible(false);
				labrec.setVisible(false);
				reco.setVisible(false);
			}
			// If it is a cycle, make the cycle-exclusive fields and labels visible.
			// If the type selected is not this, hide the fields and labels.
			if (types.getSelectedItem().toString().equals("Cycle")) {
				labter.setVisible(true);
				terr.setVisible(true);
				labtem.setVisible(true);
				temp.setVisible(true);
			} else {
				labter.setVisible(false);
				terr.setVisible(false);
				labtem.setVisible(false);
				temp.setVisible(false);
			}
			// If it is a swim, make the swim-exclusive field and label visible.
			// If the type selected is not this, hide the field and label.
			if (types.getSelectedItem().toString().equals("Swim")) {
				labwhe.setVisible(true);
				where.setVisible(true);
			} else {
				labwhe.setVisible(false);
				where.setVisible(false);
			}

		}
		// If the event is an entry being added, call addEntry, using the selected type
		// as an argument, then make the search and deletion buttons active if there is
		// more than one entry present in the training record.
		if (event.getSource() == addR) {
			addEntry(types.getSelectedItem().toString().toLowerCase());
			if (myAthletes.getNumberOfEntries() > 0) {
				lookUpByDate.setEnabled(true);
				findAllByDate.setEnabled(true);
				findAllByName.setEnabled(true);
				removeEntry.setEnabled(true);
				weeklyDistance.setEnabled(true);
			}
		}
		// If the event is the button to look up an entry by date, call lookupEntry() to
		// handle it.
		if (event.getSource() == lookUpByDate) {
			message = lookupEntry();
		}
		// If the event is the button to find all entries by date, call lookupEntries()
		// to handle it.
		if (event.getSource() == findAllByDate) {
			message = lookupEntries();
		}
		// If the event is the button to find all entries by name, call
		// lookupEntriesByName() to handle it.
		if (event.getSource() == findAllByName) {
			message = lookupEntriesByName();
		}
		// If the event is the button to remove all entries, call lookupEntriesByName()
		// to handle it then make the search and deletion buttons inactive if there are
		// no entries present in the training record.
		if (event.getSource() == removeEntry) {
			message = removeEntry();
			if (myAthletes.getNumberOfEntries() == 0) {
				lookUpByDate.setEnabled(false);
				findAllByDate.setEnabled(false);
				findAllByName.setEnabled(false);
				removeEntry.setEnabled(false);
				weeklyDistance.setEnabled(false);
			}
		}
		if (event.getSource() == weeklyDistance) {
			message = myAthletes.weeklyDistance();
		}
		// Show the message in the output area.
		outputArea.setText(message);
		// Erase the contents of all fields.
		blankDisplay();
	} // actionPerformed

	/**
	 * Add an entry to the training record, using the information entered into the
	 * fields.
	 *
	 * @param what the type of entry to be added.
	 */
	public String addEntry(String what) {
		// Print what kind of entry is being added to the console.
		System.out.println("Adding " + what + " entry to the records");
		// Receive the name value, using an if statement after to ensure the contents
		// aren't empty.
		String n = name.getText();
		if (n.isBlank()) {
			return ("Name value was empty");
		}
		// Receive the year value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		// In addition, checks if the year is within a reasonable bound, giving a
		// different message if so.
		int y = 0;
		try {
			y = Integer.parseInt(year.getText());
			if (y < 1800 || y > 2300) {
				return ("Invalid year value");
			}
		} catch (NumberFormatException e) {
			return ("Year value was not an integer");
		}
		// Receive the year value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		// In addition, checks if the month is valid, giving a different message if not.
		int m = 0;
		try {
			m = Integer.parseInt(month.getText());
			if (m > 12 || m < 1) {
				return ("Invalid month value");
			}
		} catch (NumberFormatException e) {
			return ("Month value was not an integer");
		}
		// Receive the day value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		// In addition, checks if the day is valid, giving a different message if not.
		// (Note that leap years are accounted for, but the algorithm is simplified by
		// the limits on the year entry.)
		int d = 0;
		try {
			d = Integer.parseInt(day.getText());
			if (d < 1) {
				return ("Invalid day value");
			} else if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) {
				return ("Invalid day value");
			} else if (m == 2) {
				if ((y % 4 == 0 && (y % 100 != 0 || y == 2000)) && d > 29) {
					return ("Invalid day value");
				} else if (d > 28) {
					return ("Invalid day value");
				}
			} else if (d > 31) {
				return ("Invalid day value");
			}
		} catch (NumberFormatException e) {
			return ("Day value was not an integer");
		}
		// Receive the distance value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		// In addition, checks if the distance is positive, giving a different message
		// if not.
		float km = 0;
		try {
			km = java.lang.Float.parseFloat(dist.getText());
			if (km <= 0) {
				return ("Invalid distance value");
			}
		} catch (NumberFormatException e) {
			return ("Distance value was not a float");
		}
		// Receive the hour value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		// In addition, checks if the number of hours is positive, giving a different
		// message if not. (No upper bound specified, as periods over 24 hours are
		// possible.
		int h = 0;
		try {
			h = Integer.parseInt(hours.getText());
			if (h < 0) {
				return ("Invalid hour value");
			}
		} catch (NumberFormatException e) {
			return ("Hour value was not an integer");
		}
		// Receive the minute value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		// In addition, checks if the number of minutes is within the acceptable bounds,
		// giving a different message if not.
		int mm = 0;
		try {
			mm = Integer.parseInt(mins.getText());
			if (mm > 59 || mm < 0) {
				return ("Invalid minute value");
			}
		} catch (NumberFormatException e) {
			return ("Minute value was not an integer");
		}
		// Receive the minute value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		// In addition, checks if the number of seconds is within the acceptable bounds,
		// giving a different message if not.
		int s = 0;
		try {
			s = Integer.parseInt(secs.getText());
			if (s > 59 || s < 0) {
				return ("Invalid second value");
			}
		} catch (NumberFormatException e) {
			return ("Second value was not an integer");
		}
		// Declare an entry e.
		Entry e;
		// If the entry is a run, instantiate a new entry using the provided parameters.
		if (what == "run") {
			e = new Entry(n, d, m, y, h, mm, s, km);
		}
		// If the entry is a sprint entry, run the contained code.
		else if (what == "sprint") {
			// Receive the repetitions value, using a try-catch loop to catch exceptions
			// from non-integer inputs - terminating the function with a message if so.
			// In addition, checks if the number of repetitions is positive, giving a
			// different message if not.
			int rep = 0;
			try {
				rep = Integer.parseInt(repet.getText());
				if (rep < 0) {
					return ("Invalid repetitions value");
				}
			} catch (NumberFormatException f) {
				return ("Repetitions value was not an integer");
			}
			// Receive the recovery value, using a try-catch loop to catch exceptions
			// from non-integer inputs - terminating the function with a message if so.
			// In addition, checks if the recovery time is positive, giving a different
			// message if not.
			int rec = 0;
			try {
				rec = Integer.parseInt(reco.getText());
				if (rec < 0) {
					return ("Invalid recovery value");
				}
			} catch (NumberFormatException f) {
				return ("Recovery value was not an integer");
			}
			// Instantiate a new sprint entry using the provided parameters.
			e = new SprintEntry(n, d, m, y, h, mm, s, km, rep, rec);
		}
		// If the entry is a cycle entry, run the contained code.
		else if (what == "cycle") {
			// Receive the terrain value, using an if statement after to ensure the
			// contents aren't empty.
			String terrain = terr.getText();
			if (terrain.isBlank()) {
				return ("Terrain value was empty");
			}
			// Receive the tempo value, using an if statement after to ensure the
			// contents aren't empty.
			String tempo = temp.getText();
			if (tempo.isBlank()) {
				return ("Tempo value was empty");
			}
			// Instantiate a new cycle entry using the provided parameters.
			e = new CycleEntry(n, d, m, y, h, mm, s, km, terrain, tempo);
		}
		// If the entry is a swim entry (the only other option), run the contained code.
		else {
			// Receive the location value, using an if statement after to ensure the
			// contents aren't empty.
			String w = where.getText();
			if (w.isBlank()) {
				return ("Location value was empty");
			}
			// Instantiate a new swim entry using the provided parameters.
			e = new SwimEntry(n, d, m, y, h, mm, s, km, w);
		}
		// Add the entry to the training record, returning the received output.
		String message = myAthletes.addEntry(e);
		return message;
	} // addEntry

	/**
	 * Call a function to find an entry that matches a date, using the arguments
	 * provided in the GUI's fields.
	 */
	public String lookupEntry() {
		// Receive the year value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		int y = 0;
		try {
			y = Integer.parseInt(year.getText());
		} catch (NumberFormatException e) {
			return ("Year value was not an integer");
		}
		// Receive the month value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		int m = 0;
		try {
			m = Integer.parseInt(month.getText());
		} catch (NumberFormatException e) {
			return ("Month value was not an integer");
		}
		// Receive the day value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		int d = 0;
		try {
			d = Integer.parseInt(day.getText());
		} catch (NumberFormatException e) {
			return ("Day value was not an integer");
		}
		// Display a message informing the user that the process is in progress.
		outputArea.setText("looking up record ...");
		// Retrieve the entries from the training record, returning the received output.
		String message = myAthletes.lookupEntry(d, m, y);
		return message;
	} // lookupEntry

	/**
	 * Call a function to find all entry that match a date, using the arguments
	 * provided in the GUI's fields.
	 */
	public String lookupEntries() {
		// Receive the year value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		int y = 0;
		try {
			y = Integer.parseInt(year.getText());
		} catch (NumberFormatException e) {
			return ("Year value was not an integer");
		}
		// Receive the month value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		int m = 0;
		try {
			m = Integer.parseInt(month.getText());
		} catch (NumberFormatException e) {
			return ("Month value was not an integer");
		}
		// Receive the day value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		int d = 0;
		try {
			d = Integer.parseInt(day.getText());
		} catch (NumberFormatException e) {
			return ("Day value was not an integer");
		}
		// Display a message informing the user that the process is in progress.
		outputArea.setText("looking up records ...");
		// Retrieve the entries from the training record, returning the received output.
		String message = myAthletes.lookupEntries(d, m, y);
		return message;
	} // lookupEntries

	/**
	 * Call a function to find all entry that match a name, using the arguments
	 * provided in the GUI's fields.
	 */
	public String lookupEntriesByName() {
		// Receive the name value, using an if statement after to ensure the contents
		// aren't empty.
		String n = name.getText();
		if (n.isBlank()) {
			return ("Name value was empty");
		}
		// Display a message informing the user that the process is in progress.
		outputArea.setText("looking up records ...");
		// Retrieve the entries from the training record, returning the received output.
		String message = myAthletes.lookupEntriesByName(n);
		return message;
	} // lookupEntriesByName

	/**
	 * Call a function to remove the entry that matches a date and name, using the
	 * arguments provided in the GUI's fields.
	 */
	public String removeEntry() {
		// Receive the year value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		int y = 0;
		try {
			y = Integer.parseInt(year.getText());
		} catch (NumberFormatException e) {
			return ("Year value was not an integer");
		}
		// Receive the month value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		int m = 0;
		try {
			m = Integer.parseInt(month.getText());
		} catch (NumberFormatException e) {
			return ("Month value was not an integer");
		}
		// Receive the day value, using a try-catch loop to catch exceptions from
		// non-integer inputs - terminating the function with a message if so.
		int d = 0;
		try {
			d = Integer.parseInt(day.getText());
		} catch (NumberFormatException e) {
			return ("Day value was not an integer");
		}
		// Receive the name value, using an if statement after to ensure the contents
		// aren't empty.
		String n = name.getText();
		if (n.isBlank()) {
			return ("Name value was empty");
		}
		// Display a message informing the user that the process is in progress.
		outputArea.setText("looking up records ...");
		// Remove the entry from the training record, returning the received output.
		String message = myAthletes.removeEntry(d, m, y, n);
		return message;
	} // removeEntry

	/**
	 * Clear all fields in the GUI
	 */
	public void blankDisplay() {
		name.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		hours.setText("");
		mins.setText("");
		secs.setText("");
		dist.setText("");
		terr.setText("");
		temp.setText("");
		where.setText("");
		repet.setText("");
		reco.setText("");
	} // blankDisplay

	/**
	 * For GUI testing purposes - fills the GUI's fields with the information from
	 * an entry object
	 *
	 * @param ent the entry used for testing
	 */
	public void fillDisplay(Entry ent) {
		// If the entry to be used is a cycle entry, cast it to a new variable of that
		// class, update the type selector accordingly, and use the class methods to
		// fill the terrain and tempo fields.
		if (ent.getClass().getName().contains("CycleEntry")) {
			CycleEntry ent2 = (CycleEntry) ent;
			types.setSelectedItem("Cycle");
			terr.setText(ent2.getTerrain());
			temp.setText(ent2.getTempo());
		}
		// If the entry to be used is a sprint entry, cast it to a new variable of that
		// class, update the type selector accordingly, and use the class methods to
		// fill the repetitions and recovery fields.
		else if (ent.getClass().getName().contains("SprintEntry")) {
			SprintEntry ent2 = (SprintEntry) ent;
			types.setSelectedItem("Sprint");
			repet.setText(String.valueOf(ent2.getRepetitions()));
			reco.setText(String.valueOf(ent2.getRecovery()));
		}
		// If the entry to be used is a swim entry, cast it to a new variable of that
		// class, update the type selector accordingly, and use the class methods to
		// fill the location field.
		else if (ent.getClass().getName().contains("SwimEntry")) {
			SwimEntry ent2 = (SwimEntry) ent;
			types.setSelectedItem("Swim");
			where.setText(ent2.getWhere());
		} // If not, set the type selector to the only other option.
		else {
			types.setSelectedItem("Run");
		}
		// Fill each other field with the appropriate content, using valueOf when
		// importing a numerical value.
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
	} // fillDisplay

} // TrainingRecordGUI
