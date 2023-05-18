package com.bit.aop.v1;

import com.bit.aop.v1.dao.Dao;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DaoMain {
     public static void main(String[] args) {
          FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/bit/aop/v1/dao.xml");
          Dao dao = context.getBean("oracleDao", Dao.class);
          Dao sqlDao = context.getBean("sqlDao", Dao.class);
          dao.select();
          sqlDao.select();
     }
}
