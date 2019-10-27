package com.teamtrouble.web.choresapplication.web.service;

import java.util.Calendar;

import org.junit.Test;

public class ChoreServiceTest {

	
	@Test
	public void testCalendarDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2019, 9, 28);
		System.out.println("Print time: " + cal.getTime());
	}
}
