package com.bit.domain.comment.service;

import com.bit.domain.comment.vo.Comment;

import java.util.List;

public interface CommentService {
     public void createComment(Comment comment);
     public List<Comment> selectAll();
}
