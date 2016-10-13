package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.pluralsight.model.Customer;

@Repository("customerRepository")
public class HibernatecustomerRepositoryImpl implements CustomerRepository {
	
	@Value("${someProperty}")
	private String someValue = "test"; //No use to define a default value here;
	/* (non-Javadoc)
	 * @see com.pluralsight.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<>();
		Customer customer = new Customer();
		customer.setFirstname(someValue);
//		customer.setFirstname("sds");
		customer.setLastname("HH");
		
		customers.add(customer);
		return customers;
	}
}
