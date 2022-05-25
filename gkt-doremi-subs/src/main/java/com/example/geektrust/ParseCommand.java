package com.example.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class ParseCommand {
	private Subscription subscription;
	private ITopup topup;
	private Set<Integer> topups = new HashSet<Integer>();
	private String invalidDate = "INVALID_DATE\n";
	private final String inputFileName;

	private Map<String, Function<String, ITopup>> topupCategory = Map.of("FOUR_DEVICE", (str) -> {
		return new TopupFourDevice(str);
	}, "TEN_DEVICE", (str) -> {
		return new TopupTenDevice(str);
	});

	private Boolean printMessage(String message) {
		System.out.printf(message);
		return true;
	}

	private Boolean addTopup(ITopup topup) {
		topups.add(topup.devices());
		this.topup = topup;
		return true;
	}

	private Map<String, Function<String, Boolean>> commandDispatch = Map.of("START_SUBSCRIPTION", (date) -> {
		try {
			this.subscription = new Subscription(date);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}

	}, "ADD_SUBSCRIPTION", (stream) -> {

		Boolean unique = this.subscription.addStream(stream);
		String duplicateSubscriptionMessage = "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n";
		Boolean ignore = (unique) ? true : printMessage(duplicateSubscriptionMessage);
		return ignore;
	}, "ADD_TOPUP", (topupstr) -> {
		String[] tokens = topupstr.split(" ");
		ITopup tmpTopup = topupCategory.get(tokens[1]).apply(topupstr);
		String duplicateTopupMessage = "ADD_TOPUP_FAILED DUPLICATE_TOPUP\n";
		Boolean retval = topups.contains(tmpTopup.devices()) ? printMessage(duplicateTopupMessage) : addTopup(tmpTopup);
		return retval;
	}, "PRINT_RENEWAL_DETAILS", (noStr) -> {
		PrintRenewalDetails prDetails = new PrintRenewalDetails(this.subscription, this.topup);
		prDetails.print();
		return true;
	});

	private Boolean runCommand(Function<String, Boolean> command, String fullCommand) {
		command.apply(fullCommand);
		return true;
	}

	ParseCommand(String fileName) {
		this.inputFileName = fileName;
	}

	public void run() {
		Scanner input = null;
		try {
			input = new Scanner(new File(inputFileName));
		} catch (FileNotFoundException e) {
			return;
		}
		Function<String, Boolean> command;
		while (input.hasNextLine()) {
			String fullCommand = new String(input.nextLine());
			String[] commands = fullCommand.split(" ");
			command = commandDispatch.get(commands[0]);
			String message = "INVALID_DATE\n";
			message = commands[0].equals("PRINT_RENEWAL_DETAILS") ? "SUBSCRIPTIONS_NOT_FOUND\n" : invalidDate;
			String prefix = commands[0] + "_FAILED ";
			Boolean startSubscription = commands[0].equals("START_SUBSCRIPTION") ? runCommand(command, fullCommand)
					: false;
			prefix = ((this.subscription == null) && (startSubscription == true)) ? "" : prefix;
			prefix = ((this.subscription == null) && (commands[0].equals("PRINT_RENEWAL_DETAILS"))) ? "" : prefix;
			Boolean ignore = (this.subscription == null) ? printMessage(prefix + message)
					: runCommand(command, fullCommand);
		}
	}
}