package com.bit.domain.comment.dao;

import com.bit.domain.comment.vo.Comment;

import java.util.List;

public interface CommentDao {
     public void createComment(Comment comment);
     public List<Comment> selectAll();
}
