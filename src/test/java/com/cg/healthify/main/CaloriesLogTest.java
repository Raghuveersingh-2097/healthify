package com.cg.healthify.main;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.healthify.daos.CaloriesLogDAO;
import com.cg.healthify.daos.CaloriesLogDAOImpl;
import com.cg.healthify.exceptions.CaloriesLogNotFoundException;
import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.pojo.CaloriesLog;
import com.cg.healthify.services.CaloriesLogService;
import com.cg.healthify.services.CaloriesLogServiceImpl;

public class CaloriesLogTest {

	private static CaloriesLogService service;
	private static CaloriesLogDAO dao;
	private CaloriesLog caloriesMock1,caloriesMock2;

	@BeforeClass
	public static void setUpTestEnv() {
		dao = new CaloriesLogDAOImpl();
		service = new CaloriesLogServiceImpl();
		
	}

	@Before
	public void setUpTestMockData() {
		caloriesMock1 = new CaloriesLog(21,180, LocalDate.now(),LocalDate.now(),LocalTime.now(),LocalTime.now());
		caloriesMock2 = new CaloriesLog(-38,220, LocalDate.now(),LocalDate.now(),LocalTime.now(),LocalTime.now());	
		caloriesMock1 = dao.save(caloriesMock1);
		
	}

	@Test(expected = NegativeIdEntryException.class)
	public void testGetCaloriesLogDetailsForNegativeId() throws NegativeIdEntryException, CaloriesLogNotFoundException{
		service.getCaloriesById(-25);
	}
	
	@Test
	public void testGetCaloriesLogDetailsForValidId()  throws NegativeIdEntryException, CaloriesLogNotFoundException {
		CaloriesLog log=service.getCaloriesById(caloriesMock1.getId());
		assertEquals(log,caloriesMock1);
	}

	@Test(expected = NegativeIdEntryException.class)
	public void testUpdateCaloriesLogDetailsForNegativeId() throws NegativeIdEntryException, CaloriesLogNotFoundException{
		service.updateCaloriesLog(caloriesMock2);
	}
	
	@After
	public void tearDownTestMockData() {
		dao.delete(caloriesMock1);
		dao.delete(caloriesMock2);

	}

	@AfterClass
	public static void tearDownTestEnv() {
		service = null;
		dao = null;
	}
	
}

