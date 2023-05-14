package com.bit.domain.board.controller;

import com.bit.domain.board.service.impl.BoardServiceImp;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PasswordController implements ProcessController {
     private String path;
     private boolean redirect;
     
     public PasswordController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          String job = request.getParameter("job");
          int no = Integer.parseInt(request.getParameter("no"));
          String inputPassword = request.getParameter("password");
          boolean isSame = BoardServiceImp.getBoardService().passCheck(no, inputPassword);
          if (!isSame) {
               path = "jsp/password.jsp?job=" + job + "&no=" + no;
               redirect = true;
          }
          if (isSame) {
               if (job.equalsIgnoreCase("mod")) {
                    path = "mod.do?cmd=info&no="+no+"&job=mod";
                    redirect = true;
               }
               if(job.equalsIgnoreCase("del")){
                    path = "delete.do?cmd=deleteBoard&no="+no;
                    redirect = true;
               }
          }
          return new ForWardController(path, redirect);
     }
}
