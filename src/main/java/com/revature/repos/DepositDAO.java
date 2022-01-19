package com.revature.repos;

import com.revature.models.Deposit;
import com.revature.models.Deposit;

import java.util.List;

public interface DepositDAO {
    List<Deposit> findAllDeposit();
    Deposit findDepositById(int id);
    boolean addDeposit(Deposit deposit);
}
