package com.cg.healthify.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.healthify.daos.DietDAO;
import com.cg.healthify.daos.DietDAOImpl;
import com.cg.healthify.pojo.DietPlan;
import com.cg.healthify.services.DietService;
import com.cg.healthify.services.DietServiceImpl;

public class DietPlanTest {

	private static DietService dietService;
	private static DietDAO dietDao;
	private DietPlan dietPlanInfoMock;
	private DietPlan dietPlanInfoMock1;
	private DietPlan dietPlanInfoMock2;
	private DietPlan dietPlanInfoMock3;

	@BeforeClass
	public static void setup() {
		dietDao = new DietDAOImpl();
		dietService = new DietServiceImpl();
	}

	@Before
	public void setUpMockData() {
		dietPlanInfoMock = new DietPlan(101, "new1", "Veg", 1.1, 2.1, 3.1, 4.1);
		dietPlanInfoMock = dietDao.saveDietPlan(dietPlanInfoMock);
		dietPlanInfoMock1 = new DietPlan(101, "new2", "Veg", 1.1, 2.1, 3.1, 4.1);
		dietPlanInfoMock1 = dietDao.updateDietPlan(dietPlanInfoMock1);
		dietPlanInfoMock2 = new DietPlan(101, "new1", "Veg", 1.1, 2.1, 3.1, 4.1);
		dietPlanInfoMock3 = new DietPlan(101, "new3", "Veg", 1.1, 2.1, 3.1, 4.1);
	}

	@Test
	public void testAddDietShouldReturnDietObject() {
		DietPlan actualResult = dietService.addDiet(dietPlanInfoMock);
		assertEquals(dietPlanInfoMock, actualResult);
	}

	@Test
	public void testUpdateDietShouldReturnDietObject() {
		DietPlan actualResult = dietService.updateDiet(dietPlanInfoMock1);
		assertEquals(dietPlanInfoMock1, actualResult);
	}

	@Test
	public void testFindDietIfRecordDoesNotExist() {
		DietPlan actualResult = dietService.findDietData(dietPlanInfoMock2.getId());
		assertNotEquals(dietPlanInfoMock2.getId(), actualResult.getId());
	}

	@Test
	public void testDeleteDietDetailsByValidId() {
		DietPlan actualResult = dietService.deleteDiet(dietPlanInfoMock3);
		assertEquals(dietPlanInfoMock3.getId(), actualResult.getId());
	}
	
	@After
	public void tearDownTestMockData() {
		dietDao.removeDietPlan(dietPlanInfoMock);
	}

	@AfterClass
	public static void tearDownTestEnv() {
		dietService = null;
		dietDao = null;
	}

}
