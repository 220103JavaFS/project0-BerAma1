package com.revature.controllers;

import com.revature.models.Transfer;
import com.revature.services.TransferService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class TransferController implements Controller {
    private TransferService transferService = new TransferService();


    Handler getTransfers = (ctx) ->{
        //  if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
        //sent a cookie along with the request that matches an open session.
        ctx.json(transferService.findAllTransfer());
        ctx.status(200);
      /*  }else {
            ctx.status(401);
        } */
    };

    Handler getTransfer = (ctx) -> {
        // if(ctx.req.getSession(false)!=null){
        String transfer_Id = ctx.pathParam("transfer_Id");
        int id = Integer.parseInt(transfer_Id);
        Transfer transfer = transferService.findTransferById(id);
        ctx.json(transfer);
        ctx.status(200);
       /* }else {
            ctx.status(401);
        }*/
    };


    Handler newTransfer = (ctx)->{
        // if(ctx.req.getSession(false)!=null){
        Transfer transfer = ctx.bodyAsClass(Transfer.class);
        if(transferService.addTransfer(transfer)){
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
        app.get("/manager/allTransfers", getTransfers);
        app.get("/manager/transferById/{transfer_Id}", getTransfer);
        app.post("/manager/addTransfer", newTransfer);

        app.get("/employee/transferById/{transfer_Id}", getTransfer);
        app.post("/employee/addTransfer", newTransfer);

        app.get("/customer/transferById/{transfer_Id}", getTransfer);
        app.post("/customer/addTransfer", newTransfer);
    }
}
