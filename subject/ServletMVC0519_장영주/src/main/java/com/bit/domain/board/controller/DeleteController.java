package com.bit.domain.board.controller;

import com.bit.domain.board.dao.impl.BoardDaoImp;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements ProcessController {
     private String path;
     private boolean redirect;
     
     public DeleteController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          int no = Integer.parseInt(request.getParameter("no"));
          BoardDaoImp.getBoardDao().deleteBoard(no);
          
          return new ForWardController(path, redirect);
     }
}
