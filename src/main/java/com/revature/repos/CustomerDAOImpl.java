package com.revature.repos;

import com.revature.models.Account;
import com.revature.models.Address;
import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {


    private AddressDAO addressDAO = new AddressDAOImpl();
    @Override
    public List<Customer> findAllCustomer() {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM customer LEFT JOIN address ON customer.address_Id = address.address_Id;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Customer> list=new ArrayList<>();

            while(result.next()){
             Customer customer= new Customer();
                customer.setCust_Id(result.getInt("cust_Id"));
                customer.setFname(result.getString("firsname"));
                customer.setLname(result.getString("lastname"));
                customer.setPhonenumber(result.getString("phonenumber"));
                customer.setEmail(result.getString("email"));
                customer.setUsername(result.getString("username"));
                customer.setPassword(result.getString("password"));
                customer.setUser_role(result.getString("user_role"));
                /*
                String address_Id = result.getString("address_Id");
                int idd = Integer.parseInt(address_Id);

                if(idd!=0){
                    Address address = addressDAO.findAddressById(idd);
                    customer.setAddress_Id(address);
                } */
                list.add(customer);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Customer findCustomerById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM customer where cust_id="+id+" ;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Customer customer = new Customer();

            while(result.next()){

                customer.setCust_Id(result.getInt("cust_Id"));
               customer.setFname(result.getString("firsname"));
               customer.setLname(result.getString("lastname"));
                customer.setPhonenumber(result.getString("phonenumber"));
                customer.setEmail(result.getString("email"));
                customer.setUsername(result.getString("username"));
                customer.setPassword(result.getString("password"));
                customer.setUser_role(result.getString("user_role"));
                String address_Id = result.getString("address_Id");

                int idd = Integer.parseInt(address_Id);

                if(idd!=0){
                    Address address = addressDAO.findAddressById(idd);
                    customer.setAddress_Id(address);
                }
            }
            return customer;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Customer();
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try(Connection conn = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE customer SET cust_id = ?, firsname = ?, lastname = ?, phonenumber = ?, email = ?, " +
                    " username=?, password=?, user_role=? WHERE cust_id = ?; ";
            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, customer.getCust_Id());
            statement.setString(++count, customer.getFname());
            statement.setString(++count, customer.getLname());
            statement.setString(++count,customer.getPhonenumber());
            statement.setString(++count,customer.getEmail());
            statement.setString(++count, customer.getUsername());
            statement.setString(++count, customer.getPassword());
            statement.setString(++count, customer.getUser_role());

            //statement.setInt(++count, customer.getAddress_Id());

            statement.setInt(++count, customer.getCust_Id());

            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addCustomer(Customer customer) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO  customer  (cust_Id, firsname, lastname, phonenumber,email, username, password, user_role, address_Id) VALUES (?,?,?,?,?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, customer.getCust_Id());
           statement.setString(++count, customer.getFname());
           statement.setString(++count, customer.getLname());
            statement.setString(++count, customer.getPhonenumber());
            statement.setString(++count, customer.getEmail());
            statement.setString(++count, customer.getUsername());
            statement.setString(++count, customer.getPassword());
            statement.setString(++count, customer.getUser_role());
            statement.setInt(++count, customer.getAddress_Id().getAddress_Id());
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "delete FROM  customer WHERE cust_Id = "+id+" ;";
            PreparedStatement statement = conn.prepareStatement(sql);
            Customer customer = new Customer();


            //--int count=0;
            //statement.setInt(++count, account.getAccount_Id());
            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
