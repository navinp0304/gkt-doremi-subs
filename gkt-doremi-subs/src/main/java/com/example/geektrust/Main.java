package com.example.geektrust;

public class Main {
	public void init() {
	}

	public static void main(String[] args) {
		ParseCommand pc = new ParseCommand(args[0]);
		pc.run();
	}
}
