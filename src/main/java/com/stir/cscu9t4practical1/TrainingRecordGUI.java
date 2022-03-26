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
	private TrainingRecord myAthletes = new TrainingRecord();

	private JTextArea outputArea = new JTextArea(5, 50);

	/**
	 * The function called upon execution. Creates a new instancw of the class.
	 */
	public static void main(String[] args) {
		TrainingRecordGUI applic = new TrainingRecordGUI();
	} // main

	/**
	 * Constructor for the GUI. Adds all elements to the GUI, makes fields editable, and enables listeners.
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
		String message = "";
		if (event.getSource() == types) {
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
			if (types.getSelectedItem().toString().equals("Swim")) {
				labwhe.setVisible(true);
				where.setVisible(true);
			} else {
				labwhe.setVisible(false);
				where.setVisible(false);
			}

		}
		if (event.getSource() == addR) {
			addEntry(types.getSelectedItem().toString().toLowerCase());
		}
		if (event.getSource() == lookUpByDate) {
			message = lookupEntry();
		}
		if (event.getSource() == findAllByDate) {
			message = lookupEntries();
		}
		if (event.getSource() == findAllByName) {
			message = lookupEntriesByName();
		}
		if (event.getSource() == removeEntry) {
			message = removeEntry();
		}
		outputArea.setText(message);
		blankDisplay();
	} // actionPerformed

	/**
	 * Add an entry to the training record, using the information entered into the fields.
	 *
	 * @param what the type of entry to be added.
	 */
	public String addEntry(String what) {
		String message = "Record added\n";
		System.out.println("Adding " + what + " entry to the records");
		String n = name.getText();
		if (n.isBlank()) {
			return ("Name value was empty");
		}
		int y = 0;
		try {
			y = Integer.parseInt(year.getText());
			if (y < 1800 || y > 2300) { // Assuming that historical data entry is possible, imposing reasonable limits
										// on the timeframe.
				return ("Invalid year value");
			}
		} catch (NumberFormatException e) {
			return ("Year value was not an integer");
		}
		int m = 0;
		try {
			m = Integer.parseInt(month.getText());
			if (m > 12 || m < 1) {
				return ("Invalid month value");
			}
		} catch (NumberFormatException e) {
			return ("Month value was not an integer");
		}
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
		float km = 0;
		try {
			km = java.lang.Float.parseFloat(dist.getText());
			if (km <= 0) {
				return ("Invalid distance value");
			}
		} catch (NumberFormatException e) {
			return ("Distance value was not a float");
		}
		int h = 0;
		try {
			h = Integer.parseInt(hours.getText());
			if (h < 0) {
				return ("Invalid hour value");
			}
		} catch (NumberFormatException e) {
			return ("Hour value was not an integer");
		}
		int mm = 0;
		try {
			mm = Integer.parseInt(mins.getText());
			if (mm > 59 || mm < 0) {
				return ("Invalid minute value");
			}
		} catch (NumberFormatException e) {
			return ("Minute value was not an integer");
		}
		int s = 0;
		try {
			s = Integer.parseInt(secs.getText());
			if (s > 59 || s < 0) {
				return ("Invalid second value");
			}
		} catch (NumberFormatException e) {
			return ("Second value was not an integer");
		}
		Entry e;
		if (what == "run") {
			e = new Entry(n, d, m, y, h, mm, s, km);
		} else if (what == "sprint") {
			int rep = 0;
			try {
				rep = Integer.parseInt(repet.getText());
			} catch (NumberFormatException f) {
				return ("Repeitions value was not an integer");
			}
			int rec = 0;
			try {
				rec = Integer.parseInt(reco.getText());
			} catch (NumberFormatException f) {
				return ("Recovery value was not an integer");
			}
			e = new SprintEntry(n, d, m, y, h, mm, s, km, rep, rec);
		} else if (what == "cycle") {
			String terrain = terr.getText();
			String tempo = temp.getText();
			e = new CycleEntry(n, d, m, y, h, mm, s, km, terrain, tempo);
		} else {
			String w = where.getText();
			e = new SwimEntry(n, d, m, y, h, mm, s, km, w);
		}
		myAthletes.addEntry(e);
		return message;
	}

	/**
	 * For GUI testing purposes - fills the GUI's fields with the information from
	 * an entry object
	 *
	 * @param ent the entry used for testing
	 */
	public String lookupEntry() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.lookupEntry(d, m, y);
		return message;
	}

	public String lookupEntries() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up records ...");
		String message = myAthletes.lookupEntries(d, m, y);
		return message;
	}

	public String lookupEntriesByName() {
		String n = name.getText();
		outputArea.setText("looking up records ...");
		String message = myAthletes.lookupEntriesByName(n);
		return message;
	}

	public String removeEntry() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		String n = name.getText();
		outputArea.setText("looking up records ...");
		String message = myAthletes.removeEntry(m, d, y, n);
		return message;
	}

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
	}// blankDisplay
		// Fills the input fields on the display for testing purposes only

	/**
	 * For GUI testing purposes - fills the GUI's fields with the information from
	 * an entry object
	 *
	 * @param ent the entry used for testing
	 */
	public void fillDisplay(Entry ent) {
		if (ent.getClass().getName().contains("CycleEntry")) {
			CycleEntry ent2 = (CycleEntry) ent;
			types.setSelectedItem("Cycle");
			terr.setText(ent2.getTerrain());
			temp.setText(ent2.getTempo());
		} else if (ent.getClass().getName().contains("SprintEntry")) {
			SprintEntry ent2 = (SprintEntry) ent;
			types.setSelectedItem("Sprint");
			repet.setText(String.valueOf(ent2.getRepetitions()));
			reco.setText(String.valueOf(ent2.getRecovery()));
		} else if (ent.getClass().getName().contains("SwimEntry")) {
			SwimEntry ent2 = (SwimEntry) ent;
			types.setSelectedItem("Swim");
			where.setText(ent2.getWhere());
		} else {
			types.setSelectedItem("Run");
		}
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
	}

} // TrainingRecordGUI
