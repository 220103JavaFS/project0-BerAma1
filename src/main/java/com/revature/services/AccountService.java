package com.revature.services;
import com.revature.models.Account;
import com.revature.repos.AccountDAO;
import com.revature.repos.AccountDAOImpl;

import java.util.List;

public class AccountService {


    private AccountDAO accountDAO = new AccountDAOImpl();

    public List<Account> findAllAccount(){
        return accountDAO.findAllAccount(); }

    public Account findAccountById(int id){

        return accountDAO.findAccountById(id);
    }

    public boolean updateAccount(Account account){
        return accountDAO.updateAccount(account);
    }

    public boolean addAccount(Account account){
        return accountDAO.addAccount(account);
    }
    public boolean deleteAccount(int account){
        return accountDAO.deleteAccount(account);
    }
}
