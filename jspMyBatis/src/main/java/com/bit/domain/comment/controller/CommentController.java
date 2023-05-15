package com.bit.domain.comment.controller;

import com.bit.domain.board.vo.Board;
import com.bit.domain.comment.service.impl.CommentServiceImp;
import com.bit.domain.comment.vo.Comment;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentController implements ProcessController {
     private String path;
     private boolean redirect;
     
     public CommentController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          int id = (int) request.getSession().getAttribute("id");
          int boardNo = Integer.parseInt(request.getParameter("board"));
          String content = request.getParameter("content");
          int parentCommentNum = 0;
          Comment parentComment = null;
          // 원댓글에 대한 댓글일경우
          System.out.println(request.getParameter("comment"));
          if (request.getParameter("comment").length() != 0) {
               parentCommentNum = Integer.parseInt(request.getParameter("comment"));
               parentComment = CommentServiceImp.instance.selectById(parentCommentNum);
               
               
          }else{
               // 원댓글인경우
               
               
          }
          
          CommentServiceImp.instance.createComment(parentComment, new Comment(id, content, boardNo));
          
          return new ForWardController(path, redirect);
     }
}
