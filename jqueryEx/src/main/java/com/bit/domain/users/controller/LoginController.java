package com.bit.domain.users.controller;

import com.bit.domain.users.service.UserService;
import com.bit.domain.users.service.impl.UserServiceImp;
import com.bit.domain.users.vo.User;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements ProcessController {
     
     private String path;
     private boolean redirect;
     private UserService userService = UserServiceImp.getUserService();
     
     public LoginController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          // 로그인 요청시 전달받은 name, password 불러오기
          String name = request.getParameter("name");
          String password = request.getParameter("password");
          
          // 서비스단 로직 실행
          User checkedUser = userService.selectUser(name);
          // 세션에 아이디 추가 (name ? userId?)
          if (checkedUser != null && checkedUser.getPassword().equals(password)) { // user가 존재하고, 비밀번호 일치할 경우만 실행
               request.getSession().setAttribute("id", checkedUser.getUserId());
               request.getSession().setMaxInactiveInterval(60);
               request.setAttribute("state", "T");
          } else {
               request.setAttribute("state", "F");
          }
          path = "/jsp/AjaxLoginView.jsp";
          return new ForWardController(path, redirect);
     }
}
