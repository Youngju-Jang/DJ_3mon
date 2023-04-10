package com.bit.board.model.dao;

import com.bit.model.bean.BoardDto;
import com.bit.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BoardDaoImpl implements BoardDao{
     
     private static BoardDao boardDao = new BoardDaoImpl();
     
     public static BoardDao getBoardDao(){
          return boardDao;
     }
     @Override
     public void registerArticle(BoardDto boardDto) {
          Connection con = null;
          PreparedStatement pstmt = null;
          try{
               con = DBUtil.getInstance().getConnection();
               StringBuilder sql = new StringBuilder("insert into board (subject, content, user_id) \n");
               con.setAutoCommit(false);
               sql.append("values (?,?,?) ");
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setString(1, boardDto.getSubject());
               pstmt.setString(2, boardDto.getContent());
               pstmt.setString(3, boardDto.getUserId());
               pstmt.executeUpdate();
               con.commit();
          }catch (Exception e){
               e.printStackTrace();
               try {
                    con.rollback();
               } catch (SQLException ex) {
               }
          } finally {
               DBUtil.getInstance().close(pstmt, con);
          }
     }
     
     @Override
     public List<BoardDto> searchListAll() {
          return null;
     }
     
     @Override
     public List<BoardDto> seearchListBySubject(String subject) {
          return null;
     }
     
     @Override
     public BoardDto viewArticle(int no) {
          return null;
     }
     
     @Override
     public void modifyArticle(BoardDto boardDto) {
     
     }
     
     @Override
     public void deleteArticle(int no) {
     
     }
}
