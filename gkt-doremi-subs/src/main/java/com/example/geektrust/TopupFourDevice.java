package com.example.geektrust;

public class TopupFourDevice implements ITopup {
	final Integer devices=4;
	final Integer cost = 50;
	Integer duration = 1;
	
	TopupFourDevice(String duration){
		String[] tokens=duration.split(" ");
		this.duration = Integer.parseInt(tokens[2]);
	}
	
	@Override
	public Integer devices() {
		return this.devices;
	}

	@Override
	public Integer cost() {
		return this.cost*duration;
	}


}
