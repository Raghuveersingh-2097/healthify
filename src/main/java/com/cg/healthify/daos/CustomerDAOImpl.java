package com.cg.healthify.daos;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.pojo.Customer;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.util.DBUtil;


public class CustomerDAOImpl implements CustomerDAO{
	//EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");	
	@Override
	public Customer saveCustomerDetail(Customer in){
	 EntityManager em=DBUtil.emf.createEntityManager();	
	  Login log=new Login();	
	  em.getTransaction().begin();
      em.persist(in);
      log.setId(in.getId());
	  log.setPassword(in.getName().split(" ")[0]+in.getId());
      em.persist(log);
      System.out.println("Welcome Our New User: "+in.getName()+"\nYour LoginId is: "+log.getId()+"\nYour Password is: "+log.getPassword());
      em.getTransaction().commit();
     em.close();
      return in;
}	
	@Override
	public Customer updateCustomerDetails(Customer cust) {
		EntityManager em=DBUtil.emf.createEntityManager();
		String newContact=cust.getContact();
		String newMedical=cust.getMedicalCondition();
		String newAllergic=cust.getAllergicTo();
		em.getTransaction().begin();
		cust=em.find(Customer.class, cust.getId());
		cust.setContact(newContact);
		cust.setMedicalCondition(newMedical);
		cust.setAllergicTo(newAllergic);
		em.persist(cust);
		System.out.println("Your Details Are Updated....");
		em.getTransaction().commit();
	    em.close();
		return cust;		
	}
	@Override
	public Customer cancelPlan(int id)throws NoRecordFoundException{
		EntityManager em=DBUtil.emf.createEntityManager(); 
		Login log=new Login();
		em.getTransaction().begin();
		Customer cust=em.find(Customer.class, id);
		log=em.find(Login.class, id);
		em.remove(cust);
		em.remove(log);
		System.out.println("Your Plan is Cancelled");
		em.getTransaction().commit();
		em.close();
		return cust;
		}
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
	EntityManager em=DBUtil.emf.createEntityManager();
		Query query=em.createQuery("from Customer");
		@SuppressWarnings("unchecked")
		List<Customer> list=(List<Customer>)query.getResultList();
		for(Customer c:list) {
			System.out.println("Customer ID: "+c.getId());
			System.out.println("Name: "+c.getName());
			System.out.println("Gender: "+c.getGender());
			System.out.println("Date Of Birth: "+c.getDob());
			System.out.println("Contact Number:"+c.getContact());
			System.out.println("Medical Condition: "+c.getMedicalCondition()+"\nAllergy To: "+c.getAllergicTo());
			System.out.println("\n");
		}
		return list;
	}
	@Override
	public Customer findByUser(int i) throws NoRecordFoundException {
		// TODO Auto-generated method stub
	EntityManager em=DBUtil.emf.createEntityManager();
		Customer cust=new Customer();
		cust=em.find(Customer.class, i);
		em.getTransaction().begin();
		System.out.println("Customer ID: "+cust.getId());
		System.out.println("Name: "+cust.getName());
		System.out.println("Gender: "+cust.getGender());
		System.out.println("Date Of Birth: "+cust.getDob());
		System.out.println("Contact Number:"+cust.getContact());
		System.out.println("Medical Condition: "+cust.getMedicalCondition()+"\nAllergy To: "+cust.getAllergicTo());
		em.getTransaction().commit(); 
        em.close();

		return cust;
	}
}

