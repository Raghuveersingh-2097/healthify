package com.cg.healthify.exceptions;

public class PaymentAmountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentAmountException(String e)
	{
		super(e);
	}
	
	public PaymentAmountException()
	{
		super();
	}
}
