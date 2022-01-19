package com.revature.models;

import java.util.Objects;

public class Customer_Account {
    private Customer cust_Id;
    private  Account account_Id;

    public Customer_Account() {
    }

    public Customer_Account(Customer cust_Id, Account account_Id) {
        this.cust_Id = cust_Id;
        this.account_Id = account_Id;
    }

    public Customer getCust_Id() {
        return cust_Id;
    }

    public void setCust_Id(Customer cust_Id) {
        this.cust_Id = cust_Id;
    }

    public Account getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(Account account_Id) {
        this.account_Id = account_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer_Account that = (Customer_Account) o;
        return Objects.equals(cust_Id, that.cust_Id) && Objects.equals(account_Id, that.account_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cust_Id, account_Id);
    }

    @Override
    public String toString() {
        return "Customer_Account{" +
                "cust_Id=" + cust_Id +
                ", account_Id=" + account_Id +
                '}';
    }
}
