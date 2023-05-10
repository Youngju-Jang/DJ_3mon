package com.bit.domain.board.controller;

import com.bit.domain.board.service.BoardService;
import com.bit.domain.board.service.impl.BoardServiceImp;
import com.bit.domain.board.vo.Board;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;
import com.bit.global.vo.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public class ListController implements ProcessController {
     private String path;
     private boolean redirect;
     private BoardService boardService = BoardServiceImp.getBoardService();
     
     public ListController(String path, boolean redirect) {
          super();
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          HashMap<String, Object> map = new HashMap<>();
          String search = request.getParameter("search") ;
          System.out.println("search : " + search);
          int page = (request.getParameter("page"))!=null ? Integer.parseInt(request.getParameter("page")) : 1;
          map.put("page", new Page(page, 3));
          List<Board> boardList = boardService.selectAll(map);
          request.setAttribute("boardList", boardList);
          
          return new ForWardController(path, redirect);
     }
}