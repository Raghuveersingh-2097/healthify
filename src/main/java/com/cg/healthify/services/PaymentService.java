package com.cg.healthify.services;

import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.exceptions.PaymentAmountException;
import com.cg.healthify.pojo.Payment;

public interface PaymentService {

    public Payment addPayment( Payment payment);
    
    public int deletePayment(int id );
    
    public int FindPayment(int id) throws NoRecordFoundException, NegativeIdException, PaymentAmountException;
    
    public Payment updatePayment(Payment payment) throws NegativeIdException, PaymentAmountException;
}