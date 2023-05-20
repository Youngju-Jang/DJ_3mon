package com.bit.domain.board.controller;

import com.bit.domain.board.service.BoardService;
import com.bit.domain.board.service.impl.BoardServiceImp;
import com.bit.domain.board.vo.Board;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;
import com.bit.global.vo.PageBean;
import com.bit.global.vo.PagingComponent;

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
          String search = request.getParameter("search");
          String option = request.getParameter("option");
          
          if(search!=null && option!=null){
               map.put("search", search);
               map.put("option", option);
          }
          map.put("pageBean", setPageBeanAttribute(request, map));
          
          List<Board> boardList = boardService.selectAll(map);
          request.setAttribute("boardList", boardList);
          request.setAttribute("search", search);
          request.setAttribute("option", option);
          
          return new ForWardController(path, redirect);
     }
     
     private PageBean setPageBeanAttribute(HttpServletRequest request, HashMap<String, Object> map) {
          int totalRow = boardService.countBoard(map);
          int currentPage = 1;
          if (request.getParameter("page") != null) { // page 파라미터 있는채로 온경우에만
               currentPage = Integer.parseInt(request.getParameter("page"));//현재 페이지
          }
          PagingComponent pagingComponent = new PagingComponent();
          PageBean pageBean = pagingComponent.pagingCreate(totalRow, currentPage);
          request.setAttribute("pageBean",pageBean);
          return pageBean;
     }
}
