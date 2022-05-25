package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateServiceTest {

	@Test
	void testDateServiceStringIPlan() {
		try {
			new DateService("10-22-2010", new FreePlan(2));
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "INVALID_DATE");
		}
	}

	@Test
	void testDateServiceString() {
		try {
			new DateService("10-22-2010");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "INVALID_DATE");
		}
	}

	@Test
	void testIsDate() {
		try {
			new DateService("10-22-2010").isDate();
		} catch (IllegalArgumentException ex) {
			assertTrue(true);
			return;
		}
		assertFalse(true);
	}

	@Test
	void testRenewalDate() {

	}

}
