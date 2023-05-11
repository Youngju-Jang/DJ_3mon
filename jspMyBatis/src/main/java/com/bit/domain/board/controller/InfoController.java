package com.bit.domain.board.controller;

import com.bit.domain.board.service.BoardService;
import com.bit.domain.board.service.impl.BoardServiceImp;
import com.bit.domain.board.vo.Board;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoController implements ProcessController {
     private String path;
     private boolean redirect;
     private BoardService boardService = BoardServiceImp.getBoardService();
     public InfoController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          int no = Integer.parseInt(request.getParameter("no"));
          String page = request.getParameter("page");
          request.setAttribute("no", no);
          request.setAttribute("page", page);
          // no 로 데이터 setAttribute 하삼
          Board board =  boardService.selectBoard(no);
          request.setAttribute("board", board);
          
          path = "/jsp/info.jsp";
          return new ForWardController(path, redirect);
     }
}
