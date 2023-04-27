package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements ProcessController{
     private String path;
     private boolean redirect;
     
     public LoginController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
          
          // bl 수행
          System.out.println("login controller ");
          String id = request.getParameter("id");
          String pass = request.getParameter("pass");
          if((id.equals("Admin") && pass.equals("1234"))){
               request.getSession().setAttribute("id", id);
               request.getSession().setMaxInactiveInterval(30);
               path = "list.do?cmd=list";
               redirect = true;
          }
          return new ForwardController(path, redirect);
     }
}
