package com.revature.services;

import com.revature.models.Withdraw;
import com.revature.repos.WithdrawDAO;
import com.revature.repos.WithdrawDAOImpl;

import java.util.List;

public class WithdrawService {
    private WithdrawDAO withdrawDAO = new WithdrawDAOImpl();
    public List<Withdraw> findAllWithdraw(){
        return withdrawDAO.findAllWithdraw(); }

    public Withdraw findWithdrawById(int id){

        return withdrawDAO.findWithdrawById(id);
    }
    public boolean addWithdraw(Withdraw withdraw){

        return withdrawDAO.addWithdraw(withdraw);
    }

}
