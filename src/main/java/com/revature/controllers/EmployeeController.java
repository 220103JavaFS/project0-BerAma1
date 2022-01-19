package com.revature.controllers;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController implements Controller {

    private EmployeeService employeeService = new EmployeeService();


    Handler getEmployees = (ctx) ->{
        //  if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
        //sent a cookie along with the request that matches an open session.
        ctx.json(employeeService.findAllEmployee());
        ctx.status(200);
      /*  }else {
            ctx.status(401);
        } */
    };

    Handler getEmployee = (ctx) -> {
        // if(ctx.req.getSession(false)!=null){
        String emp_Id = ctx.pathParam("emp_Id");
        int id = Integer.parseInt(emp_Id);
        Employee employee = employeeService.findEmployeeById(id);
        ctx.json(employee);
        ctx.status(200);
       /* }else {
            ctx.status(401);
        }*/
    };


    Handler deleteEmployee= (ctx) -> {
        if(ctx.req.getSession(false)!=null){
        String emp_Id = ctx.pathParam("emp_Id");
        int id = Integer.parseInt(emp_Id);
        boolean employee = employeeService.deleteEmployee(id);
        if(employee==true){
            ctx.json(employee);
            ctx.result("file is deleted");
            ctx.status(200);
        }
        else { ctx.result("file not found");}
       }else {
            ctx.status(401);
        }
    };
    Handler updateEmployee = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            Employee employee = ctx.bodyAsClass(Employee.class);
        if(employeeService.updateEmployee(employee)){
            ctx.status(202);
        }else {
            ctx.status(400);
        }
        }else {
            ctx.status(401);
        }
    };

    Handler newEmployee = (ctx)->{
        if(ctx.req.getSession(false)!=null){
        Employee employee = ctx.bodyAsClass(Employee.class);
        if(employeeService.addEmployee(employee)){
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
        app.get("/manager/viewAllEmployees", getEmployees);
        app.get("manager/viewEmployeeById/{emp_Id}", getEmployee);
        app.put("manager/updateEmployee", updateEmployee);
        app.post("manager/addEmployee", newEmployee);
        app.get("manager/deleteEmployee/{emp_Id}", deleteEmployee);
    }
}
