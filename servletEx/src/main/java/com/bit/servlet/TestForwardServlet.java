package com.bit.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Forward", urlPatterns="/testForward")
public class TestForwardServlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html; charset=UTF-8");
          request.setCharacterEncoding("UTF-8");
          System.out.println("TestForwardServlet");
          System.out.println(request.getParameter("name"));
//          super.doPost(req, resp);
          PrintWriter out = response.getWriter();
          out.append("<html><head><title></title></head>");
          out.append("<body>");
          
          out.append("이름 : " + request.getParameter("name") + "<br>");
          out.append("번호 : " + request.getParameter("tel") + "<br>");
          out.append("</body></html>");
          
     }
     
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          resp.setContentType("text/html; charset=UTF-8");
          req.setCharacterEncoding("UTF-8");
          System.out.println("TestForwardServlet");
          System.out.println(req.getParameter("name"));
          req.setAttribute("tel", "010-3823-9494");
          
//          super.doPost(req, resp);
          PrintWriter out = resp.getWriter();
          out.append("<html><head><title></title></head>");
          out.append("<body>");
          
          out.append("이름 : " + req.getParameter("name") + "<br>");
          out.append("</body></html>");
          
          RequestDispatcher rd = req.getRequestDispatcher("/testForward2");
          rd.forward(req, resp);
          
     }
}
