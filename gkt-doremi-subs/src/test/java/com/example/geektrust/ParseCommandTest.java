package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class ParseCommandTest {

	@Test
	void testRun() {
		ParseCommand parseCommand = new ParseCommand("sample_input/input1.txt");
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		String inputData = "START_SUBSCRIPTION 05-02-2022\n" + "ADD_SUBSCRIPTION MUSIC PERSONAL\n"
				+ "ADD_SUBSCRIPTION VIDEO PREMIUM\n" + "ADD_SUBSCRIPTION PODCAST FREE\n" + "ADD_TOPUP FOUR_DEVICE 2\n"
				+ "PRINT_RENEWAL_DETAILS\n";
		String expected = "RENEWAL_REMINDER MUSIC 23-02-2022\n" + "RENEWAL_REMINDER VIDEO 25-04-2022\n"
				+ "RENEWAL_REMINDER PODCAST 23-02-2022\n" + "RENEWAL_AMOUNT 700\n";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));

		parseCommand.run();

		System.setIn(stdin);
		System.setOut(stdout);
		assertEquals(expected, outContent.toString());
	}

	@Test
	void testRun2() {
		ParseCommand parseCommand = new ParseCommand("sample_input/input2.txt");
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		String inputData = "START_SUBSCRIPTION 08-12-2019\n" + "ADD_SUBSCRIPTION MUSIC PREMIUM\n"
				+ "ADD_SUBSCRIPTION PODCAST FREE\n" + "ADD_TOPUP TEN_DEVICE 3\n" + "PRINT_RENEWAL_DETAILS\n";
		String expected = "RENEWAL_REMINDER MUSIC 27-02-2020\n" + "RENEWAL_REMINDER PODCAST 29-12-2019\n"
				+ "RENEWAL_AMOUNT 550\n";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));

		parseCommand.run();

		System.setIn(stdin);
		System.setOut(stdout);
		assertEquals(expected, outContent.toString());
	}

	@Test
	void testRun3() {
		ParseCommand parseCommand = new ParseCommand("sample_input/input3.txt");
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		String inputData = "START_SUBSCRIPTION 25-07-2021\n" + "ADD_SUBSCRIPTION MUSIC PREMIUM\n"
				+ "ADD_SUBSCRIPTION VIDEO PREMIUM\n" + "ADD_SUBSCRIPTION PODCAST PERSONAL\n"
				+ "PRINT_RENEWAL_DETAILS\n";

		String expected = "RENEWAL_REMINDER MUSIC 15-10-2021\n" + "RENEWAL_REMINDER VIDEO 15-10-2021\n"
				+ "RENEWAL_REMINDER PODCAST 15-08-2021\n" + "RENEWAL_AMOUNT 850\n";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));

		parseCommand.run();

		System.setIn(stdin);
		System.setOut(stdout);
		assertEquals(expected, outContent.toString());
	}

	@Test
	void testRun4() {
		ParseCommand parseCommand = new ParseCommand("sample_input/input4.txt");
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		String inputData = "START_SUBSCRIPTION 10-21-2022\n" + "ADD_SUBSCRIPTION MUSIC PERSONAL\n"
				+ "ADD_SUBSCRIPTION MUSIC PREMIUM\n" + "ADD_TOPUP TEN_DEVICE 3\n" + "PRINT_RENEWAL_DETAILS\n";

		String expected = "INVALID_DATE\n" + "ADD_SUBSCRIPTION_FAILED INVALID_DATE\n"
				+ "ADD_SUBSCRIPTION_FAILED INVALID_DATE\n" + "ADD_TOPUP_FAILED INVALID_DATE\n"
				+ "SUBSCRIPTIONS_NOT_FOUND\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));

		parseCommand.run();

		System.setIn(stdin);
		System.setOut(stdout);
		assertEquals(expected, outContent.toString());
	}

	@Test
	void testRun5() {
		ParseCommand parseCommand = new ParseCommand("sample_input/input5.txt");
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		String inputData = "START_SUBSCRIPTION 20-10-2022\n" + "ADD_SUBSCRIPTION MUSIC PERSONAL\n"
				+ "ADD_SUBSCRIPTION MUSIC PREMIUM\n" + "ADD_TOPUP TEN_DEVICE 1\n" + "ADD_TOPUP TEN_DEVICE 1\n"
				+ "PRINT_RENEWAL_DETAILS\n";

		String expected = "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n" + "ADD_TOPUP_FAILED DUPLICATE_TOPUP\n"
				+ "RENEWAL_REMINDER MUSIC 10-11-2022\n" + "RENEWAL_AMOUNT 200\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));

		parseCommand.run();

		System.setIn(stdin);
		System.setOut(stdout);
		assertEquals(expected, outContent.toString());
	}

	@Test
	void testRun6() {
		ParseCommand parseCommand = new ParseCommand("sample_input/input6.txt");
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		String inputData = "START_SUBSCRIPTION 20-02-2022\n" + "ADD_SUBSCRIPTION MUSIC PERSONAL\n"
				+ "ADD_SUBSCRIPTION VIDEO PREMIUM\n" + "ADD_SUBSCRIPTION PODCAST FREE\n" + "ADD_TOPUP FOUR_DEVICE 3\n"
				+ "PRINT_RENEWAL_DETAILS\n";

		String expected = "RENEWAL_REMINDER MUSIC 10-03-2022\n" + "RENEWAL_REMINDER VIDEO 10-05-2022\n"
				+ "RENEWAL_REMINDER PODCAST 10-03-2022\n" + "RENEWAL_AMOUNT 750\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));

		parseCommand.run();

		System.setIn(stdin);
		System.setOut(stdout);
		assertEquals(expected, outContent.toString());
	}
}
