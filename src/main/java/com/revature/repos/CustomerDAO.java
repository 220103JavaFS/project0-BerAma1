package com.revature.repos;

import com.revature.models.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> findAllCustomer();
    Customer findCustomerById(int id);
    boolean updateCustomer(Customer customer);
    boolean addCustomer(Customer customer);
    boolean deleteCustomer(int id);

}
