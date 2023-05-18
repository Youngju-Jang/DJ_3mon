package com.bit.domain.board.controller;

import com.bit.domain.board.service.BoardService;
import com.bit.domain.board.service.impl.BoardServiceImp;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HitController implements ProcessController {
     private String path;
     private boolean redirect;
     private BoardService boardService = BoardServiceImp.getBoardService();
     
     public HitController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          int no = Integer.parseInt(request.getParameter("no"));
          String page = request.getParameter("page");
          
          // 조회수 처리 후
          boardService.addHit(no);
          // Info Controller 로 redirect
          path =  "info.do?cmd=info&no="+no+"&page="+page+"&job=info";
          return new ForWardController(path, redirect);
     }
}
