package com.example.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Function;

public class ParseCommand {
	private final static String invalidDate = "INVALID_DATE\n";
	private final static String subscriptionsNotFound = "SUBSCRIPTIONS_NOT_FOUND\n";
	private final String inputFileName;
	PrintMessage printer = new PrintMessage();

	ParseCommand(String fileName) {
		this.inputFileName = fileName;
	}

	private Boolean runCommand(Function<String, Boolean> command, String fullCommand) {
		command.apply(fullCommand);
		return true;
	}

	public void run() {
		Scanner input = null;
		try {
			input = new Scanner(new File(inputFileName));
		} catch (FileNotFoundException e) {
			return;
		}
		CommandExecutor cmdExecutor = new CommandExecutor();
		Function<String, Boolean> command;
		Subscription subscription;
		while (input.hasNextLine()) {
			String fullCommand = new String(input.nextLine());
			String[] commands = fullCommand.split(" ");
			command = cmdExecutor.run(commands[0]);
			String message = commands[0].equals("PRINT_RENEWAL_DETAILS") ? subscriptionsNotFound : invalidDate;
			String prefix = commands[0] + "_FAILED ";
			Boolean startSubscription = commands[0].equals("START_SUBSCRIPTION") ? runCommand(command, fullCommand)
					: false;
			subscription = cmdExecutor.getSubscripton();
			prefix = printer.getPrefix(prefix, startSubscription, subscription);
			prefix = printer.getPrefix(prefix, subscription, commands[0], "PRINT_RENEWAL_DETAILS");

			Boolean ignore = (subscription == null) ? printer.printMessage(prefix + message)
					: runCommand(command, fullCommand);
		}
	}
}