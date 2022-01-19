package com.revature.repos;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Customer_Account;
import com.revature.utils.ConnectionUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Customer_AccountDAOImpl implements Customer_AccountDAO{
    private  AccountDAO accountDAO= new AccountDAOImpl();
    private CustomerDAO customerDAO= new CustomerDAOImpl();



    @Override
    public Customer_Account findCustomer_AccountById(int id) {


        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM customer LEFT JOIN  customer_account ON customer_account.cust_Id=customer.cust_id" +
                    " WHERE customer_account.cust_id="+id+" ;"; // not finished yet
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            Customer_Account customer_account= new Customer_Account();

            while(result.next()){

                // customer_account.setCust_Id(result.getInt("cust_Id"));
                // customer.setAccount_Id(result.getInt("account_Id"));

                // customer.setLname(result.getString("lastname"));

                String cust_Id = result.getString("cust_Id");
                String account_Id = result.getString("account_Id");
                int idd = Integer.parseInt(cust_Id);
               // int idd2=Integer.parseInt(account_Id);

               // if(id!=0)
               // {
                    Customer customer= customerDAO.findCustomerById(id);
                    customer_account.setCust_Id(customer);
               // }
              //  while(idd!=0){
                    //Address address = addressDAO.findAddressById(idd);
                    // customer.setAddress_Id(address); */
                    Account account= accountDAO.findAccountById(idd);
                    customer_account.setAccount_Id(account);
                //}


            }
            return customer_account;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Customer_Account();
    }

    @Override
    public boolean updateCustomer_Account(Customer_Account customer) {
        return false;
    }

    @Override
    public boolean addCustomer_Account(Customer_Account customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer_Account(int id) {
        return false;
    }

    @Override
    public List<Customer_Account> findAllCustomer_Account() {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM customer_account ca INNER JOIN account a ON ca.account_id =a.account_id;"; // not finished yet
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Customer_Account> list=new ArrayList<>();

            while(result.next()){
                Customer_Account customer_account= new Customer_Account();
                // customer_account.setCust_Id(result.getInt("cust_Id"));
                // customer.setAccount_Id(result.getInt("account_Id"));

                // customer.setLname(result.getString("lastname"));

                String cust_Id = result.getString("cust_Id");
                String account_Id = result.getString("account_Id");
                int idd = Integer.parseInt(cust_Id);
                int idd2=Integer.parseInt(account_Id);

               if(idd!=0){
                    //Address address = addressDAO.findAddressById(idd);
                  // customer.setAddress_Id(address); */
                Account account= accountDAO.findAccountById(idd);
                 customer_account.setAccount_Id(account);
               }
                if(idd2!=0)
                {
                Customer customer= customerDAO.findCustomerById(idd2);
                customer_account.setCust_Id(customer);
                }

                list.add(customer_account);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
