package com.example.geektrust;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class TopupService {
	ITopup topup;
	private final Set<Integer> topups = new HashSet<Integer>();

	private final Map<String, Function<String, ITopup>> topupCategory = Map.of("FOUR_DEVICE", (str) -> {
		return new TopupFourDevice(str);
	}, "TEN_DEVICE", (str) -> {
		return new TopupTenDevice(str);
	});

	private Boolean addTopup(ITopup topup) {
		topups.add(topup.devices());
		this.topup = topup;
		return true;
	}

	private Boolean createDuplicateException() {
		throw new IllegalArgumentException("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
	}

	public void parseAddTopup(String fullCommand) {
		String[] tokens = fullCommand.split(" ");
		ITopup tmpTopup = topupCategory.get(tokens[1]).apply(fullCommand);
		Boolean retval = topups.contains(tmpTopup.devices()) ? createDuplicateException() : addTopup(tmpTopup);
	}

	TopupService(Subscription subscription, String fullCommand) {
		try {
			subscription.streams();
		} catch (NullPointerException ex) {
			throw new NullPointerException("ADD_TOPUP_FAILED INVALID_DATE");
		}
	}

	public ITopup getTopup() {
		return this.topup;
	}
}
