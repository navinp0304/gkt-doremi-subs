package com.example.geektrust;

public class PersonalPlan implements IPlan {
	final Integer cost = 100;
	final Integer duration = 1;
	final Integer offset = 1;

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
