package com.teamtrouble.choresapplication.web.controller;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.teamtrouble.choresapplication.web.service.ChoreService;

@Controller
@SessionAttributes("name")
public class ChoreController {

	private static final Logger LOGGER = LogManager.getLogger(ChoreController.class);
	
	@Autowired
	ChoreService choreService;
	
	@RequestMapping(value="/list-chores", method = RequestMethod.GET)
	public String showChoresList(ModelMap model) {
		LOGGER.debug("Username in ChoreController is " + (String)model.get("name"));
		
		model.put("chores", choreService.retrieveChores());
		
		return "list-chores";
	}

	@RequestMapping(value="/add-chore", method = RequestMethod.GET)
	public String showAddChorePage(ModelMap model) {
		return "chore";
	}
	
	@RequestMapping(value="/add-chore", method = RequestMethod.POST)
	public String addChore(ModelMap model, @RequestParam String description) {
		
		choreService.addChore(description, new Date(), (String)model.getAttribute("name"));
		
		return "redirect:/list-chores";
	}
	
}
