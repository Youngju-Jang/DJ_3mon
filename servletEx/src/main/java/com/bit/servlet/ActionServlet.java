package com.bit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Action", value="/hi")
public class ActionServlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          Cookie i = new Cookie("test", "test");
          i.setMaxAge(60*60);
          response.addCookie(i);

          System.out.println("Action do Get");
//          response.sendRedirect("/");
     }
     
     @Override
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html; charset=utf-8");
          PrintWriter out = response.getWriter();
          out.append("<html><head><title>TEST SERVICE</title></head>");
          out.append("<body bgcolor='red'></body>");
          out.append("<a href='next.do'>이동</a>");
          out.append("</html>");
          super.service(request, response);
     }
}
