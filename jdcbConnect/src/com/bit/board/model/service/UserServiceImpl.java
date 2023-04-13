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
          // 유저명 중복확인
          if(existsUser(username)) return false;
          // 회원가입
          getUserDao().registerUser(username, password);
          return true;
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
