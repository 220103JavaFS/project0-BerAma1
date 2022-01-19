package com.revature.controllers;

import com.revature.models.Address;
import com.revature.services.AddressService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AddressController  implements  Controller{
    private AddressService addressService = new AddressService();


    Handler getAddresses = (ctx) ->{
        //  if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
        //sent a cookie along with the request that matches an open session.
        ctx.json(addressService.findAllAddress());
        ctx.status(200);
      /*  }else {
            ctx.status(401);
        } */
    };

    Handler getAddress = (ctx) -> {
        // if(ctx.req.getSession(false)!=null){
        String address_Id = ctx.pathParam("address_Id");
        int id = Integer.parseInt(address_Id);
        Address address = addressService.findAddressById(id);
        ctx.json(address);
        ctx.status(200);
       /* }else {
            ctx.status(401);
        }*/
    };
    Handler deleteAddress = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
        String address_Id = ctx.pathParam("address_Id");
        int id = Integer.parseInt(address_Id);
        boolean address = addressService.deleteAddress(id);
       if(address==true){
        ctx.json(address);
        ctx.result("file is deleted");
        ctx.status(200);
       }
       else { ctx.result("file not found");}
       }else {
            ctx.status(401);
        }
    };
    Handler updateAddress = (ctx) -> {
         if(ctx.req.getSession(false)!=null){
        Address address = ctx.bodyAsClass(Address.class);

        boolean address2 = addressService.updateAddress(address);
        if(address2==true){
            ctx.result("file updated");
            ctx.status(202);
        }else {
            ctx.result("file not updated");
            ctx.status(400);
        }
        }else {
            ctx.status(401);
        }
    };

    Handler newAddress = (ctx)->{
        if(ctx.req.getSession(false)!=null){
        Address address = ctx.bodyAsClass(Address.class);
        if(addressService.addAddress(address)){
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
        app.get("/allAddresses", getAddresses);
        app.get("/addressById/{address_Id}", getAddress);
        app.put("/updateAddress", updateAddress);
        app.post("/addAddress", newAddress);
        app.get("/deleteAddress/{address_Id}", deleteAddress);
    }
}
