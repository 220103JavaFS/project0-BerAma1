package com.revature.models;

import java.util.Objects;

public class Withdraw {
    private int withdraw_Id;
    private int withdrawer_Id;
    private int withdrawer_Account;
    private double withdraw_Amount;
    private String withdraw_date;

    public Withdraw() {
    }

    public Withdraw(int withdraw_Id, int withdrawer_Id, int withdrawer_Account, double withdraw_Amount, String withdraw_date) {
        this.withdraw_Id = withdraw_Id;
        this.withdrawer_Id = withdrawer_Id;
        this.withdrawer_Account = withdrawer_Account;
        this.withdraw_Amount = withdraw_Amount;
        this.withdraw_date = withdraw_date;
    }

    public int getWithdraw_Id() {
        return withdraw_Id;
    }

    public void setWithdraw_Id(int withdraw_Id) {
        this.withdraw_Id = withdraw_Id;
    }

    public int getWithdrawer_Id() {
        return withdrawer_Id;
    }

    public void setWithdrawer_Id(int withdrawer_Id) {
        this.withdrawer_Id = withdrawer_Id;
    }

    public int getWithdrawer_Account() {
        return withdrawer_Account;
    }

    public void setWithdrawer_Account(int withdrawer_Account) {
        this.withdrawer_Account = withdrawer_Account;
    }

    public double getWithdraw_Amount() {
        return withdraw_Amount;
    }

    public void setWithdraw_Amount(double withdraw_Amount) {
        this.withdraw_Amount = withdraw_Amount;
    }

    public String getWithdraw_date() {
        return withdraw_date;
    }

    public void setWithdraw_date(String withdraw_date) {
        this.withdraw_date = withdraw_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Withdraw withdraw = (Withdraw) o;
        return withdraw_Id == withdraw.withdraw_Id && withdrawer_Id == withdraw.withdrawer_Id && withdrawer_Account == withdraw.withdrawer_Account && Double.compare(withdraw.withdraw_Amount, withdraw_Amount) == 0 && Objects.equals(withdraw_date, withdraw.withdraw_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(withdraw_Id, withdrawer_Id, withdrawer_Account, withdraw_Amount, withdraw_date);
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "withdraw_Id=" + withdraw_Id +
                ", withdrawer_Id=" + withdrawer_Id +
                ", withdrawer_Account=" + withdrawer_Account +
                ", withdraw_Amount=" + withdraw_Amount +
                ", withdraw_date='" + withdraw_date + '\'' +
                '}';
    }
}
