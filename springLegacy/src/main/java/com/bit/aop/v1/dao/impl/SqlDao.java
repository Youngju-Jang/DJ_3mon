package com.bit.aop.v1.dao.impl;

import com.bit.aop.v1.dao.Dao;
import org.springframework.stereotype.Component;

@Component
public class SqlDao implements Dao {
     @Override
     public void update() {
          System.out.println("SqlDao.update");
     }
     
     @Override
     public void select() {
          System.out.println("SqlDao.select");
     }
}
