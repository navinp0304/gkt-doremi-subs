package com.example.geektrust;

public class TopupFourDevice implements ITopup {
	private final Integer devices = 4;
	private final Integer cost = 50;
	private final Integer duration;

	TopupFourDevice(String duration) {
		String[] tokens = duration.split(" ");
		this.duration = Integer.parseInt(tokens[2]);
	}

	@Override
	public Integer devices() {
		return this.devices;
	}

	@Override
	public Integer cost() {
		return this.cost * duration;
	}

}
