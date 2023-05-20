package com.bit.domain.comment.controller;

import com.bit.domain.comment.service.impl.CommentServiceImp;
import com.bit.domain.comment.vo.Comment;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelectController implements ProcessController {
     private String path;
     private boolean redirect;
     
     public SelectController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          int id = (int) request.getSession().getAttribute("id");
          int boardNo = Integer.parseInt(request.getParameter("board"));
          // 원댓글에 대한 댓글일경우
          List<Comment> commentList = CommentServiceImp.instance.selectAllByBoardId(boardNo);
          request.setAttribute("commentList",commentList);
          request.setAttribute("boardNo", boardNo);
          return new ForWardController(path, redirect);
     }
}
