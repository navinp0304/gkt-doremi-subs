package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Subscription {
	AddStreamUnique dss = new AddStreamUnique();
	
	public final Map<String, IPlan> planCategory = Map.of(
			"FREE", new FreePlan(), 
			"PERSONAL", new PersonalPlan(),
			"PREMIUM", new PremiumPlan()
			);

	public final Map<String, Function<IPlan, IStream>> streamCategory = Map.of(
			"MUSIC", (plan) -> {
		return new MusicStream(plan);
	}, 
			"VIDEO", (plan) -> {
		return new VideoStream(plan);
	}, 
			"PODCAST", (plan) -> {
		return new PodCastStream(plan);
	});

	String start;
	List<IStream> streams = new ArrayList<IStream>();

	Subscription(String start) {
		this.start = start;
	}

	Boolean addStream(String addStream) {
		String[] tokens = addStream.split(" ");
		IPlan plan = planCategory.get(tokens[2]);
		//Function<IPlan, IStream> func = streamCategory.get(tokens[1]);
		Function<IPlan, IStream> func = streamCategory.get(tokens[1]);
		IStream stream = func.apply(plan);
		return dss.addStreamUnique(stream,this.streams);
	}
	

	public List<String> renewalDate() {
		// TODO Auto-generated method stub
		return null;
	}
}