package com.bit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Redirect2", urlPatterns="/testRedirect2")
public class TestRedirect2Servlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html; charset=UTF-8");
          request.setCharacterEncoding("UTF-8");
          System.out.println("TestRedirectServlet");
          System.out.println(request.getParameter("name"));
          PrintWriter out = response.getWriter();
          out.append("<html><head><title></title></head>");
          out.append("<body>");
          out.append("Redirect2 " + request.getParameter("name"));
          out.append("</body>");
     }
     
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html; charset=UTF-8");
          request.setCharacterEncoding("UTF-8");
          System.out.println("TestRedirectServlet");
       
     }
}
