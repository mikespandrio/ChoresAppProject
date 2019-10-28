package com.teamtrouble.choresapplication.web.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamtrouble.choresapplication.web.model.Chore;
import com.teamtrouble.choresapplication.web.model.Chore.Cadence;

@Service
public class ChoreService {

	private static List<Chore> chores = new ArrayList<Chore>();
	private static int choreCount = 0;
	
	// TODO: Remove this static initial population and pull data from database
	static {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1); // just a simple default, make it due tomorrow
		
		chores.add(new Chore(1, "Feed and water the chickens", cal.getTime(), true, Cadence.DAILY, "mike", false, null));
		chores.add(new Chore(2, "Feed Chloe breakfast", cal.getTime(), true, Cadence.DAILY, "mike", false, null));
		chores.add(new Chore(3, "Scoop out the chicken coop", cal.getTime(), true, Cadence.WEEKLY, "mike", false, null));
		
		choreCount = chores.size();
	}
	
	public List<Chore> retrieveChores() {
		return chores;
	}
	
	public Chore retrieveChore(int id) {
		Optional<Chore> chore = chores.stream().filter(c -> c.getId() == id).findAny();
		
		if (chore.isPresent()) {
			return chore.get();
		}
		return null;
	}
	
	public void addChore(Chore chore) {
		chores.add(chore);
	}
	
	public void addChore(String description, Date dueDate, String user) {
		this.addChore(description, dueDate, false, null, user);
	}
	
	public void addChore(String description, Date dueDate, boolean repeatAtCadence, Cadence cadence, String user) {
		chores.add(new Chore(++choreCount, description, dueDate, repeatAtCadence, cadence, user, false, null));
	}
	
	public void updateChore(Chore chore) {
		// TODO: actually implement this in a sane way.
		deleteChore(chore.getId());
		addChore(chore);
	}
	
	public void deleteChore(int id) {
		Iterator<Chore> iterator = chores.iterator();
		while (iterator.hasNext()) {
			Chore chore = iterator.next();
			if (chore.getId() == id) {
				iterator.remove();
			}
		}
	}
}
