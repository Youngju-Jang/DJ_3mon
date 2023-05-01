package com.bit.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.awt.SystemColor.window;

public class LoginController implements ProcessController {
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
          
          String checker = request.getParameter("checker");
          Cookie cookie = new Cookie("checker", id);
          cookie.setMaxAge(checker != null ? 30 : 0);
          response.addCookie(cookie);
          
          if ((id.equals("Admin") && pass.equals("1234"))) {
               request.getSession().setAttribute("id", id);
               request.getSession().setMaxInactiveInterval(1 * 60 * 60);
               path = request.getContextPath()+"/list.do?cmd=list";
               redirect = true;
          }
          return new ForwardController(path, redirect);
     }
}
