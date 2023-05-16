package com.bit.domain.board.controller;

import com.bit.domain.board.service.BoardService;
import com.bit.domain.board.service.impl.BoardServiceImp;
import com.bit.domain.board.vo.Board;
import com.bit.domain.comment.service.impl.CommentServiceImp;
import com.bit.domain.comment.vo.Comment;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
          String job = request.getParameter("job");
          request.setAttribute("no", no);
          request.setAttribute("page", page);
          // no 로 데이터 setAttribute 하삼
          Board board = boardService.selectBoard(no);
          List<Comment> commentList = CommentServiceImp.instance.selectAllByBoardId(no);
          
          if (job.equalsIgnoreCase("info")) {
               request.setAttribute("board", board);
               request.setAttribute("commentList",commentList);
               path = "/jsp/info.jsp";
          }
          if(job.equalsIgnoreCase("mod")){
               request.setAttribute("board", board);
               path = "/jsp/modify.jsp";
          }
          if (job.equalsIgnoreCase("del")) {
          
          }
          
          return new ForWardController(path, redirect);
     }
}
