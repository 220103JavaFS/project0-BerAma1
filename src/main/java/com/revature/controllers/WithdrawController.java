package com.revature.controllers;

import com.revature.models.Withdraw;
import com.revature.services.WithdrawService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class WithdrawController implements Controller{
    private WithdrawService withdrawService = new WithdrawService();


    Handler getWithdraws = (ctx) ->{
        //  if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
        //sent a cookie along with the request that matches an open session.
        ctx.json(withdrawService.findAllWithdraw());
        ctx.status(200);
      /*  }else {
            ctx.status(401);
        } */
    };

    Handler getWithdraw = (ctx) -> {
        // if(ctx.req.getSession(false)!=null){
        String withdraw_Id = ctx.pathParam("withdraw_Id");
        int id = Integer.parseInt(withdraw_Id);
        Withdraw withdraw = withdrawService.findWithdrawById(id);
        ctx.json(withdraw);
        ctx.status(200);
       /* }else {
            ctx.status(401);
        }*/
    };


    Handler newWithdraw = (ctx)->{
        // if(ctx.req.getSession(false)!=null){
        Withdraw withdraw = ctx.bodyAsClass(Withdraw.class);
        if(withdrawService.addWithdraw(withdraw)){
            ctx.status(201);
        }else {
            ctx.status(400);
        }
        /*}else {
            ctx.status(401);
        } */

    };


    @Override
    public void addRoutes(Javalin app) {
        app.get("/manager/allWithdraws", getWithdraws);
        app.get("/manager/WithdrawById/{Withdraw_Id}", getWithdraw);
        app.post("/manager/addWithdraw", newWithdraw);

        app.get("/employee/WithdrawById/{Withdraw_Id}", getWithdraw);
        app.post("/employee/addWithdraw", newWithdraw);
        app.get("/customer/WithdrawById/{Withdraw_Id}", getWithdraw);
        app.post("/customer/addWithdraw", newWithdraw);
    }
}
