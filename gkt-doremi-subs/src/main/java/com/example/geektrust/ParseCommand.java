package com.example.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Function;

public class ParseCommand {
	private final String inputFileName;

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
		CommandExecutor cmdExecutor = new CommandExecutor();

		while (input.hasNextLine()) {
			String fullCommand = new String(input.nextLine());
			String[] commands = fullCommand.split(" ");
			try {
				cmdExecutor.run(commands[0], fullCommand);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}