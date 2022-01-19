package com.revature;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletRequest;
import com.revature.controllers.*;
import io.javalin.Javalin;
public class App {
static HttpServletRequest request;
    private static Javalin app;

    public static void main(String[] args) {

        app = Javalin.create();
        configure(new AddressController(), new WithdrawController(), new MyLoginController(), new CustomerController(), new DepositController(), new EmployeeController(), new TransferController(), new Customer_AccountController(), new HomeController(), new AccountController(), new LoginController(), new AvengerController(), new MenuController());
        app.start();
    }

    private static void configure(Controller... controllers){
        for(Controller c: controllers){
            c.addRoutes(app);
        }
    }
}
