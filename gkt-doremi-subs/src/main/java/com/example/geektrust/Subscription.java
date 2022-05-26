package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Subscription {
	private final AddStreamUnique dss = new AddStreamUnique();

	private final Map<String, Function<Integer, IPlan>> planCategory = Map.of("FREE", (cst) -> {
		return new FreePlan(cst);
	}, "PERSONAL", (cst) -> {
		return new PersonalPlan(cst);
	}, "PREMIUM", (cst) -> {
		return new PremiumPlan(cst);
	});

	private final Map<String, Function<IPlan, IStream>> streamCategory = Map.of("MUSIC", (plan) -> {
		return new MusicStream(plan);
	}, "VIDEO", (plan) -> {
		return new VideoStream(plan);
	}, "PODCAST", (plan) -> {
		return new PodCastStream(plan);
	});

	private final String start;
	private final List<IStream> streams = new ArrayList<IStream>();

	Subscription(String start) {
		String[] tokens = start.split(" ");
		this.start = tokens[1];
		// validates start date
		new DateService(this.start, new FreePlan(0));
	}

	private IPlan getPlan(String planStr, Integer cost) {
		return planCategory.get(planStr).apply(cost);
	}

	private IStream getStream(String streamStr, IPlan plan) {
		return streamCategory.get(streamStr).apply(plan);
	}

	public Boolean addStream(String streamStr, String planStr, Integer cost) {
		IPlan plan = getPlan(planStr, cost);
		IStream curstream = getStream(streamStr, plan);
		Boolean retval = dss.addStreamUnique(curstream, this.streams);
		curstream.setRenewal(new DateService(this.start, plan).renewalDate());
		return retval;
	}

	public List<IStream> streams() {
		return streams;
	}
}