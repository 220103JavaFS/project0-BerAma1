package com.revature.controllers;

import com.revature.models.UserDTO;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class MenuController implements Controller {



    LoginService loginService = new LoginService();
    private Handler menu = (ctx) ->
    {
     ctx.result("Welcome To My Bank ! Please Press 1 to login Please Press 2 to Register") ;
    };
    @Override
    public void addRoutes(Javalin app) {
        app.get("/menu", menu);
    }
}
