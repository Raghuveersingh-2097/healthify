package com.cg.healthify.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.cg.healthify.daos.WeightLogDAOImpl;
import com.cg.healthify.pojo.WeightLog;
import com.cg.healthify.exceptions.InvalidIdException;
//import com.cg.healthify.exceptions.InvalidWeightException;
import com.cg.healthify.services.WeightLogServiceImpl;

public class WeightLogServiceTest {

	private static WeightLogServiceImpl weightlogservice;
	private static WeightLogDAOImpl weightlogdaoimpl;
	private static WeightLog weightloginfo,weightloginfo1,weightloginfo2,weightloginfo3,weightloginfo4,weightloginfo5,weightloginfo6,weightloginfo7;

	LocalDate created_At=LocalDate.now();
	LocalTime createTime=LocalTime.now();
	LocalDate Updated_At=LocalDate.now();
	LocalTime UpdateTime=LocalTime.now();
	
	
	@BeforeClass
	public static void setUpTestEvent()
	{
		weightlogservice=new WeightLogServiceImpl();
		weightlogdaoimpl=new WeightLogDAOImpl();
		weightloginfo=new WeightLog();
	}
	
	
	
	@Before
	public void setUpTestMockData()
	{

		weightloginfo=new WeightLog(9,456,created_At,Updated_At,createTime,UpdateTime);
		weightloginfo1=new WeightLog(101,23,created_At,Updated_At,createTime,UpdateTime);
		weightloginfo2=new WeightLog(58,789,created_At,Updated_At,createTime,UpdateTime);
		weightloginfo3=new WeightLog(59,9,created_At,Updated_At,createTime,UpdateTime);
		weightloginfo4=new WeightLog(101,456,created_At,Updated_At,createTime,UpdateTime);
		weightloginfo5=new WeightLog(8901,180,created_At,Updated_At,createTime,UpdateTime);
		weightloginfo6=new WeightLog(-123,99,created_At,Updated_At,createTime,UpdateTime);
		weightloginfo7=new WeightLog(-4,10,created_At,Updated_At,createTime,UpdateTime);

		weightlogdaoimpl.addUserWeight(weightloginfo);
	}


	/*
	 * Test the add method.
	 * if id is duplicate ,then it shows an error otherwise give correct output.
	 * check that given data and stored the values are same.
	 */
	/*@Test
	public void testAddWeightLogMethodgivenWeightLogObjectAsInputgetAllValuesAsObjectAsOutput()
	{
		WeightLog weight=new WeightLog();

		WeightLog weightloginfo4=new WeightLog(101,789,created_At,Updated_At,createTime,UpdateTime);

		WeightLog weightLogTest=weightlogservice.addWeightLog(weightloginfo4);
		assertEquals(weightloginfo4,weightLogTest);
	}
	/*
	 * Test the add method.
	 * if id is duplicate,its shows an error.
	 * we check that the id is same or not.
	 */
/*
	@Test
	public void testAddWeightLogMethodgivenWeightLogObjectAsInputAndreturnGivenIdAsOutput()
	{
		weightloginfo3=new WeightLog(8921,10000,created_At,Updated_At,createTime,UpdateTime);
		WeightLog wei=weightlogservice.addWeightLog(weightloginfo3);
		int out=weightloginfo3.getId();
		assertEquals(out,weightloginfo3.getId());
	}
*/



	/*
	 * Test the update method .
	 * test the valid id.
	 * If the given id is already in database,then it changes the data and return the updated values,otherwise test case fails.
	 */
	/*@Test
	public void TestupdateMethodGivenewWeightAsValidInputandGiveUpdatedOutput() throws InvalidIdException
	{
		weightloginfo3=new WeightLog(8901,99,created_At,Updated_At,createTime,UpdateTime);

		weightloginfo3.setWeight(10);
		weightloginfo4=weightlogservice.updateWeightLog(weightloginfo3);

		assertEquals(weightloginfo3,weightloginfo4);
	}
*/



	/*
	 * Test the delete method.
	 * If the given id is available in database ,then delete that user details ,otherwise test case fails.
	 */
	/*@Test
	public void testDeleteMethodGivenIdAsInputAndreturnObjectAsOutput() throws InvalidIdException
	{

		weightloginfo4.setId(101);
		weightloginfo5=weightlogservice.deleteWeightLog(weightloginfo4);

	}*/


	/*
	 * Test update method.
	 * If the id is invalid and throw an exception.
	 */

	@Test(expected=InvalidIdException.class)
	public void testUpdateMethodGiveInvalidIdAsInputreturnExceptionAsOutput() throws InvalidIdException
	{
		weightloginfo3=new WeightLog(8,899,created_At,Updated_At,createTime,UpdateTime);
		weightlogservice.updateWeightLog(weightloginfo3);

	}
	
	
	
	/*
	 * Test the delete method.
	 * If the id is invalid and throw an exception.
	 */
	@Test(expected=InvalidIdException.class)
	public void testDeleteMethodGiveInvalidIdAsInputreturnExceptionAsOutput() throws InvalidIdException
	{
		weightloginfo3=new WeightLog(-14,8,created_At,Updated_At,createTime,UpdateTime);
		weightlogservice.deleteWeightLog(weightloginfo3);
	}

	
	
	/*
	 * Test the find method.
	 * If the id is valid and throws an exception.
	 */
	@Test(expected=InvalidIdException.class)
	public void testFindMethodGiveInvalidIdAsInputreturnExceptionAsOutput() throws InvalidIdException
	{
		weightloginfo3=new WeightLog(-123,897,created_At,Updated_At,createTime,UpdateTime);
		weightlogservice.deleteWeightLog(weightloginfo3);
	}

	
	
	@After
	public void tearDownTest()
	{
		weightlogdaoimpl.deleteUserWeight(weightloginfo);
	}
	
	
	
	@AfterClass
	public static void tearDownTestEvent()
	{
		weightlogservice=null;
		weightlogdaoimpl=null;
	}
}
