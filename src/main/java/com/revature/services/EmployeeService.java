package com.revature.services;

import com.revature.models.Employee;
import com.revature.repos.EmployeeDAO;
import com.revature.repos.EmployeeDAOImpl;

import java.util.List;

public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public List<Employee> findAllEmployee(){
        return employeeDAO.findAllEmployee(); }

    public Employee findEmployeeById(int id){

        return employeeDAO.findEmployeeById(id);
    }

    public boolean updateEmployee(Employee employee){
        return employeeDAO.updateEmployee(employee);
    }

    public boolean addEmployee(Employee employee){
        return employeeDAO.addEmployee(employee);
    }
    public boolean deleteEmployee(int employee){
        return employeeDAO.deleteEmployee(employee);
    }
}
