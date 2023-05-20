package com.bit.web.v4.dao.impl;

import com.bit.web.v4.dao.UserDao;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl implements UserDao {
     @Override
     public void selectAllUser() {
          System.out.println("JdbcDaoImpl.selectAllUser");
     }
     
     @Override
     public void updateUser() {
          System.out.println("JdbcDaoImpl.updaetUser");
     }
     
     @Override
     public void deleteUser() {
          System.out.println("JdbcDaoImpl.deleteUser");
     }
}
