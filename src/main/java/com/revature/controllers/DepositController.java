package com.revature.controllers;

import com.revature.models.Deposit;
import com.revature.services.DepositService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class DepositController implements  Controller{
    private DepositService depositService = new DepositService();


    Handler getDeposits = (ctx) ->{
         if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
        //sent a cookie along with the request that matches an open session.
        ctx.json(depositService.findAllDeposit());
        ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getDeposit = (ctx) -> {
         if(ctx.req.getSession(false)!=null){
        String deposit_Id = ctx.pathParam("deposit_Id");
        int id = Integer.parseInt(deposit_Id);
        Deposit deposit = depositService.findDepositById(id);
        ctx.json(deposit);
        ctx.status(200);
        }else {
            ctx.status(401);
        }
    };
    
    
    Handler newDeposit = (ctx)->{
        if(ctx.req.getSession(false)!=null){
       Deposit deposit = ctx.bodyAsClass(Deposit.class);
        if(depositService.addDeposit(deposit)){
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
        app.get("manager/allDeposits", getDeposits);
        app.get("manager/depositById/{deposit_Id}", getDeposit);
        app.post("manager/addDeposit", newDeposit);
        app.get("employee/depositById/{deposit_Id}", getDeposit);
        app.post("employee/addDeposit", newDeposit);
        app.get("customer/depositById/{deposit_Id}", getDeposit);
        app.post("customer/addDeposit", newDeposit);
    }
}
