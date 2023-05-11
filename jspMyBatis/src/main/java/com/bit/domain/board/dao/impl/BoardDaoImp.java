package com.bit.domain.board.dao.impl;

import com.bit.conf.SqlSessionManager;
import com.bit.data.board.BoardMapper;
import com.bit.domain.board.dao.BoardDao;
import com.bit.domain.board.vo.Board;
import org.apache.ibatis.annotations.Param;
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
               boardList = boardMapper.selectBoardList(map);
          }catch (Exception e){
               e.printStackTrace();
          }
          return boardList;
     }
     
     @Override
     public void addHit(int no) {
          try(SqlSession sqlSession = sqlSessionFactory.openSession()){
               BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
               boardMapper.updateBoardHit(no);
               sqlSession.commit();
          }catch (Exception e){
               e.printStackTrace();
          }
     }
     
     @Override
     public Board selectBoard(int no) {
          Board board = null;
          try(SqlSession sqlSession = sqlSessionFactory.openSession()){
               BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
               board = boardMapper.selectBoard(no);
          }catch (Exception e){
               e.printStackTrace();
          }
          return board;
     }
     
     @Override
     public int countBoard(HashMap<String, Object> map) {
          int cnt = 0;
          try(SqlSession sqlSession = sqlSessionFactory.openSession()){
               BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
               cnt = boardMapper.countBoard(map);
          }catch (Exception e){
               e.printStackTrace();
          }
          return cnt;
     }
}
