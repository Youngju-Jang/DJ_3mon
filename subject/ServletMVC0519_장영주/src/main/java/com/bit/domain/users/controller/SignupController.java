package com.bit.domain.users.controller;

import com.bit.domain.users.service.UserService;
import com.bit.domain.users.service.impl.UserServiceImp;
import com.bit.domain.users.vo.User;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupController implements ProcessController {
     private String path;
     private boolean redirect;
     private UserService userService = UserServiceImp.getUserService();
     
     public SignupController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          String name = request.getParameter("name");
          String password = request.getParameter("password");
          if(userService.checkName(name)){ // 이미 존재하는 아이디
               request.setAttribute("state", "F");
          }else{
               // 회원가입 시키기
               userService.createUser(new User(name, password));
               request.setAttribute("state", "T");
          };
          path = "/AjaxLoginView.jsp";
          return new ForWardController(path, redirect);
     }
}
