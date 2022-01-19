
package com.revature.controllers;
import com.revature.models.Customer;
import com.revature.services.CustomerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class CustomerController implements Controller{

    private CustomerService customerService = new CustomerService();


    Handler getCustomers = (ctx) ->{
         if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
        //sent a cookie along with the request that matches an open session.
        ctx.json(customerService.findAllCustomer());
        ctx.status(200);
       }else {
            ctx.status(401);
        }
    };

    Handler getCustomer = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
        String cust_Id = ctx.pathParam("cust_Id");
        int id = Integer.parseInt(cust_Id);
        Customer customer = customerService.findCustomerById(id);
        ctx.json(customer);
        ctx.status(200);
       }else {
            ctx.status(401);
        }
    };


    Handler deleteCustomer= (ctx) -> {
         if(ctx.req.getSession(false)!=null){
        String cust_Id = ctx.pathParam("cust_Id");
        int id = Integer.parseInt(cust_Id);
        boolean customer = customerService.deleteCustomer(id);
        if(customer==true){
            ctx.json(customer);
            ctx.result("file is deleted");
            ctx.status(200);
        }
        else { ctx.result("file not found");};
        }else {
            ctx.status(401);
        }
    };
    Handler updateCustomer = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
        Customer customer = ctx.bodyAsClass(Customer.class);
        if(customerService.updateCustomer(customer)){
            ctx.status(202);
        }else {
            ctx.status(400);
        }
         }else {
            ctx.status(401);
        }
    };

    Handler newCustomer = (ctx)->{
        if(ctx.req.getSession(false)!=null){
        Customer customer = ctx.bodyAsClass(Customer.class);
        if(customerService.addCustomer(customer)){
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
        app.get("/manager/allCustomers", getCustomers);
        app.get("/manager/customerById/{cust_Id}", getCustomer);
        app.put("/manager/updateCustomer", updateCustomer);
        app.post("/manager/addCustomer", newCustomer);
        app.get("/manager/deleteCustomer/{cust_Id}", deleteCustomer);

        app.post("/customer/register", newCustomer);
    }
}
