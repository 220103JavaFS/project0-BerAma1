package com.revature.services;

import com.revature.models.Deposit;
import com.revature.repos.DepositDAO;
import com.revature.repos.DepositDAOImpl;

import java.util.List;

public class DepositService {
    private DepositDAO depositDAO = new DepositDAOImpl();
    public List<Deposit> findAllDeposit(){
        return depositDAO.findAllDeposit(); }

    public Deposit findDepositById(int id){

        return depositDAO.findDepositById(id);
    }
    public boolean addDeposit(Deposit deposit){

        return depositDAO.addDeposit(deposit);
    }

}
