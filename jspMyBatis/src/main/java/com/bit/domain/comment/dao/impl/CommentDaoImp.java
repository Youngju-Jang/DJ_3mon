package com.bit.domain.comment.dao.impl;

import com.bit.conf.SqlSessionManager;
import com.bit.data.comment.CommentMapper;
import com.bit.domain.comment.dao.CommentDao;
import com.bit.domain.comment.vo.Comment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CommentDaoImp implements CommentDao {
     
     public static final CommentDao instance = new CommentDaoImp();
     private final SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
     
     @Override
     public void createComment(Comment comment) {
          try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
               CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
               commentMapper.createComment(comment);
               sqlSession.commit();
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
     
     @Override
     public List<Comment> selectAll() {
          return null;
     }
}
