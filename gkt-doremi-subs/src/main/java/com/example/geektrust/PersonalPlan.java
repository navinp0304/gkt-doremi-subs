package com.example.geektrust;

public class PersonalPlan implements IPlan {
	private Integer cost = 100;
	private final Integer duration = 1;

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
