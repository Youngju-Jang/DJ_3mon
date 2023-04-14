package com.bit.board.model.dao;

import com.bit.model.bean.DiaryDto;
import com.bit.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DiaryDaoImpl implements DiaryDao{
     private static DiaryDao diaryDao = new DiaryDaoImpl();
     public static DiaryDao getDiaryDao(){return diaryDao;}
     
     @Override
     public boolean writeDiary(DiaryDto diaryDto) {
          Connection con = null;
          PreparedStatement pstmt = null;
          boolean isSuccess = false;
          try {
               con = DBUtil.getInstance().getConnection();
               con.setAutoCommit(false);
               StringBuilder sql = new StringBuilder("insert into diary (user_id, date, expense, category, note) \n");
               sql.append("values (?,?,?,?,?) ");
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setInt(1, diaryDto.getUserId());
               pstmt.setString(2, diaryDto.getDate());
               pstmt.setInt(3, diaryDto.getExpense());
               pstmt.setString(4, diaryDto.getCategory());
               pstmt.setString(5, diaryDto.getNote());
               pstmt.executeUpdate();
               con.commit();
               isSuccess = true;
          } catch (Exception e) {
               e.printStackTrace();
               try {
                    con.rollback();
               } catch (SQLException ex) {
               }
          } finally {
               DBUtil.getInstance().close(pstmt, con);
          }
          return isSuccess;
     }
     
     @Override
     public void modifyDiary(DiaryDto diaryDto) {
     
     }
     
     @Override
     public void deleteDiary(int diaryId) {
     
     }
     
     @Override
     public List<DiaryDto> getTotalRecord(int userId) {
          return null;
     }
}
