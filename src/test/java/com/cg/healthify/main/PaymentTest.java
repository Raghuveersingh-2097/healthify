package com.cg.healthify.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.healthify.daos.PaymentDAO;
import com.cg.healthify.daos.PaymentDAOImpl;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.exceptions.PaymentAmountException;
import com.cg.healthify.pojo.Payment;
import com.cg.healthify.services.PaymentService;
import com.cg.healthify.services.PaymentServiceImpl;

public class PaymentTest {

	private static PaymentService service;
	private static PaymentDAO dao;
	private Payment paymentMock1, paymentMock2,paymentMock3;

	@BeforeClass
	public static void setup() {
		dao = new PaymentDAOImpl();
		service = new PaymentServiceImpl();

	}

	@Before
	public void setUpMockData() {
		paymentMock1 = new Payment(101, 10000, 10, "02.01.21", "Card", 9200);
		paymentMock2 = new Payment(-10, -50000, 5, "02.01.21", "UPI", 9200);
		paymentMock3 = new Payment(1, 80000, 8, "05.01.21", "CARD", 10000);

		//paymentMock1 = dao.save(paymentMock1);
		//paymentMock2 = dao.save(paymentMock2);

	}

	/*
	 * @Test public void showPaymentDetailsInvalid() { service.FindPayment(24); }
	 */
	@Test
	public void testaddPaymentDetails() {
		Payment pay= service.addPayment(paymentMock3);
		assertEquals(pay,paymentMock3);
	}

	@Test
	public void testupdatePaymentDetailsIsValid() throws NegativeIdException, PaymentAmountException {
		Payment pay= service.updatePayment(paymentMock1);
		assertEquals(pay.toString(),paymentMock1.toString());
	}

	@Test
	public void testDeletePaymentDetailsById()
	{
		int expected = 1;
		int actual = service.deletePayment(1);
		assertEquals(expected,actual);
		
	}   
	
	@Test
	public void testDeletePaymentDetailsByIdInValid()
	{
		int expected = 0;
		int actual = service.deletePayment(1000);
		assertEquals(expected,actual);
		
	}

	@Test
	public void testGetProductDetailsForValidId()
			throws NoRecordFoundException, NegativeIdException, PaymentAmountException {
		int expected=0;
		int pay = service.FindPayment(paymentMock1.getId());
		assertEquals(expected,pay);

	}

	@Test
	public void findCustomerDetailsByUserInValid() throws NoRecordFoundException, NegativeIdException, PaymentAmountException{
		int expected=0;
		int actual=service.FindPayment(100);
		assertEquals(expected,actual);
	}
	
	@Test(expected = NegativeIdException.class)
	public void testGetProductDetailsForNegativeId()
			throws NoRecordFoundException, NegativeIdException, PaymentAmountException {
		// Payment pay = service.updatePayment(paymentMock2.getId());
		service.updatePayment(paymentMock2);

	}
/*
	/*@Test(expected = PaymentAmountException.class)
	public void testGetProductDetailsForNegativePayment()
			throws NoRecordFoundException, PaymentAmountException, NegativeIdException {
		int pay = service.FindPayment((int) paymentMock2.getPayment());
		assertEquals(pay, paymentMock1.getPayment(), 100000);
	}
*/
		

	@AfterClass
	public static void tearDownTestEnv() {
		service = null;
		dao = null;
	}
}
