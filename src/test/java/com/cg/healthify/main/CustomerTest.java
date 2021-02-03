package com.cg.healthify.main;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.healthify.daos.CustomerDAO;
import com.cg.healthify.daos.CustomerDAOImpl;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.pojo.Customer;
import com.cg.healthify.services.CustomerService;
import com.cg.healthify.services.CustomerServiceImpl;


public class CustomerTest {
	private static CustomerService service;
	private static CustomerDAO dao;
	private Customer customer1,customer2,customer3,customer4;
	
	@BeforeClass
	public static  void setUpTestEnv() {
		dao= new CustomerDAOImpl();
		service = new CustomerServiceImpl();
	}
	@Before 
	public void setUpTestMockData() {
		customer1=new Customer(12,"Dheeraj","Male","20-09-1997","7458059664","FIT","Tomato");
		customer2=new Customer(10101,"Umang Rai","Male","20-03-1997","9193458763","FIT","OLA");
		customer3=new Customer("Dheeraj","Male","20-09-1997","745789034","FIT","NONe");
		customer4=new Customer("Raghav Singh","Male","20-07-1997","7458059664","FIT","Zomato");
	}

	@Test
	public void getCustomerDetails(){
		Customer cust=service.adduser(customer3);
		assertEquals(cust,customer3);
	}
	@Test
	public void getValidupdateCustomerDetails(){
		Customer cust=service.updateuser(customer1);
		assertEquals(cust.toString(),customer1.toString());
	}
	@Test
	public void getInvalidCustomerDetails()throws NoRecordFoundException{
		Customer m=service.updateuser(customer2);
		assertEquals(m,customer2);
	}
	@Test
	public void deleteCustomerDetailsByIdInvalid(){
		int expected=0;
		int actual=service.deleteUser(1111);
		assertEquals(expected,actual);
	}
	@Test
	public void deleteCustomerDetailsByIdValid(){
		int expected=0;
		int actual=service.deleteUser(12);
		assertEquals(expected,actual);
	}
	@Test
	public void getCustomerDetailsByIdInValid(){
		int expected=0;
		int actual=service.findUser(12);
		assertEquals(expected,actual);
	}
	@Test
	public void getCustomerDetailsByIdValid(){
		int expected=1;
		int actual=service.findUser(1);
		assertEquals(expected,actual);
	}
	/*@Test
	public void getCustomerDetailsByUserInValidDAO(){
		Customer expected=new Customer("Dheeraj","Male","20-09-1997","745789034","FIT","NONe");
		Customer actual=dao.findByUser(3);
		assertEquals(expected.toString(),actual.toString());
	}*/

	@AfterClass
	public static  void tearDownTestEnv() {
		service = null;
		dao= null;
	}
}

