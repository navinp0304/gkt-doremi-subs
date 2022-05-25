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

		try {
			new DateService(this.start).isDate();
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("INVALID_DATE");
		}
	}

	private Boolean updateRenewals(IStream stream, IPlan plan) {
		stream.setRenewal(new DateService(this.start, plan).renewalDate());
		return true;
	}

	public Boolean addStream(String stream) {
		String[] tokens = stream.split(" ");
		Integer cost = new CostService(tokens[1], tokens[2]).getCost();
		IPlan plan = planCategory.get(tokens[2]).apply(cost);
		Function<IPlan, IStream> func = streamCategory.get(tokens[1]);
		IStream curstream = func.apply(plan);
		Boolean retval = dss.addStreamUnique(curstream, this.streams);
		Boolean ignore = retval ? updateRenewals(curstream, plan) : false;
		return retval;
	}

	public List<IStream> streams() {
		return streams;
	}

}