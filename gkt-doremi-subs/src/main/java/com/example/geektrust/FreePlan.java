package com.example.geektrust;

public class FreePlan implements IPlan{
	final Integer cost = 0;
	final Integer duration = 1;
	final Integer offset = 0;
	@Override
	public Integer cost() {
		return cost;
	}

	@Override
	public Integer duration() {
		return duration;
	}

	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
