package com.bit.board.model.service;

import com.bit.model.bean.UserDto;

import java.util.List;

import static com.bit.board.model.dao.UserDaoImpl.getUserDao;

public class UserServiceImpl implements UserService{
     private static UserService userService = new UserServiceImpl();
     public static UserService getUserService(){
          return userService;
     }
     @Override
     public boolean registerUser(String username, String password) {
          // 유저명 중복시 불가
          if(getUserId(username)!=0) return false;
          // 회원가입
          return getUserDao().registerUser(username, password);
     }
     
     @Override
     public UserDto getUserByUsername(String username) {
          return getUserDao().getUserByUsername(username);
     }
     
     @Override // 유저명 중복확인
     public int getUserId(String username) {
          return getUserDao().getUserId(username);
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
     public UserDto getUserByUserIdAndPassword(int userId, String password) {
          return getUserDao().getUserByUserIdAndPassword(userId, password);
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
