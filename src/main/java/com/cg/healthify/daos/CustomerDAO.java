package com.cg.healthify.daos;

import java.util.List;

import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.pojo.*;


public interface CustomerDAO {
public Customer saveCustomerDetail(Customer cust);

public Customer updateCustomerDetails(Customer cust) throws NoRecordFoundException;

public Customer cancelPlan(int id)throws NoRecordFoundException;

public Customer findByUser(int i)throws NoRecordFoundException;

public List<Customer> findAll();
}
