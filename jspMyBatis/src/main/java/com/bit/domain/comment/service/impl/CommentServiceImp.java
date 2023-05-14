package com.bit.domain.comment.service.impl;

import com.bit.domain.comment.dao.CommentDao;
import com.bit.domain.comment.dao.impl.CommentDaoImp;
import com.bit.domain.comment.service.CommentService;
import com.bit.domain.comment.vo.Comment;

import java.util.List;

public class CommentServiceImp implements CommentService {
     public static final CommentService instance = new CommentServiceImp();
     @Override
     public void createComment(Comment comment) {
          CommentDaoImp.instance.createComment(comment);
     }
     
     @Override
     public List<Comment> selectAll() {
          return null;
     }
}
