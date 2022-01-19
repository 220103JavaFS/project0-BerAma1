package com.revature.repos;

import com.revature.models.Customer;
import com.revature.models.Customer_Account;

import java.util.List;

public interface Customer_AccountDAO {


    List<Customer_Account> findAllCustomer_Account();
    Customer_Account findCustomer_AccountById(int id);
    boolean updateCustomer_Account(Customer_Account customer);
    boolean addCustomer_Account(Customer_Account customer);
    boolean deleteCustomer_Account(int id);
}
