package com.revature.models;

import java.util.Objects;

public class Employee {
    private int emp_Id;
    private String fname;
    private String lname;
    private String phonenumber;
    private String email;
    private String username;
    private  String password;
    private  String user_role;
    private  Address address_Id;

    public Employee() {
    }

    public Employee(int emp_Id, String fname, String lname, String phonenumber, String email, String username, String password, String user_role, Address address_Id) {
        this.emp_Id = emp_Id;
        this.fname = fname;
        this.lname = lname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.user_role = user_role;
        this.address_Id = address_Id;
    }

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public Address getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(Address address_Id) {
        this.address_Id = address_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return emp_Id == employee.emp_Id && Objects.equals(fname, employee.fname) && Objects.equals(lname, employee.lname) && Objects.equals(phonenumber, employee.phonenumber) && Objects.equals(email, employee.email) && Objects.equals(username, employee.username) && Objects.equals(password, employee.password) && Objects.equals(user_role, employee.user_role) && Objects.equals(address_Id, employee.address_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emp_Id, fname, lname, phonenumber, email, username, password, user_role, address_Id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_Id=" + emp_Id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_role='" + user_role + '\'' +
                ", address_Id=" + address_Id +
                '}';
    }
}
