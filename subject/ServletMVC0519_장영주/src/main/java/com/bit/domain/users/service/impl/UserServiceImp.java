package com.bit.domain.users.service.impl;

import com.bit.domain.users.dao.impl.UserDaoImp;
import com.bit.domain.users.service.UserService;
import com.bit.domain.users.vo.User;

public class UserServiceImp implements UserService {
     
     static UserService userService = new UserServiceImp();
     public static UserService getUserService(){
          return userService;
     }
     @Override
     public User selectUser(String name) {
          // DAO 메소드 실행하여 디비정보 불러오기
          return UserDaoImp.getUserDao().selectUser(name);
     }
}
