package com.example.geektrust;

public class PremiumPlan implements IPlan {
	private final Integer cost;
	private final Integer duration = 3;

	PremiumPlan(Integer cost) {
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
