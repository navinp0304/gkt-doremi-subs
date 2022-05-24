package com.example.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class ParseCommand {
	Subscription subscription;
	ITopup topup;
	Set<Integer> topups = new HashSet<Integer>();
	
	private Map<String,Function<String,ITopup> > topupCategory = Map.of(
			"FOUR_DEVICE",(str) -> { return new TopupFourDevice(str); }, 
			"TEN_DEVICE",(str) ->  { return new TopupTenDevice(str); }
			);
	
	Boolean printMessage(String message) {
		System.out.println(message);
		return true;
	}
	
	Boolean addTopup(ITopup topup) {
		topups.add(topup.devices());
		return true;
	}

	Map<String, Consumer<String>> commandDispatch = Map.of("START_SUBSCRIPTION", (date) -> {
		this.subscription = new Subscription(date);
	}, "ADD_SUBSCRIPTION", (stream) -> {		
		Boolean isduplicate = this.subscription.addStream(stream);
		Boolean ignore = (isduplicate)?printMessage("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY"):false;		
	}, "ADD_TOPUP", (topupstr) -> {
		String[] tokens=topupstr.split(" ");
		ITopup tmpTopup = topupCategory.get(tokens[1]).apply(topupstr);
		Boolean retval = topups.contains(tmpTopup.devices())?printMessage("ADD_TOPUP_FAILED DUPLICATE_TOPUP"):addTopup(tmpTopup);
	});

	public void run(String fileName) {
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Consumer<String> command;
		while (input.hasNextLine()) {
			String fullCommand = new String(input.nextLine());
			String[] commands = fullCommand.split(" ");
			command = commandDispatch.get(commands[0]);
			command.accept(fullCommand);
		}
	}
}