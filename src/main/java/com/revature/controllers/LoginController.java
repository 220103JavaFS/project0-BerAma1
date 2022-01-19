package com.revature.controllers;
import com.revature.models.UserDTO;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import javax.servlet.ServletRequest;


public class LoginController implements Controller{

   LoginService loginService = new LoginService();


   /*
   MyLoginService myLoginService = new MyLoginService();

    Handler loginCheck = (ctx)->{
        Login log = ctx.bodyAsClass(Login.class);

        if(myLoginService.updateLogin(log) && myLoginService.customer(log)){
            ctx.req.getSession();
            ctx.result("customer");
            ctx.status(202);}
        else {
            ctx.req.getSession().invalidate(); ctx.status(401);
        }
    };
*/


    private Handler loginAttempt = (ctx) -> {
        UserDTO user = ctx.bodyAsClass(UserDTO.class);
        //A DTO (Data transfer object) is a temporary object used just to communicate information.

        if(loginService.login(user.username, user.password, user.user_Role)){
            ctx.req.getSession();
            //This will return an HttpSession object. If none exists then a new one will be created
            //and a cookie will be added to the response for the client to store.
            ctx.status(200);
        }else {
            ctx.req.getSession().invalidate();
            //invalidates any open session that is attached to the client that sent invalid credentials.
            ctx.status(401);
        }
    };


    @Override
    public void addRoutes(Javalin app)
    {
        app.post("/login", this.loginAttempt);
        //app.post("/loginCheck",this.loginCheck);
    }
}
