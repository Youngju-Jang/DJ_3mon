package com.bit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Redirect", urlPatterns="/testRedirect")
public class TestRedirectServlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          System.out.println("TestRedirectServlet");
          
//          response.sendRedirect("/");
     }
     
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          resp.setContentType("text/html; charset=UTF-8");
          req.setCharacterEncoding("UTF-8");
          System.out.println("TestRedirectServlet");
          System.out.println(req.getParameter("name"));
//          super.doPost(req, resp);
          PrintWriter out = resp.getWriter();
          out.append("<html><head><title></title></head>");
          out.append("<body>");
          
          out.append("이름 : " + req.getParameter("name") + "<br>");
          out.append("</body></html>");
          
          resp.sendRedirect("/testRedirect2");
     }
}
