package com.bit.global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet",urlPatterns = {"*.do"})
public class DispatcherServlet extends HttpServlet{
     @Override
     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          jspracterEncoding("UTF-8");
          String cmd=request.getParameter("cmd"); // request parameter중 cmd 파라미터 값을 찾음
          ProcessController pc=MapperServlet.getMapper(cmd); // cmd에따른 컨트롤러 객체 생성
          ForWardController fc= pc.execute(request, response); // 생성된 컨트롤러의 execute메소드 실행하여 로직 수행 후 ForwardController return
          if(fc.isRedirect()) { // 생성한 ForwardController의 Redirect true 일 경우 실행 (Redirect)
               response.sendRedirect(fc.getPath());
          }else { // redirect false 일 경우 forward 로 수행
               RequestDispatcher rd=request.getRequestDispatcher(fc.getPath());
               rd.forward(request, response);
          }
          
     }
     
}