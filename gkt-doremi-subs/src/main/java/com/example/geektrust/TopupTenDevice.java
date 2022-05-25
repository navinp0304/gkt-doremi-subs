package com.example.geektrust;

public class TopupTenDevice implements ITopup {
	private final Integer devices = 10;
	private final Integer cost = 100;
	private Integer duration = 1;

	TopupTenDevice(String duration) {
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
