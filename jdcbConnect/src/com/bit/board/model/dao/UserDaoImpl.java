package com.bit.board.model.dao;

import com.bit.model.bean.UserDto;

import java.util.List;

public class UserDaoImpl implements UserDao{
     private static UserDao userDao = new UserDaoImpl();
     public static UserDao getUserDao(){return userDao;}
     
     @Override
     public boolean registerUser(String username, String password) {
          return false;
     }
     
     @Override
     public boolean existsUser(String username) {
          return false;
     }
     
     @Override
     public List<UserDto> searchAllUser() {
          return null;
     }
     
     @Override
     public int showAllowance(int no) {
          return 0;
     }
     
     @Override
     public UserDto searchUserByNameAndPassword(String name, String password) {
          return null;
     }
     
     @Override
     public void modifyUser(UserDto userDto) {
     
     }
     
     @Override
     public int addMoney(int no, int money) {
          return 0;
     }
     
     @Override
     public int minusMoney(int no, int money) {
          return 0;
     }
     
     @Override
     public void deleteUser(int no) {
     
     }
}
