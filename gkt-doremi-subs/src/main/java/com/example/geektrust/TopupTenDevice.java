package com.example.geektrust;

public class TopupTenDevice implements ITopup{
	final Integer devices = 10;
	final Integer cost = 100;
	Integer duration = 1;
		
	TopupTenDevice(String duration){
		this.duration = Integer.parseInt(duration);
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
