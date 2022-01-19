package com.revature.controllers;
import com.revature.models.Account;
import com.revature.models.Home;
import com.revature.services.AccountService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AccountController implements  Controller{

    private AccountService accountService = new AccountService();


    Handler getAccounts = (ctx) ->{
         if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
             //sent a cookie along with the request that matches an open session.
             ctx.json(accountService.findAllAccount());
             ctx.status(200);
         }
      else {
            ctx.status(401);
             ctx.result("login first!");
        }
    };

    Handler getAccount = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
        String account_Id = ctx.pathParam("account_Id");
        int id = Integer.parseInt(account_Id);
        Account account = accountService.findAccountById(id);
        ctx.json(account);
        ctx.status(200);
       }else {
            ctx.status(401);
        }
    };


    Handler deleteAccount = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
        String account_Id = ctx.pathParam("account_Id");
        int id = Integer.parseInt(account_Id);
        boolean account = accountService.deleteAccount(id);
        if(account==true){
            ctx.json(account);
            ctx.result("file is deleted");
            ctx.status(200);
        } else { ctx.result("file not found");}}

        else {
            ctx.status(401);
        }
    };
    Handler updateAccount = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
        Account account = ctx.bodyAsClass(Account.class);
        if(accountService.updateAccount(account)){
            ctx.status(202);
        }else {
            ctx.status(400);
        }
         }else {
            ctx.status(401);

        }
    };

    Handler newAccount = (ctx)->{
         if(ctx.req.getSession(false)!=null){
        Account account = ctx.bodyAsClass(Account.class);
        if(accountService.addAccount(account)){
            ctx.status(201);
        }else {
            ctx.status(400);
        }
        }else {
            ctx.status(401);
        }

    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("manager/viewAllAccounts", getAccounts);
        app.get("manager/viewBalanceByAccount/{account_Id}", getAccount);
        app.put("manager/closeAccount", updateAccount);
        app.put("manager/approveAccount", updateAccount);
        app.put("manager/denyAccount", updateAccount);
        app.post("manager/addAccount", newAccount);
        app.get("manager/cancelAccount/{account_Id}", deleteAccount);
        app.post("employee/addAccount", newAccount);
        app.put("employee/approveAccount", updateAccount);
        app.put("employee/denyAccount", updateAccount);
        app.get("employee/viewAllAccounts", getAccounts);
        app.get("employee/viewBalanceByAccount/{account_Id}", getAccount);

    }
}
