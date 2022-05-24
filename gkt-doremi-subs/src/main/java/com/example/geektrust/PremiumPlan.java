package com.example.geektrust;

public class PremiumPlan implements IPlan{
	final Integer cost = 250;
	final Integer duration = 3;
	final Integer offset = 2;
	@Override
	public Integer cost() {
		return this.cost;
	}

	@Override
	public Integer duration() {
		return this.duration;
	}

	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
		return offset;
	}

}
