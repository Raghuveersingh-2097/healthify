package com.cg.healthify.services;

import java.util.List;

import com.cg.healthify.pojo.Customer;


public interface CustomerService {
	
public Customer adduser(Customer cust);

public Customer updateuser(Customer cust);

public int deleteUser(int id);

public int findUser(int i);

public List<Customer> findAll();

}
