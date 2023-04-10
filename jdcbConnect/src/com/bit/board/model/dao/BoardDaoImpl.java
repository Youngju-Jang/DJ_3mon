package com.bit.board.model.dao;

import com.bit.model.bean.BoardDto;
import com.bit.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
     
     private static BoardDao boardDao = new BoardDaoImpl();
     
     public static BoardDao getBoardDao() {
          return boardDao;
     }
     
     @Override
     public void registerArticle(BoardDto boardDto) {
          Connection con = null;
          PreparedStatement pstmt = null;
          try {
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
          } catch (Exception e) {
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
          List<BoardDto> list = new ArrayList<BoardDto>();
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          try {
               con = DBUtil.getInstance().getConnection();
               StringBuilder sql = new StringBuilder("Select Article_no, user_id, subject, content, register_time \n");
               sql.append("From board \n")
                    .append("order by article_no desc");
               pstmt = con.prepareStatement(sql.toString());
               rs = pstmt.executeQuery();
               while (rs.next()) {
                    BoardDto dto = new BoardDto();
                    dto.setArticleNo(rs.getInt("Article_no"));
                    dto.setUserId(rs.getString("user_id"));
                    dto.setSubject(rs.getString("subject"));
                    dto.setContent(rs.getString("content"));
                    dto.setRegisterTime(rs.getString("register_time"));
                    list.add(dto);
               }
          } catch (SQLException e) {
               e.printStackTrace();
          } finally {
               DBUtil.getInstance().close(rs, pstmt, con);
          }
          return list;
     }
     
     @Override
     public List<BoardDto> seearchListBySubject(String subject) {
          List<BoardDto> list = new ArrayList<BoardDto>();
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          try {
               con = DBUtil.getInstance().getConnection();
               StringBuilder sql = new StringBuilder("Select Article_no, user_id, subject, content, register_time \n");
               sql.append("From board \n")
                    .append("where subject like ? \n")
                    .append("order by article_no desc");
               
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setString(1, "%" + subject + "%");
               rs = pstmt.executeQuery();
               while(rs.next()){
                    BoardDto dto = new BoardDto();
                    dto.setArticleNo(rs.getInt("Article_no"));
                    dto.setUserId(rs.getString("user_id"));
                    dto.setSubject(rs.getString("subject"));
                    dto.setContent(rs.getString("content"));
                    dto.setRegisterTime(rs.getString("register_time"));
                    list.add(dto);
               }
          }catch (SQLException e){
               e.printStackTrace();
          }finally {
               DBUtil.getInstance().close(rs, pstmt, con);
          }
          return list;
     }
     
     // 상세정보
     @Override
     public BoardDto viewArticle(int no) {
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          try {
               con = DBUtil.getInstance().getConnection();
               StringBuilder sql = new StringBuilder("Select Article_no, user_id, subject, content, register_time \n");
               sql.append("From board \n")
                    .append("where Article_no = ? ");
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setInt(1, no);
               rs = pstmt.executeQuery();
               rs.next();
               BoardDto dto = new BoardDto();
               dto.setArticleNo(rs.getInt("Article_no"));
               dto.setUserId(rs.getString("user_id"));
               dto.setSubject(rs.getString("subject"));
               dto.setContent(rs.getString("content"));
               dto.setRegisterTime(rs.getString("register_time"));
               return dto;
          } catch (SQLException e) {
               e.printStackTrace();
          } finally {
               DBUtil.getInstance().close(rs, pstmt, con);
          }
          return null;
     }
     
     @Override
     public void modifyArticle(BoardDto boardDto) {
          Connection con = null;
          PreparedStatement pstmt = null;
          try {
               con = DBUtil.getInstance().getConnection();
               con.setAutoCommit(false);
               StringBuilder sql = new StringBuilder("update board \n");
               sql.append("set subject = ?, content = ? \n");
               sql.append("where article_no = ?");
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setString(1, boardDto.getSubject());
               pstmt.setString(2, boardDto.getContent());
               pstmt.setInt(3, boardDto.getArticleNo());
               pstmt.executeUpdate();
               con.commit();
          }catch(SQLException e){
               e.printStackTrace();
               try {
                    con.rollback();
               } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
               }
          } finally {
               DBUtil.getInstance().close(pstmt, con);
          }
     }
     
     @Override
     public void deleteArticle(int no) {
          Connection conn = null;
          PreparedStatement pstmt = null;
          try {
               conn = DBUtil.getInstance().getConnection();
               conn.setAutoCommit(false);
               StringBuilder sql = new StringBuilder("delete from board \n");
               sql.append("where article_no = ?");
               pstmt = conn.prepareStatement(sql.toString());
               pstmt.setInt(1, no);
               pstmt.executeUpdate();
               conn.commit();
          } catch (SQLException e) {
               e.printStackTrace();
               try {
                    conn.rollback();
               } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
               }
          } finally {
               DBUtil.getInstance().close(pstmt, conn);
          }
     }
}
