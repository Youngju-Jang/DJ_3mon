package com.bit.domain.comment.service.impl;

import com.bit.domain.comment.dao.CommentDao;
import com.bit.domain.comment.dao.impl.CommentDaoImp;
import com.bit.domain.comment.service.CommentService;
import com.bit.domain.comment.vo.Comment;

import java.util.List;

public class CommentServiceImp implements CommentService {
     public static final CommentService instance = new CommentServiceImp();
     @Override
     public void createComment(Comment parentComment, Comment comment) {
          // 부모댓글 가지고 새코멘트 필드값 수정필요
          if(parentComment!=null){
               // 1. 부모값도 바꿔야 함(댓글수 +1 )
               CommentDaoImp.instance.addReply(parentComment.getNo());
               // 2. 만들 댓글에 부모댓글 관련필드 적용
               comment.setByParent(parentComment);
               // 3. 부모에 달린 기존 댓글들 step++ (where ref=comment.ref lev <= comment.lev)
               CommentDaoImp.instance.updateStep(comment);
          }
          // 새로만들 댓글
          CommentDaoImp.instance.createComment(comment);
     }
     
     @Override
     public List<Comment> selectAll() {
          return null;
     }
     
     @Override
     public Comment selectByCommentId(int commentId) {
          return CommentDaoImp.instance.selectById(commentId);
     }
     
     @Override
     public List<Comment> selectAllByBoardId(int id) {
          return CommentDaoImp.instance.selectAllByBoardId(id);
     }
}
