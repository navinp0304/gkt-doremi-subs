package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testInit() {
		Main mainInst = new Main();
		mainInst.init();

	}

	@Test
	void testMain() {
		Main mainInst = new Main();
		String[] cargs = { "sample_input/input1.txt" };
		mainInst.main(cargs);
	}

	@Test
	void testMain2() {
		Main mainInst = new Main();
		String[] cargs = { "noexistfile.txt" };
		mainInst.main(cargs);
	}

}
