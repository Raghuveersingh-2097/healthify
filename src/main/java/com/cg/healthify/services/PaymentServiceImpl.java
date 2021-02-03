package com.cg.healthify.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.healthify.constants.PaymentConstants;
import com.cg.healthify.daos.PaymentDAOImpl;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.exceptions.PaymentAmountException;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.pojo.Payment;
import com.cg.healthify.util.DBUtil;

public class PaymentServiceImpl implements PaymentService {
	Payment payment = new Payment();
	PaymentDAOImpl pdao = new PaymentDAOImpl();
	Scanner sc = new Scanner(System.in);
	EntityManager em = DBUtil.emf.createEntityManager();

	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub

		try {
			Validate(payment.getPayment());
		} catch (PaymentAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}

		if (payment.getPlanCategory().equalsIgnoreCase("UPI")) {
			payment.setDiscount(PaymentConstants.gold);
		} else if (payment.getPlanCategory().equalsIgnoreCase("CARD")) {
			payment.setDiscount(PaymentConstants.platinum);
		} else {
			payment.setDiscount(PaymentConstants.silver);
		}
		double netPay = payment.getPayment() - ((payment.getPayment() * payment.getDiscount()) / 100);
		payment.setPayableAmount(netPay);

		 pdao.save(payment);
		 return payment;
	}

	@Override
	public int deletePayment(int id) {
		int io1 = 0;
		int input=id;

		try {
			Query query = em.createQuery("from Payment");
			List<Payment> pay = query.getResultList();
			for (Payment i : pay) {
				if (i.getId() == input) {
					io1++;
					break;
				}
			}
			Validat(id);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if(io1==1) {
		pdao.delete(id);
		}
		return io1;

	}

	@Override
	public int FindPayment(int id) throws NoRecordFoundException, NegativeIdException, PaymentAmountException {

		int io = 0;
		try {
			Query query = em.createQuery("from Payment");
			List<Payment> loginm = query.getResultList();
			for (Payment i : loginm) {
				if (i.getId() == id) {
					io++;
					break;
				}
			}
			Validat(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			pdao.FindUser(id);
		}
		if (payment.getId() < 0) {
			throw new NegativeIdException();
		}
		if (payment.getPayment() < 0) {
			throw new PaymentAmountException();
		}
		return io;
	}

	@Override
	public Payment updatePayment(Payment payment) throws NegativeIdException, PaymentAmountException {
		// TODO Auto-generated method stub
		int io1=0;
		int ini=payment.getId();
		try {
			Query query=em.createQuery("from Payment");
			List<Payment> pay = query.getResultList();
			for(Payment i:pay) {
				if(i.getId()==ini) {
					io1++;
					break;
				}
			}  
			Validate(io1);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}
		if (payment.getId() < 0) {
			throw new NegativeIdException();
		}
		if (payment.getPayment() < 0) {
			throw new PaymentAmountException();
		}

		if (payment.getPlanCategory().equalsIgnoreCase("UPI")) {
			payment.setDiscount(PaymentConstants.gold);
		} else if (payment.getPlanCategory().equalsIgnoreCase("CARD")) {
			payment.setDiscount(PaymentConstants.platinum);
		} else {
			payment.setDiscount(PaymentConstants.silver);
		}
		double netPay = payment.getPayment() - ((payment.getPayment() * payment.getDiscount()) / 100);
		payment.setPayableAmount(netPay);
		if(io1==1) {
			return pdao.update(payment);
		}
		
		return payment;
	}

	static void Validate(double d) throws PaymentAmountException {
		if (d < 0) {
			throw new PaymentAmountException("Payment Should be postive or greater than zero ");
		}

	}

	static void Validat(int i) throws NoRecordFoundException {
		if (i == 0) {
			throw new NoRecordFoundException("No record ");
		}
	}

}
