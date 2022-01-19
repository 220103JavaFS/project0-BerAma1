package com.revature.repos;

import com.revature.models.Withdraw;

import java.util.List;

public interface WithdrawDAO {
    List<Withdraw> findAllWithdraw();
    Withdraw findWithdrawById(int id);
    boolean addWithdraw(Withdraw withdraw);
}
