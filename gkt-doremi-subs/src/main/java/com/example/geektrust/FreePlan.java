package com.example.geektrust;

public class FreePlan implements IPlan {
	private Integer cost = 0;
	private final Integer duration = 1;

	FreePlan(Integer cost) {
		this.cost = cost;
	}

	@Override
	public Integer cost() {
		return cost * duration;
	}

	@Override
	public Integer duration() {
		return duration;
	}

}
