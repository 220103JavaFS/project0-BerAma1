package com.revature.services;
import com.revature.models.Customer_Account;
import com.revature.repos.Customer_AccountDAO;
import com.revature.repos.Customer_AccountDAOImpl;

import java.util.List;

public class Customer_AccountService  {

    private Customer_AccountDAO customer_accountDAO = new Customer_AccountDAOImpl();

    public List<Customer_Account> findAllCustomer_Account(){
        return customer_accountDAO.findAllCustomer_Account(); }

    public Customer_Account findCustomer_AccountById(int id){

        return customer_accountDAO.findCustomer_AccountById(id);
    }

    public boolean updateCustomer_Account(Customer_Account customer_account){
        return customer_accountDAO.updateCustomer_Account( customer_account);
    }

    public boolean addCustomer_Account(Customer_Account customer_account){
        return customer_accountDAO.addCustomer_Account(customer_account);
    }
    public boolean deleteCustomer_Account(int id){
        return customer_accountDAO.deleteCustomer_Account(id);
    }

}
