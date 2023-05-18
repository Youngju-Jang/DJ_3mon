package com.bit.aop.v1.dao.impl;

import com.bit.aop.v1.dao.Dao;

public class MySqlDao implements Dao {
     @Override
     public void update() {
          System.out.println("MySqlDao.update");
     }
     
     @Override
     public void select() {
          System.out.println("MySqlDao.select");
     }
}
