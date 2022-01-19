package com.revature.services;

import com.revature.models.Customer;
import com.revature.repos.CustomerDAO;
import com.revature.repos.CustomerDAOImpl;

import java.util.List;

public class CustomerService {


    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public List<Customer> findAllCustomer(){
        return customerDAO.findAllCustomer(); }

    public Customer findCustomerById(int id){

        return customerDAO.findCustomerById(id);
    }

    public boolean updateCustomer(Customer Customer){
        return customerDAO.updateCustomer(Customer);
    }

    public boolean addCustomer(Customer Customer){
        return customerDAO.addCustomer(Customer);
    }
    public boolean deleteCustomer(int Customer){
        return customerDAO.deleteCustomer(Customer);
    }
}
