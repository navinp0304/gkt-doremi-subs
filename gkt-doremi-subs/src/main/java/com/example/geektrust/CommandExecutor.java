package com.example.geektrust;

import java.util.Map;
import java.util.function.Function;

public class CommandExecutor {
	Subscription subscription;
	ITopup topup;
	TopupService topupService;

	private final Map<String, Function<String, Boolean>> commandDispatch = Map.of("START_SUBSCRIPTION", (date) -> {
		this.subscription = new Subscription(date);
		return true;
	}, "ADD_SUBSCRIPTION", (stream) -> {
		try {
			String[] tokens = stream.split(" ");
			Integer cost = new CostService(tokens[1], tokens[2]).getCost();
			Boolean unique = this.subscription.addStream(tokens[1], tokens[2], cost);
			return true;
		} catch (NullPointerException ex) {
			throw new NullPointerException("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
		}
	}, "ADD_TOPUP", (topupStr) -> {
		this.topupService = (this.topupService == null) ? new TopupService(subscription, topupStr) : this.topupService;
		this.topupService.parseAddTopup(topupStr);
		this.topup = this.topupService.getTopup();
		return true;
	}, "PRINT_RENEWAL_DETAILS", (noStr) -> {
		try {
			new PrintRenewalDetails(this.subscription, this.topup).print();
			return true;
		} catch (NullPointerException ex) {
			throw new NullPointerException("SUBSCRIPTIONS_NOT_FOUND");
		}
	});

	public Boolean run(String command, String fullCommand) {
		return commandDispatch.get(command).apply(fullCommand);
	}

}
