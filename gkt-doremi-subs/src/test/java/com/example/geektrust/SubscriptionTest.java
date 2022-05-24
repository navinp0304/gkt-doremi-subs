package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SubscriptionTest {
	@Test
	void testRenewalDate() {

		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("10-02-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("30-02-2022");
		assertEquals(end,exp);
	}

	@Test
	void testRenewalDate1() {
		
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("01-02-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("21-02-2022");
		assertEquals(end,exp);
	}
	
	@Test
	void testRenewalDate2() {
		
		
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("11-02-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("01-03-2022");
		assertEquals(end,exp);
	}

	@Test
	void testRenewalDate3() {

		
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("09-02-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("29-02-2022");
		assertEquals(end,exp);
	}
	
	@Test
	void testRenewalDate4() {
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("29-02-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("19-03-2022");
		assertEquals(end,exp);
	}
	
	@Test
	void testRenewalDate5() {
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("30-02-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("20-03-2022");
		assertEquals(end,exp);
	}
	
	@Test
	void testRenewalDate6() {
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("10-11-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("30-11-2022");
		assertEquals(end,exp);
	}
	
	@Test
	void testRenewalDate7() {
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("01-12-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("21-12-2022");
		assertEquals(end,exp);
	}
	
	@Test
	void testRenewalDate8() {		
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("10-12-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("30-12-2022");
		assertEquals(end,exp);
	}
	
	@Test
	void testRenewalDate9() {
		
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("29-12-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("19-01-2023");
		assertEquals(end,exp);
	}
	
	
	@Test
	void testRenewalDate10() {
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("30-12-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("20-01-2023");
		assertEquals(end,exp);
	}
	
	@Test
	void testRenewalFree() {
		List<IStream> stream=List.of(new MusicStream(new FreePlan()));
		Subscription obj = new Subscription("30-12-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("20-01-2023");
		assertEquals(end,exp);
	}
	
	@Test
	void testRenewalPremium() {
		List<IStream> stream=List.of(new MusicStream(new PremiumPlan()));
		Subscription obj = new Subscription("30-12-2022");
		List<String> end = obj.renewalDate();
		List<String> exp = List.of("20-03-2023");
		assertEquals(end,exp);
	}

	@Test
	void testSubscription() {
		List<IStream> stream=List.of(new MusicStream(new PersonalPlan()));
		Subscription obj = new Subscription("01-02-2022");
		assertNotEquals(obj,null);
	}

}
