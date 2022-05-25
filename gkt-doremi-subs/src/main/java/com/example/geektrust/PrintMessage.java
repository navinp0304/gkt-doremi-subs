package com.example.geektrust;

public class PrintMessage {
	public String getPrefix(String prefix, Subscription subscription, String command0, String Command1) {
		return ((subscription == null) && (command0.equals(Command1))) ? "" : prefix;
	}

	public String getPrefix(String prefix, Boolean value, Subscription subscription) {
		return ((subscription == null) && value) ? "" : prefix;
	}

	public Boolean printMessage(String message) {
		System.out.printf(message);
		return true;
	}

}
