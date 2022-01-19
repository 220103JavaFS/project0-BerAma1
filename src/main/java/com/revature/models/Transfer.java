package com.revature.models;

import java.util.Objects;

public class Transfer {

    private int transfer_Id;
    private int sender_Id;
    private int sender_Account;
    private int receiver_Id;
    private int receiver_Account;
    private double transfer_Amount;
    private String transfer_date;

    public Transfer() {
    }

    public Transfer(int transfer_Id, int sender_Id, int sender_Account, int receiver_Id, int receiver_Account, double transfer_Amount, String transfer_date) {
        this.transfer_Id = transfer_Id;
        this.sender_Id = sender_Id;
        this.sender_Account = sender_Account;
        this.receiver_Id = receiver_Id;
        this.receiver_Account = receiver_Account;
        this.transfer_Amount = transfer_Amount;
        this.transfer_date = transfer_date;
    }

    public int getTransfer_Id() {
        return transfer_Id;
    }

    public void setTransfer_Id(int transfer_Id) {
        this.transfer_Id = transfer_Id;
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

    public double getTransfer_Amount() {
        return transfer_Amount;
    }

    public void setTransfer_Amount(double transfer_Amount) {
        this.transfer_Amount = transfer_Amount;
    }

    public String getTransfer_date() {
        return transfer_date;
    }

    public void setTransfer_date(String transfer_date) {
        this.transfer_date = transfer_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return transfer_Id == transfer.transfer_Id && sender_Id == transfer.sender_Id && sender_Account == transfer.sender_Account && receiver_Id == transfer.receiver_Id && receiver_Account == transfer.receiver_Account && Double.compare(transfer.transfer_Amount, transfer_Amount) == 0 && Objects.equals(transfer_date, transfer.transfer_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transfer_Id, sender_Id, sender_Account, receiver_Id, receiver_Account, transfer_Amount, transfer_date);
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transfer_Id=" + transfer_Id +
                ", sender_Id=" + sender_Id +
                ", sender_Account=" + sender_Account +
                ", receiver_Id=" + receiver_Id +
                ", receiver_Account=" + receiver_Account +
                ", transfer_Amount=" + transfer_Amount +
                ", transfer_date='" + transfer_date + '\'' +
                '}';
    }
}
