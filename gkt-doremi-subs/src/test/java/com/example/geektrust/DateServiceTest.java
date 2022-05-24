package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateServiceTest {

	@Test
	void testDateService() {
		DateService d = new DateService("05-02-2022", new PersonalPlan());
		assertNotEquals(d, null);
	}

	@Test
	void testRenewalDate() {
		DateService d = new DateService("05-02-2022", new PersonalPlan());
		String act = d.renewalDate();
		String exp = "23-02-2022";
		assertEquals(exp, act);
	}

	@Test
	void testRenewalDate1() {
		DateService d = new DateService("05-02-2022", new PremiumPlan());
		String act = d.renewalDate();
		String exp = "25-04-2022";
		assertEquals(exp, act);
	}

	@Test
	void testRenewalDate2() {
		DateService d = new DateService("05-02-2022", new FreePlan());
		String act = d.renewalDate();
		String exp = "23-02-2022";
		assertEquals(exp, act);
	}

	@Test
	void testRenewalDate3() {
		DateService d = new DateService("08-12-2019", new PremiumPlan());
		String act = d.renewalDate();
		String exp = "27-02-2020";
		assertEquals(exp, act);
	}

	@Test
	void testRenewalDate4() {
		DateService d = new DateService("08-12-2019", new FreePlan());
		String act = d.renewalDate();
		String exp = "29-12-2019";
		assertEquals(exp, act);
	}

	@Test
	void testRenewalDate5() {
		DateService d = new DateService("25-07-2021", new PremiumPlan());
		String act = d.renewalDate();
		String exp = "15-10-2021";
		assertEquals(exp, act);
	}

	@Test
	void testRenewalDate6() {
		String act = "";
		try {
			DateService d = new DateService("10-21-2022", new PersonalPlan());
			act = d.renewalDate();
		} catch (IllegalArgumentException ex) {
			act = ex.getMessage();
		}
		String exp = "INVALID_DATE";
		assertEquals(exp, act);
	}
}
