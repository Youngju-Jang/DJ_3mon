package com.bit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="loginCheck", urlPatterns = {"/loginCheck"})
public class LoginCheckServlet extends HttpServlet {
     
     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          super.doGet(req, resp);
     }
     
     @Override// 로그인체크
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String id = request.getParameter("id");
          String pass = request.getParameter("pass");
          
          String checker = request.getParameter("checker");
          Cookie cookie = new Cookie("checker", id);
          cookie.setMaxAge(checker != null ? 30 : 0);
          response.addCookie(cookie);
          
          System.out.println("loginCheck Dopost");
          
          if (id.equals("Admin") && pass.equals("1234")) {
               request.getSession().setAttribute("id", id);
               request.getSession().setMaxInactiveInterval(60);
               response.sendRedirect("sessionServlet/sessionSuccess.jsp");
          }
     }
     
//     @Override
//     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          super.service(request, response);
//     }
}
