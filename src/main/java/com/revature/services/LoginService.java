package com.revature.services;

public class LoginService {

    public boolean login(String username, String password, String user_Role){


        if(username.equals("agent")&&password.equals("password") && user_Role.equals("customer")){
            return true; }
        else {
            return false;
        }
    }

}
