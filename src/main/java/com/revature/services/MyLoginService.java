package com.revature.services;

import com.revature.models.Login;
import com.revature.repos.LoginDAO;
import com.revature.repos.LoginDAOImpl;
import com.revature.services.MyLoginService;

import java.util.List;

public class MyLoginService {
    private LoginDAO loginDAO = new LoginDAOImpl();
    //private MyLoginService my=new MyLoginService();// added  object

    public List<Login> findAllLogin(){ return loginDAO.findAllLogin(); }
    public Login findLoginById(int id){ return loginDAO.findLoginById(id);}
    public boolean updateLogin(Login login){
        return loginDAO.updateLogin(login);
    }

    public boolean checkAll(Login login){
        return loginDAO.checkAll(login);
    }
    public boolean addLogin(Login login){return loginDAO.addLogin(login);}
    public boolean deleteLogin(int login){
        return loginDAO.deleteLogin(login);
    }
    public boolean customer(Login login)
    {
        return customer(login);
    }
    public boolean manager(Login login) {  return manager(login);}
    public boolean employee( Login login)
    {
        return employee(login);
    }
}
