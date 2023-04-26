package com.bit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name="getTest", urlPatterns={"/get.do"})
@WebServlet(name="Post", value="/post.do")
public class PostServlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     }
     
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("UTF-8");
          response.setContentType("text/html; charset=UTF-8");
          response.setCharacterEncoding("utf-8");

          String name = request.getParameter("irum");
          int score = Integer.parseInt(request.getParameter("score"));
          
          PrintWriter out = response.getWriter();
          out.append("<html><head><title></title></head>");
          out.append("<body>");
          
          out.append("이름 : " + name + "<br>");
          out.append("점수 : " + score + "<br>");
          
          out.append("<a href='/jspBasic/getTest.jsp'>처음으로</a>");
          out.append("</body></html>");
          
          request.setAttribute("irumAttri", name);
     }
}
