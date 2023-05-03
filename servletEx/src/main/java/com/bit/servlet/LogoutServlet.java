package com.bit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="logout", urlPatterns = {"/logoutServlet"})
public class LogoutServlet extends HttpServlet {
     
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.getSession().removeAttribute("id");
//          request.getSession().invalidate();
          response.sendRedirect("sessionServlet/sessionLogin.jsp");
          request.setAttribute("test","test");
          
     }
     
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          super.doPost(req, resp);
     }
}
