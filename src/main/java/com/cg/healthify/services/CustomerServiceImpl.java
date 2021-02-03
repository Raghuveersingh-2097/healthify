package com.cg.healthify.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.healthify.daos.CustomerDAO;
import com.cg.healthify.daos.CustomerDAOImpl;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.menu.MainMenu;
import com.cg.healthify.pojo.Customer;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.util.DBUtil;



public class CustomerServiceImpl implements CustomerService{
	CustomerDAO custdao;
	

	public CustomerServiceImpl() {
		custdao=new CustomerDAOImpl();
	}
	Login login=new Login();

	public Customer adduser(Customer cust) {
		custdao.saveCustomerDetail(cust);
		return cust;
	}
	public Customer updateuser(Customer cust){
		EntityManager em=DBUtil.emf.createEntityManager();
		int io1=0;
		int ini=cust.getId();
		try {
			Query query=em.createQuery("from Customer");
			List<Customer> customer= query.getResultList();
			for(Customer i:customer) {
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
		if(io1==1) {
			return custdao.updateCustomerDetails(cust);
		}
		return cust;
}
	
	public int deleteUser(int id){
		EntityManager em=DBUtil.emf.createEntityManager();
		int io1=0;
		int ini=id;
		try {
			Query query=em.createQuery("from Customer");
			List<Customer> customer= query.getResultList();
			for(Customer i:customer) {
				if(i.getId()==ini) {
					io1++;
					break;
				}
			}  
			Validate(io1);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}if(io1==1) {
			custdao.cancelPlan(ini);
		}
		return io1;
	}
	@Override
	public List<Customer> findAll() {
		custdao.findAll();
		return null;
	}
	@Override
	public int findUser(int i)throws NoRecordFoundException{
		EntityManager em=DBUtil.emf.createEntityManager();
		int io1=0;
		try {
			Query query=em.createQuery("from Customer");
			List<Customer> customer= query.getResultList();
			for(Customer ii:customer) {
				if(ii.getId()==i) {
					io1++;
					break;
				}
			}  
			Validate(io1);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}if(io1==1) {
			custdao.findByUser(i);
		}
		return io1;
	}

	static void Validate(int io)throws NoRecordFoundException{
		if(io==0) {
			throw new NoRecordFoundException("No Records Found");
		}
	}
}

