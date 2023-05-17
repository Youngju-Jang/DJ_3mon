package com.bit.web.v4.dao.impl;

import com.bit.web.v4.dao.UserDao;
import org.springframework.stereotype.Component;

@Component
public class MyBatisDaoImpl implements UserDao {
     @Override
     public void selectAllUser() {
          System.out.println("MyBatisDaoImpl.selectAllUser");
     }
     
     @Override
     public void updateUser() {
          System.out.println("MyBatisDaoImpl.updaetUser");
     }
     
     @Override
     public void deleteUser() {
          System.out.println("MyBatisDaoImpl.deleteUser");
     }
}
