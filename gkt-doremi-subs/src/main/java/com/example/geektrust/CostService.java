package com.example.geektrust;

import java.util.Map;

public class CostService {
	private final Map<String, Integer> streams = Map.of("MUSIC", 0, "VIDEO", 1, "PODCAST", 2);
	private final Map<String, Integer> plans = Map.of("FREE", 0, "PERSONAL", 1, "PREMIUM", 2);
	private final String stream;
	private final String plan;

	CostService(String stream, String plan) {
		this.stream = stream;
		this.plan = plan;
	}

	private final Integer[][] costMatrix = { { 0, 100, 250 }, { 0, 200, 500 }, { 0, 100, 300 } };

	public Integer getCost() {
		Integer streamIdx = this.streams.get(stream);
		Integer planIdx = this.plans.get(plan);
		return costMatrix[streamIdx][planIdx];
	}
}
