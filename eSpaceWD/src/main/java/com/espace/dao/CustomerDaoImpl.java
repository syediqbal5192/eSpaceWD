package com.espace.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.espace.entity.CustomerEntity;
import com.espace.persistance.HibernateUtil;

@Repository( "customerDao")
public class CustomerDaoImpl implements CustomerDao {

	public String addCustomer(String customer_name, String contact_name_1, String contact_number_1,
			String contact_email_1, String contact_name_2, String contact_number_2, String contact_email_2) {
		
		String isActive="Yes";
		String isDeleted="No";		

		 Session session = HibernateUtil.getSesssion();
		 
		 Transaction transaction = null;
		 try{
			 
			 transaction= session.beginTransaction();
		     
			    CustomerEntity customer = new CustomerEntity(customer_name, contact_name_1, contact_number_1, contact_email_1, contact_name_2, contact_number_2, contact_email_2,isActive,isDeleted);
			    
		    session.save(customer); 
		    session.getTransaction().commit();
			
		    return "successful";
		 }
		 catch (HibernateException e) {
		    if (transaction!=null) 
		    	transaction.rollback();
		    e.printStackTrace(); 
		 }
		 
		 return "failed";
		
		
		
	}

	public String updateCustomer(Integer customer_id, String customer_name, String contact_name_1,
			String contact_number_1, String contact_email_1, String contact_name_2, String contact_number_2,
			String contact_email_2) {
		

		Session session = HibernateUtil.getSesssion();
	    Transaction transaction = null;
	      try{
	         transaction = session.beginTransaction();
	     
	           
	         CustomerEntity customer = (CustomerEntity) session.get(CustomerEntity.class, customer_id);  
	         
	         customer.setCustomer_name(customer_name);
	         customer.setContact_email_1(contact_email_1);
	         customer.setContact_email_2(contact_email_2);
	         customer.setContact_name_1(contact_name_1);
	         customer.setContact_name_2(contact_name_2);
	         customer.setContact_number_1(contact_number_1);
	         customer.setContact_number_2(contact_number_2);
	         
	         session.update(customer); 
	         transaction.commit();
	         
	         return "successful"; 
	      }catch (HibernateException e) {
	         if (transaction!=null) transaction.rollback();
	         e.printStackTrace(); 
	      }
	      return "failed";
	}

	public String deleteCustomer(Integer customer_id) {
		String isActive="No";
		String isDeleted="Yes";	

		Session session = HibernateUtil.getSesssion();
		   Transaction transaction = null;
	      try{
	         transaction = session.beginTransaction();
	         CustomerEntity customer = (CustomerEntity) session.get(CustomerEntity.class, customer_id);  
	         
	         customer.setIsActive(isActive);
	         customer.setIsDeleted(isDeleted);
	      
	        
			 session.update(customer); 
	         transaction.commit();
	         return "successful"; 
	      }catch (HibernateException e) {
	         if (transaction!=null) transaction.rollback();
	         
	         e.printStackTrace(); 
	      }
		
	      return "failed";
	}

	public List<CustomerEntity> listCustomer() {
		
		Session session = HibernateUtil.getSesssion();
		Transaction transaction = null; 
		List<CustomerEntity> customerList =null;
		 try
		 {
			 transaction= session.beginTransaction();
		 Criteria criteria = session.createCriteria(CustomerEntity.class, "customer");
		 criteria.add(Restrictions.eq("customer.isActive", "Yes"));
	        criteria.add(Restrictions.eq("customer.isDeleted", "No"));    
		 
	        customerList = new ArrayList<CustomerEntity>();
	        customerList = (List<CustomerEntity>) criteria.list();
	        
	        session.getTransaction().commit();
		 }
		 catch (HibernateException e) {
			 if (transaction!=null) 
			    	transaction.rollback();
			    e.printStackTrace(); 
			 }
			 
		 return customerList;
	}

	public List<CustomerEntity> getCustomerById(Integer customer_id) {
		Session session = HibernateUtil.getSesssion();
		Transaction transaction = null;
		List<CustomerEntity> customerList = null;
	      try{
	         session.beginTransaction();
		 Criteria criteria = session.createCriteria(CustomerEntity.class, "customer");
		 criteria.add(Restrictions.eq("customer.customer_id", customer_id));
	        
		 customerList = new ArrayList<CustomerEntity>();
		 customerList = (List<CustomerEntity>) criteria.list();
	        
	        session.getTransaction().commit();
	    
	      }
			 catch (HibernateException e) {
				 //if (transaction!=null) 
				    	//transaction.rollback();
				    e.printStackTrace(); 
				 }
			  return customerList;
	}

}
