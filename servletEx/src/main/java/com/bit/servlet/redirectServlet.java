package com.bit.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="loginCheck", urlPatterns = {"/loginCheck"})
public class redirectServlet extends HttpServlet {
     
     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          super.doGet(req, resp);
     }
     
     @Override// 로그인체크
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String id = request.getParameter("id");
          String pass = request.getParameter("pass");
          
          if (id.equals("Admin") && pass.equals("1234")) {
               response.sendRedirect("sessionServlet/sessionSuccess.jsp");
          }else {
               RequestDispatcher rd = request.getRequestDispatcher("/testForward2.jsp");
               rd.forward(request, response);
          }
     }
     
//     @Override
//     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          super.service(request, response);
//     }
}
