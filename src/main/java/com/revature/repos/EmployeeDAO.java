package com.revature.repos;

import com.revature.models.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployee();
    Employee findEmployeeById(int id);
    boolean updateEmployee(Employee employee);
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(int id);
    
}
