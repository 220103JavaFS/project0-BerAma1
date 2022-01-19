package com.revature.controllers;

import com.revature.models.Login;
import com.revature.services.MyLoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class MyLoginController implements Controller{

    private MyLoginService loginService = new MyLoginService();


    Handler getLogins = (ctx) ->{
        if(ctx.req.getSession(false)!=null) {
        ctx.json(loginService.findAllLogin());
        ctx.status(200);
       }else {
            ctx.status(401);
            ctx.result("login first!");
        }
    };

    Handler getLogin = (ctx) -> {
        if(ctx.req.getSession(false)!=null){

        String user_id=ctx.pathParam("user_id");
        int i=Integer.parseInt(user_id);
        Login id = loginService.findLoginById(i);
        ctx.json(id);
        ctx.status(200);
        }else {
            ctx.status(401);
            ctx.result("login first!");
        }
    };


    Handler deleteLogin = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
        String user_Id = ctx.pathParam("user_Id");
        int id = Integer.parseInt(user_Id);
        boolean login = loginService.deleteLogin(id);
        if(login==true){
            ctx.json(login);
            ctx.result("file is deleted");
            ctx.status(200);
        }
        else { ctx.result("file not found");}
        }else {
            ctx.status(401);  ctx.result("login first!");
        }
    };



    Handler updateLogin = (ctx) -> {
        Login login = ctx.bodyAsClass(Login.class);
        if(loginService.updateLogin(login)){
            ctx.status(202);
        }else {
            ctx.status(400);
        }
        /* }else {
            ctx.status(401);
        } */ // for multiple comment
    };


    Handler checkAll = (ctx)->{
        Login log = ctx.bodyAsClass(Login.class);

        if(loginService.checkAll(log)){
            ctx.req.getSession();
            ctx.result("Welcome! ");
            ctx.status(202);}
        else {
            ctx.req.getSession().invalidate();
            ctx.result(" Please incorrect account again");
            ctx.status(401);
        }
    };


    Handler newLogin = (ctx)->{
        if(ctx.req.getSession(false)!=null){
        Login login = ctx.bodyAsClass(Login.class);
        if(loginService.addLogin(login)){
            ctx.status(201);
        }else {
            ctx.status(400);
        }
        }else {
            ctx.status(401);
        }

    };
    
 Handler logout = (ctx)->{
        Login log = ctx.bodyAsClass(Login.class);
                ctx.req.getSession().invalidate();
            ctx.result(" logout seccessfully");
            ctx.status(201);
    };
    @Override
    public void addRoutes(Javalin app) {
        app.get("/manager/allLogins", getLogins);
        app.get("/manager/loginById/{user_id}", getLogin);
        app.put("/manager/updateLogin", updateLogin);
        app.get("/deleteLogin/{user_Id}", deleteLogin);
        app.put("/employee/updateLogin", updateLogin);
        app.put("/customer/updateLogin", updateLogin);
        app.put("/loginpage", checkAll);
        app.post("/addLogin", newLogin);
        app.get("/logout",logout);

    }
    
}
