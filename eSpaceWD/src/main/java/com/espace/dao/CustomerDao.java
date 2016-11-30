package com.espace.dao;

import java.util.Date;
import java.util.List;

import com.espace.entity.CustomerEntity;

public interface CustomerDao {

	
	  public String addCustomer(String customer_name,String contact_name_1,String contact_number_1,String contact_email_1,String contact_name_2,String contact_number_2,String contact_email_2);
		
			public String updateCustomer(Integer customer_id,String customer_name,String contact_name_1,String contact_number_1,String contact_email_1,String contact_name_2,String contact_number_2,String contact_email_2);

			public String deleteCustomer(Integer customer_id);
			
			public List<CustomerEntity> listCustomer();
			
			public List<CustomerEntity> getCustomerById(Integer customer_id);
	
}


