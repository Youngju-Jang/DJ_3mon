package com.bit.domain.comment.controller;

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
          int id = (int)request.getSession().getAttribute("id");
          String content = request.getParameter("content");
          System.out.println("content = " + content);
          System.out.println("id = " + id);
          CommentServiceImp.instance.createComment(new Comment(id, content));
          return new ForWardController(path, redirect);
     }
}
