package com.revature.models;

import java.util.Objects;

public class Account {
    private int account_Id;
    private String acct_Type;
    private double act_Balance;
    private String act_Status;
    private String open_Date;
    private  double interest_Rate;

    public Account() {
    }

    public Account(int account_Id, String acct_Type, double act_Balance, String act_Status, String open_Date, double interest_Rate) {
        this.account_Id = account_Id;
        this.acct_Type = acct_Type;
        this.act_Balance = act_Balance;
        this.act_Status = act_Status;
        this.open_Date = open_Date;
        this.interest_Rate = interest_Rate;
    }

    public int getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(int account_Id) {
        this.account_Id = account_Id;
    }

    public String getAcct_Type() {
        return acct_Type;
    }

    public void setAcct_Type(String acct_Type) {
        this.acct_Type = acct_Type;
    }

    public double getAct_Balance() {
        return act_Balance;
    }

    public void setAct_Balance(double act_Balance) {
        this.act_Balance = act_Balance;
    }

    public String getAct_Status() {
        return act_Status;
    }

    public void setAct_Status(String act_Status) {
        this.act_Status = act_Status;
    }

    public String getOpen_Date() {
        return open_Date;
    }

    public void setOpen_Date(String open_Date) {
        this.open_Date = open_Date;
    }

    public double getInterest_Rate() {
        return interest_Rate;
    }

    public void setInterest_Rate(double interest_Rate) {
        this.interest_Rate = interest_Rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return account_Id == account.account_Id && Double.compare(account.act_Balance, act_Balance) == 0 && Double.compare(account.interest_Rate, interest_Rate) == 0 && Objects.equals(acct_Type, account.acct_Type) && Objects.equals(act_Status, account.act_Status) && Objects.equals(open_Date, account.open_Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_Id, acct_Type, act_Balance, act_Status, open_Date, interest_Rate);
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_Id=" + account_Id +
                ", acct_Type='" + acct_Type + '\'' +
                ", act_Balance=" + act_Balance +
                ", act_Status='" + act_Status + '\'' +
                ", open_Date='" + open_Date + '\'' +
                ", interest_Rate=" + interest_Rate +
                '}';
    }
}
