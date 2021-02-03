package com.cg.healthify.daos;


import com.cg.healthify.pojo.Payment;


public interface PaymentDAO {
 
	public Payment save(Payment payment);
		
	public Payment delete(int id);
	
    public Payment FindAllPayments(Payment payment);
    
    public int FindUser(int id);

	public Payment update(Payment payment);


}
