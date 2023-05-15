package com.bit.domain.comment.dao;

import com.bit.domain.comment.vo.Comment;

import java.util.List;

public interface CommentDao {
     public void createComment(Comment comment);
     public List<Comment> selectAll();
     Comment selectById(int id);
     public void addReply(int no);
     public void updateStep(Comment comment);
}
