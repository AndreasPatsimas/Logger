package com.javacodegeeks.corejava.util.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SequencedLogFile {

	public static final int FILE_SIZE = 1024;

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(SequencedLogFile.class.getName());

		try {

			// Create an instance of FileHandler with 5 logging files sequences.

			FileHandler handler = new FileHandler("aris.log", FILE_SIZE, 5, true);

			handler.setFormatter(new SimpleFormatter());
			
			logger.addHandler(handler);

			logger.setUseParentHandlers(false);

		} catch (IOException e) {

			logger.warning("Failed to initialize logger handler.");

		}

		logger.info("Logging info message.");

		logger.warning("Logging warn message.");
		
		logger.fine("Logging success.");
	}
}
