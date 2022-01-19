package com.revature.models;

import java.util.Objects;

public class Deposit {
    private int deposit_Id;
    private int sender_Id;
    private int sender_Account;
    private int receiver_Id;
    private int receiver_Account;
    private double deposit_Amount;
    private String deposit_date;

    public Deposit() {
    }

    public Deposit(int deposit_Id, int sender_Id, int sender_Account, int receiver_Id, int receiver_Account, double deposit_Amount, String deposit_date) {
        this.deposit_Id = deposit_Id;
        this.sender_Id = sender_Id;
        this.sender_Account = sender_Account;
        this.receiver_Id = receiver_Id;
        this.receiver_Account = receiver_Account;
        this.deposit_Amount = deposit_Amount;
        this.deposit_date = deposit_date;
    }

    public int getDeposit_Id() {
        return deposit_Id;
    }

    public void setDeposit_Id(int deposit_Id) {
        this.deposit_Id = deposit_Id;
    }

    public int getSender_Id() {
        return sender_Id;
    }

    public void setSender_Id(int sender_Id) {
        this.sender_Id = sender_Id;
    }

    public int getSender_Account() {
        return sender_Account;
    }

    public void setSender_Account(int sender_Account) {
        this.sender_Account = sender_Account;
    }

    public int getReceiver_Id() {
        return receiver_Id;
    }

    public void setReceiver_Id(int receiver_Id) {
        this.receiver_Id = receiver_Id;
    }

    public int getReceiver_Account() {
        return receiver_Account;
    }

    public void setReceiver_Account(int receiver_Account) {
        this.receiver_Account = receiver_Account;
    }

    public double getDeposit_Amount() {
        return deposit_Amount;
    }

    public void setDeposit_Amount(double deposit_Amount) {
        this.deposit_Amount = deposit_Amount;
    }

    public String getDeposit_date() {
        return deposit_date;
    }

    public void setDeposit_date(String deposit_date) {
        this.deposit_date = deposit_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return deposit_Id == deposit.deposit_Id && sender_Id == deposit.sender_Id && sender_Account == deposit.sender_Account && receiver_Id == deposit.receiver_Id && receiver_Account == deposit.receiver_Account && Double.compare(deposit.deposit_Amount, deposit_Amount) == 0 && Objects.equals(deposit_date, deposit.deposit_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deposit_Id, sender_Id, sender_Account, receiver_Id, receiver_Account, deposit_Amount, deposit_date);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "deposit_Id=" + deposit_Id +
                ", sender_Id=" + sender_Id +
                ", sender_Account=" + sender_Account +
                ", receiver_Id=" + receiver_Id +
                ", receiver_Account=" + receiver_Account +
                ", deposit_Amount=" + deposit_Amount +
                ", deposit_date='" + deposit_date + '\'' +
                '}';
    }
}
