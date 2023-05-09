package com.bit.domain.board.dao.impl;

import com.bit.conf.SqlSessionManager;
import com.bit.data.board.BoardMapper;
import com.bit.domain.board.dao.BoardDao;
import com.bit.domain.board.vo.Board;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class BoardDaoImp implements BoardDao {
     private static final BoardDao boardDao = new BoardDaoImp();
     public static BoardDao getBoardDao(){
          return boardDao;
     }
     private final SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
     
     @Override
     public List<Object> selectEmp(Hashtable<String, Object> map) {
          return null;
     }
     
     @Override
     public String getIdCheck(String id) {
          return null;
     }
     
     @Override
     public void insertBoard(Board board) {
          try(SqlSession sqlSession = sqlSessionFactory.openSession()){
               BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
               boardMapper.insertBoard(board);
               sqlSession.commit();
          }catch (Exception e){
               e.printStackTrace();
          }
     }
     
     @Override
     public List<Board> selectAll(HashMap<String, Object> map) {
          List<Board> boardList = null;
          try(SqlSession sqlSession = sqlSessionFactory.openSession()){
               BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
               boardList = boardMapper.selectBoardList();
          }catch (Exception e){
               e.printStackTrace();
          }
          return boardList;
     }
}
