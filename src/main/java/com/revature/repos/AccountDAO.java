package com.revature.repos;

import com.revature.models.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAllAccount();
    Account findAccountById(int id);
    boolean updateAccount(Account account);
    boolean addAccount(Account account);
    boolean deleteAccount(int id);
}
