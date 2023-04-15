package com.bit.board.model.dao;

import com.bit.model.bean.UserDto;
import com.bit.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
     private static UserDao userDao = new UserDaoImpl();
     public static UserDao getUserDao(){return userDao;}
     
     @Override
     public boolean registerUser(String username, String password) {
          Connection con = null;
          PreparedStatement pstmt = null;
          boolean success = false;
          try {
               con = DBUtil.getInstance().getConnection();
               con.setAutoCommit(false);
               StringBuilder sql = new StringBuilder("insert into user (username, password) \n");
               sql.append("values (?,?) ");
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setString(1, username);
               pstmt.setString(2, password);
               pstmt.executeUpdate();
               con.commit();
               success = true;
          }catch (Exception e) {
               e.printStackTrace();
               try {
                    con.rollback();
                    success = false;
               } catch (SQLException ex) {
               }
          } finally {
               DBUtil.getInstance().close(pstmt, con);
          }
          return success;
     }
     
     @Override
     public int getUserId(String username) {
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          int num = 0;
          try {
               con = DBUtil.getInstance().getConnection();
               StringBuilder sql = new StringBuilder("select user_id cnt from user \n");
                              sql.append("where username = ?");
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setString(1, username);
               rs = pstmt.executeQuery();
               while(rs.next()){
                         num = rs.getInt("cnt");
               }
          }catch (SQLException e){
               e.printStackTrace();
          }finally {
               DBUtil.getInstance().close(rs, pstmt, con);
          }
          return num;
     }
     
     @Override
     public UserDto getUserByUsername(String username) {
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          UserDto user = null;
          try {
               con = DBUtil.getInstance().getConnection();
               StringBuilder sql = new StringBuilder("select * from user \n");
               sql.append("where username = ?");
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setString(1, username);
               rs = pstmt.executeQuery();
               while(rs.next()){
                    user = new UserDto();
                    user.setUserId(rs.getInt("user_id"));
                    user.setUsername(username);
                    user.setPassword(rs.getString("password"));
                    user.setAllowance(rs.getInt("allowance"));
               }
          }catch (SQLException e){
               e.printStackTrace();
          }finally {
               DBUtil.getInstance().close(rs, pstmt, con);
          }
          return user;
     }
     
     @Override
     public List<UserDto> searchAllUser() {
          return null;
     }
     
     @Override
     public int showAllowance(int no) {
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          try {
               con = DBUtil.getInstance().getConnection();
               StringBuilder sql = new StringBuilder("Select allowance \n");
               sql.append("From user \n")
                    .append("where user_id = ? ");
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setInt(1, no);
               rs = pstmt.executeQuery();
               rs.next();
               return rs.getInt("allowance");
          } catch (SQLException e) {
               e.printStackTrace();
          } finally {
               DBUtil.getInstance().close(rs, pstmt, con);
          }
          return 0;
     }
     
     @Override
     public UserDto getUserByUserIdAndPassword(int userId, String password) {
          
          return null;
     }
     
     @Override
     public void modifyUser(UserDto userDto) {
     
     }
     
     @Override
     public void modifyMoney(int no, int money) {
          Connection con = null;
          PreparedStatement pstmt = null;
          int totalMoney = 0;
          try {
               con = DBUtil.getInstance().getConnection();
               con.setAutoCommit(false);
               StringBuilder sql = new StringBuilder("update user \n");
               sql.append("set allowance = allowance + ? \n");
               sql.append("where user_id = ?");
               pstmt = con.prepareStatement(sql.toString());
               pstmt.setInt(1, money);
               pstmt.setInt(2, no);
               pstmt.executeUpdate();
               con.commit();
          }catch(SQLException e){
               e.printStackTrace();
               try {
                    con.rollback();
               } catch (SQLException e1) {
                    e1.printStackTrace();
               }
          } finally {
               DBUtil.getInstance().close(pstmt, con);
          }
     }
     
     @Override
     public void deleteUser(int no) {
     
     }
}
