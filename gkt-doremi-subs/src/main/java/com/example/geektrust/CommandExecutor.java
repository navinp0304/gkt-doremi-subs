package com.example.geektrust;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class CommandExecutor {
	Subscription subscription;
	ITopup topup;

	private final static String dupSubscription = "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n";
	private final static String dupTopup = "ADD_TOPUP_FAILED DUPLICATE_TOPUP\n";;
	private final Set<Integer> topups = new HashSet<Integer>();
	PrintMessage printer = new PrintMessage();

	private Boolean addTopup(ITopup topup) {
		topups.add(topup.devices());
		this.topup = topup;
		return true;
	}

	private final Map<String, Function<String, ITopup>> topupCategory = Map.of("FOUR_DEVICE", (str) -> {
		return new TopupFourDevice(str);
	}, "TEN_DEVICE", (str) -> {
		return new TopupTenDevice(str);
	});

	private final Map<String, Function<String, Boolean>> commandDispatch = Map.of("START_SUBSCRIPTION", (date) -> {
		try {
			this.subscription = new Subscription(date);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}, "ADD_SUBSCRIPTION", (stream) -> {
		Boolean unique = this.subscription.addStream(stream);
		Boolean ignore = (!unique) ? printer.printMessage(dupSubscription) : true;
		return ignore;
	}, "ADD_TOPUP", (topupstr) -> {
		String[] tokens = topupstr.split(" ");
		ITopup tmpTopup = topupCategory.get(tokens[1]).apply(topupstr);
		Boolean retval = topups.contains(tmpTopup.devices()) ? printer.printMessage(dupTopup) : addTopup(tmpTopup);
		return retval;
	}, "PRINT_RENEWAL_DETAILS", (noStr) -> {
		PrintRenewalDetails prDetails = new PrintRenewalDetails(this.subscription, this.topup);
		prDetails.print();
		return true;
	});

	public Function<String, Boolean> run(String command) {
		return commandDispatch.get(command);
	}

	public Subscription getSubscripton() {
		return this.subscription;
	}
}
