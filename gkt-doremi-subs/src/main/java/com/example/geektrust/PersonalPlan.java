package com.example.geektrust;

public class PersonalPlan implements IPlan {
	private final Integer cost;
	private static final Integer duration = 1;

	PersonalPlan(Integer cost) {
		this.cost = cost;
	}

	@Override
	public Integer cost() {
		return this.cost;
	}

	@Override
	public Integer duration() {
		return this.duration;
	}

}
