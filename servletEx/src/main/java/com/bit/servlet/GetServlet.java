package com.bit.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name="getTest", urlPatterns={"/get.do"})
@WebServlet(name="Get", value="/get.do")
public class GetServlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html; charset=UTF-8");
          
          String name = request.getParameter("irum");
          String pass = request.getParameter("password");
          String attriName = (String)request.getAttribute("irumAttri");
          PrintWriter out = response.getWriter();
          out.append("<html><head><title></title></head>");
          out.append("<body>");
          
          out.append("이름 : " + name + "<br>");
          out.append("암호 : " + pass + "<br>");
          out.append("attri 이름 : " + attriName +"<br>");
          
          out.append("<a href='/jspBasic/postTest.jsp'>처음으로</a>");
          out.append("</body></html>");
          
          
     }
     
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
     }
}
