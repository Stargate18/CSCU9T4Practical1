/*
 * Test class for TrainingRecordGUI
 * It is not finished as we're not expecting you to implement GUI testing
 * However, you're welcome to use this starter template and extend it and add
 * test for public methods you implement in TrainingRecordGUI.java
 */
package com.stir.cscu9t4practical1;

import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
// Only used if you want to use reflection to test private features
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JButton;

/**
 *
 * @author saemundur
 */
public class TrainingRecordGUITest {

	public TrainingRecordGUITest() {
	}

	@BeforeAll
	public static void setUpClass() throws Exception {
	}

	@AfterAll
	public static void tearDownClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	/**
	 * Test of main method, of class TrainingRecordGUI. just tests if the class can
	 * be initialised without errors
	 */
	@Test
	public void testMain() {
		System.out.println("main");
		String[] args = null;
		TrainingRecordGUI.main(args);
	}

	/**
	 * Test of actionPerformed method, of class TrainingRecordGUI. This doesn't test
	 * anything but might be used in evaluations
	 */
	@Test
	public void testActionPerformed()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Action not performed");
	}

	/**
	 * Test of blankDisplay method, of class TrainingRecordGUI. It just executes the
	 * method to see if it doesn't throw an exception
	 */
	@Test
	public void testBlankDisplay() {
		System.out.println("blankDisplay");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		instance.blankDisplay();
	}

	/**
	 * Test of addEntry method's process of adding run entries, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddEntry() {
		System.out.println("addEntry");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
		instance.fillDisplay(entry);
		String message = instance.addEntry("run");
		System.out.println(message);
		assertEquals(message, "Record added");
	}

	/**
	 * Test of addEntry method's verification of name values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddEntryName() {
		System.out.println("addEntryName");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		Entry entry = new Entry("", 1, 2, 2022, 0, 16, 7, 3);
		instance.fillDisplay(entry);
		String message = instance.addEntry("run");
		System.out.println(message);
		assertEquals(message, "Name value was empty");
	}

	/**
	 * Test of addEntry method's verification of year values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddEntryYear() {
		// Due to the nature of fillDisplay requiring a valid entry, incorrect parameter
		// types cannot be tested through this system.
		System.out.println("addEntryYear");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		Entry entry = new Entry("Alice", 1, 2, 1799, 0, 16, 7, 3);
		instance.fillDisplay(entry);
		String message = instance.addEntry("run");
		System.out.println(message);
		assertEquals(message, "Invalid year value");
		entry = new Entry("Alice", 1, 2, 2301, 0, 16, 7, 3);
		instance.fillDisplay(entry);
		message = instance.addEntry("run");
		System.out.println(message);
		assertEquals(message, "Invalid year value");
	}

	/**
	 * Describe tests of addEntry method's verification of month values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddEntryMonth() {
		// Creation of an Entry, due to the data being stored in a Calendar object,
		// means any incorrect month or day values are adjusted.
		// Example:
		Entry entry = new Entry("Alice", 1, 200, 2022, 0, 16, 7, 3);
		assertEquals(entry.getYear(), 2038);
		// While the test cases will not give the correct value because of this, they
		// are included for completeness sake, as well as to show the tests completed
		// manually.
		// System.out.println("addEntryMonth");
		// TrainingRecordGUI instance = new TrainingRecordGUI();
		// Entry entry = new Entry("Alice", 1, 13, 2022, 0, 16, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid month value");
		// entry = new Entry("Alice", 1, 0, 2022, 0, 16, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid month value");
	}

	/**
	 * Describe tests of addEntry method's verification of day values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddEntryDay() {
		// System.out.println("addEntryDay");
		// TrainingRecordGUI instance = new TrainingRecordGUI();
		// Entry entry = new Entry("Alice", 0, 1, 2022, 0, 16, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid day value");
		// entry = new Entry("Alice", 32, 1, 2022, 0, 16, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid day value");
		// entry = new Entry("Alice", 31, 4, 2022, 0, 16, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid day value");
		// entry = new Entry("Alice", 30, 2, 2024, 0, 16, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid day value");
		// entry = new Entry("Alice", 29, 2, 2000, 0, 16, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid day value");
	}

	/**
	 * Describe tests of addEntry method's verification of hour values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddEntryHour() {
		// System.out.println("addEntryHour");
		// TrainingRecordGUI instance = new TrainingRecordGUI();
		// Entry entry = new Entry("Alice", 1, 2, 2022, -1, 16, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid hour value");
		// entry = new Entry("Alice", 1, 2, 2022, 24, 16, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid hour value");
	}

	/**
	 * Describe tests of addEntry method's verification of minute values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddEntryMinute() {
		// System.out.println("addEntryMinute");
		// TrainingRecordGUI instance = new TrainingRecordGUI();
		// Entry entry = new Entry("Alice", 1, 2, 2022, 0, -1, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid minute value");
		// entry = new Entry("Alice", 1, 2, 2022, 0, 60, 7, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid minute value");
	}

	/**
	 * Describe tests of addEntry method's verification of second values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddEntrySecond() {
		// System.out.println("addEntrySecond");
		// TrainingRecordGUI instance = new TrainingRecordGUI();
		// Entry entry = new Entry("Alice", 1, 2, 2022, 0, 16, -1, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid second value");
		// entry = new Entry("Alice", 1, 2, 2022, 0, 16, 60, 3);
		// instance.fillDisplay(entry);
		// message = instance.addEntry("run");
		// System.out.println(message);
		// assertEquals(message, "Invalid second value");
	}

	/**
	 * Test of addEntry method's verification of distance values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddEntryDistance() {
		System.out.println("addEntryDistance");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		Entry entry = new Entry("Alice", 1, 2, 2022, 0, 16, 7, 0);
		instance.fillDisplay(entry);
		String message = instance.addEntry("run");
		System.out.println(message);
		assertEquals(message, "Invalid distance value");
	}

	/**
	 * Test of addEntry method's process of adding cycle entries, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddCycleEntry() {
		System.out.println("addCycleEntry");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		CycleEntry entry = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
		instance.fillDisplay(entry);
		String message = instance.addEntry("cycle");
		System.out.println(message);
		assertEquals(message, "Record added");
	}

	/**
	 * Test of addEntry method's verification of terrain values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddCycleEntryTerrain() {
		System.out.println("addCycleEntryTerrain");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		CycleEntry entry = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "", "moderate");
		instance.fillDisplay(entry);
		String message = instance.addEntry("cycle");
		System.out.println(message);
		assertEquals(message, "Terrain value was empty");
	}

	/**
	 * Test of addEntry method's verification of tempo values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddCycleEntryTempo() {
		System.out.println("addCycleEntryTempo");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		CycleEntry entry = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "");
		instance.fillDisplay(entry);
		String message = instance.addEntry("cycle");
		System.out.println(message);
		assertEquals(message, "Tempo value was empty");
	}

	/**
	 * Test of addEntry method's process of adding sprint entries, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddSprintEntry() {
		System.out.println("addSprintEntry");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		SprintEntry entry = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, 5, 2);
		instance.fillDisplay(entry);
		String message = instance.addEntry("sprint");
		System.out.println(message);
		assertEquals(message, "Record added");
	}

	/**
	 * Test of addEntry method's verification of repetition values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddSprintEntryRepetitions() {
		System.out.println("addSprintEntryRepetitions");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		SprintEntry entry = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, 0, 2);
		instance.fillDisplay(entry);
		String message = instance.addEntry("sprint");
		System.out.println(message);
		assertEquals(message, "Invalid repetitions value");
	}

	/**
	 * Test of addEntry method's verification of recovery values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddSprintEntryRecovery() {
		System.out.println("addSprintEntryRecovery");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		SprintEntry entry = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, 5, -1);
		instance.fillDisplay(entry);
		String message = instance.addEntry("sprint");
		System.out.println(message);
		assertEquals(message, "Invalid recovery value");
	}

	/**
	 * Test of addEntry method's process of adding swim entries, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddSwimEntry() {
		System.out.println("addSwimEntry");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		SwimEntry entry = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "pool");
		instance.fillDisplay(entry);
		String message = instance.addEntry("swim");
		System.out.println(message);
		assertEquals(message, "Record added");
	}

	/**
	 * Test of addEntry method's verification of location values, of class
	 * TrainingRecordGUI
	 * 
	 */
	@Test
	public void testAddSwimEntryLocation() {
		System.out.println("addSwimEntryLocation");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		SwimEntry entry = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "");
		instance.fillDisplay(entry);
		String message = instance.addEntry("swim");
		System.out.println(message);
		assertEquals(message, "Location value was empty");
	}

	/**
	 * Test to see if all display requirements have been met
	 */
	@Test
	public void testButtonsPresentInGUI() throws IllegalAccessException, IllegalArgumentException {
		System.out.println("Check if you have added the buttons");
		TrainingRecordGUI instance = new TrainingRecordGUI();
		Class<?> instanceClass = instance.getClass();
		String[] expectedFields = { "findAllByDate", "lookUpByDate" }; // add RemoveEntry when it is ready
		Field fields[] = instanceClass.getDeclaredFields();
		int found = 0;
		for (Field field : fields) {
			if (Arrays.asList(expectedFields).contains(field.getName())) {
				found += 1;
				field.setAccessible(true);
				assertTrue(field.get(instance) instanceof JButton);
			}
		}
		assertEquals(found, expectedFields.length, "Have you added all required buttons?");
	}
}
