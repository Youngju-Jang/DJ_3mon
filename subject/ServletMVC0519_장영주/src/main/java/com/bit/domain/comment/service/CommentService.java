package com.bit.domain.comment.service;

import com.bit.domain.comment.vo.Comment;

import java.util.List;

public interface CommentService {
     public void createComment(Comment parentComment, Comment comment);
     public List<Comment> selectAll();
     public Comment selectByCommentId(int id);
     public List<Comment> selectAllByBoardId(int id);
}
