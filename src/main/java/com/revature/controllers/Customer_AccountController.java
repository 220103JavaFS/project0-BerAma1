package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.models.Customer_Account;
import com.revature.services.CustomerService;
import com.revature.services.Customer_AccountService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class Customer_AccountController implements Controller{

    private Customer_AccountService  customer_accountService = new Customer_AccountService();


    Handler getCustomer_Accounts = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
        //sent a cookie along with the request that matches an open session.
        ctx.json(customer_accountService.findAllCustomer_Account());
        ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getGetCustomer_Account = (ctx) -> {
         if(ctx.req.getSession(false)!=null){
        String cust_Id = ctx.pathParam("cust_Id");
        int id = Integer.parseInt(cust_Id);
        Customer_Account customer_account = customer_accountService.findCustomer_AccountById(id);
        ctx.json(customer_account);
        ctx.status(200);
       }else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/customeraccount", getCustomer_Accounts);
        app.get("/customeraccount/{cust_Id}", getGetCustomer_Account);
    }
}
