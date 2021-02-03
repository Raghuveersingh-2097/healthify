package com.cg.healthify.exceptions;

public class PaymentDuplicateException extends Exception{

	public PaymentDuplicateException(String e)
	{
		super(e);
	}
	
	public PaymentDuplicateException()
	{
		super();
	}
}
