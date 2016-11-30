package com.espace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espace.entity.CustomerEntity;
import com.espace.dao.CustomerDao;

@Service( "customerService")
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	CustomerDao customerDao; 
	
	
	public String addCustomer(String customer_name, String contact_name_1, String contact_number_1,
			String contact_email_1, String contact_name_2, String contact_number_2, String contact_email_2) {
		
		String customerStatus = customerDao.addCustomer(customer_name, contact_name_1, contact_number_1, contact_email_1, contact_name_2, contact_number_2, contact_email_2);
		return customerStatus;
		
		
	}

	public String updateCustomer(Integer customer_id, String customer_name, String contact_name_1,
			String contact_number_1, String contact_email_1, String contact_name_2, String contact_number_2,
			String contact_email_2) {
		
		String customerStatus = customerDao.updateCustomer(customer_id, customer_name, contact_name_1, contact_number_1, contact_email_1, contact_name_2, contact_number_2, contact_email_2);
		return customerStatus;
		
	}

	public String deleteCustomer(Integer customer_id) {
		
		String customerStatus = customerDao.deleteCustomer(customer_id);
		return customerStatus;
	}

	public List<CustomerEntity> listCustomer() {
		
		List<CustomerEntity> customerArrayList = customerDao.listCustomer();
		
		return customerArrayList;
	}

	public List<CustomerEntity> getCustomerById(Integer customer_id) {
		
List<CustomerEntity> customerArrayList = customerDao.getCustomerById(customer_id);
		
		return customerArrayList;
		
	}

}
