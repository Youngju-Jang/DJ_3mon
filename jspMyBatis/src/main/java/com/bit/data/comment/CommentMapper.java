package com.bit.data.comment;

import com.bit.domain.comment.vo.Comment;

import java.util.List;

public interface CommentMapper {
     void createComment(Comment comment);
     Comment selectById(int id);
     void addReply(int no);
     void updateStep(Comment comment);
     List<Comment> selectAllByBoardId(int id);
}
