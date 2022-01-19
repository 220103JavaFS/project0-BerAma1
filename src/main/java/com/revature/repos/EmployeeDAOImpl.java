package com.revature.repos;

import com.revature.models.Address;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl  implements EmployeeDAO{

    private AddressDAO addressDAO = new AddressDAOImpl();
    @Override
    public List<Employee> findAllEmployee() {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM Employee LEFT JOIN address ON Employee.address_Id = address.address_Id;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Employee> list=new ArrayList<>();

            while(result.next()){
                Employee employee= new Employee();
                employee.setEmp_Id(result.getInt("emp_Id"));
                employee.setFname(result.getString("firsname"));
                employee.setLname(result.getString("lastname"));
                employee.setPhonenumber(result.getString("phonenumber"));
                employee.setEmail(result.getString("email"));
                employee.setUsername(result.getString("username"));
                employee.setPassword(result.getString("password"));
                employee.setUser_role(result.getString("user_role"));
                /*
                String address_Id = result.getString("address_Id");
                int idd = Integer.parseInt(address_Id);

                if(idd!=0){
                    Address address = addressDAO.findAddressById(idd);
                    Employee.setAddress_Id(address);
                } */
                list.add(employee);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Employee findEmployeeById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM Employee where emp_id="+id+" ;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Employee employee = new Employee();

            while(result.next()){

                employee.setEmp_Id(result.getInt("emp_Id"));
                employee.setFname(result.getString("firsname"));
                employee.setLname(result.getString("lastname"));
                employee.setPhonenumber(result.getString("phonenumber"));
                employee.setEmail(result.getString("email"));
                employee.setUsername(result.getString("username"));
                employee.setPassword(result.getString("password"));
                employee.setUser_role(result.getString("user_role"));
                String address_Id = result.getString("address_Id");

                int idd = Integer.parseInt(address_Id);

                if(idd!=0){
                    Address address = addressDAO.findAddressById(idd);
                    employee.setAddress_Id(address);
                }
            }
            return employee;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Employee();
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try(Connection conn = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE Employee SET emp_id = ?, firsname = ?, lastname = ?, phonenumber = ?, email = ?, " +
                    " username=?, password=?, user_role=? WHERE emp_id = ?; ";
            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, employee.getEmp_Id());
            statement.setString(++count, employee.getFname());
            statement.setString(++count, employee.getLname());
            statement.setString(++count,employee.getPhonenumber());
            statement.setString(++count,employee.getEmail());
            statement.setString(++count, employee.getUsername());
            statement.setString(++count, employee.getPassword());
            statement.setString(++count, employee.getUser_role());

            //statement.setInt(++count, employee.getAddress_Id());

            statement.setInt(++count, employee.getEmp_Id());

            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addEmployee(Employee employee) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO  Employee  (emp_Id, firsname, lastname, phonenumber,email, username, password, user_role, address_Id) VALUES (?,?,?,?,?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, employee.getEmp_Id());
            statement.setString(++count, employee.getFname());
            statement.setString(++count, employee.getLname());
            statement.setString(++count, employee.getPhonenumber());
            statement.setString(++count, employee.getEmail());
            statement.setString(++count, employee.getUsername());
            statement.setString(++count, employee.getPassword());
            statement.setString(++count, employee.getUser_role());
            statement.setInt(++count, employee.getAddress_Id().getAddress_Id());
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "delete FROM  Employee WHERE emp_Id = "+id+" ;";
            PreparedStatement statement = conn.prepareStatement(sql);
            Employee employee = new Employee();


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
