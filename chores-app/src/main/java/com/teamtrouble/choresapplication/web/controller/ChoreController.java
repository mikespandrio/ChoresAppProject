package com.teamtrouble.choresapplication.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.teamtrouble.choresapplication.web.model.Chore;
import com.teamtrouble.choresapplication.web.service.ChoreService;

@Controller
@SessionAttributes("name")
public class ChoreController {

	private static final Logger LOGGER = LogManager.getLogger(ChoreController.class);
	
	@Autowired
	ChoreService choreService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Want date as MM/dd/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	@RequestMapping(value="/list-chores", method = RequestMethod.GET)
	public String showChoresList(ModelMap model) {
		LOGGER.debug("Username in ChoreController is " + (String)model.get("name"));
		
		model.put("chores", choreService.retrieveChores());
		
		return "list-chores";
	}

	@RequestMapping(value="/add-chore", method = RequestMethod.GET)
	public String showAddChorePage(ModelMap model) {
		model.addAttribute("chore", new Chore(0, "Default Description", new Date(), false, null, (String)model.get("name"), false, null));
		
		return "chore";
	}
	
	@RequestMapping(value="/add-chore", method = RequestMethod.POST)
	public String addChore(ModelMap model, @Valid Chore chore, BindingResult result) {
		
		if (result.hasErrors()) {
			return "chore";
		}
		
		choreService.addChore(chore.getDescription(), chore.getTargetDate(), (String)model.getAttribute("name"));
		
		return "redirect:/list-chores";
	}

	@RequestMapping(value="/update-chore", method = RequestMethod.GET)
	public String showUpdateChorePage(@RequestParam int id, ModelMap model) {
		LOGGER.debug("Showing Update Chore Page for id=" + id);
		
		Chore chore = choreService.retrieveChore(id);
		model.put("chore", chore);
		
		return "chore";
	}
	
	@RequestMapping(value="/update-chore", method = RequestMethod.POST)
	public String updateChore(ModelMap model, @Valid Chore chore, BindingResult result) {
		LOGGER.debug("Updating Chore id=" + chore.getId());
		
		if (result.hasErrors()) {
			return "chore";
		}
		
		choreService.updateChore(chore);
		
		return "redirect:/list-chores";
	}
	
	@RequestMapping(value="/delete-chore", method = RequestMethod.GET)
	public String deleteChore(@RequestParam int id) {
		LOGGER.debug("Deleting Chore id=" + id);
		choreService.deleteChore(id);
		
		return "redirect:/list-chores";
	}
	
}
