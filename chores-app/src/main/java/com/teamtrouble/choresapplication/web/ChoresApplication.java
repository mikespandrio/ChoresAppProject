package com.teamtrouble.choresapplication.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChoresApplication {

	private static final Logger LOGGER = LogManager.getLogger(ChoresApplication.class); 
	
	public static void main(String[] args) {
		LOGGER.debug("Initializing Spring Application");
		SpringApplication.run(ChoresApplication.class, args);
	}

}
