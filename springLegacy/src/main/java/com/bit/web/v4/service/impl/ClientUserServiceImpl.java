package com.bit.web.v4.service.impl;

import com.bit.web.v4.dao.UserDao;
import com.bit.web.v4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ClientUserServiceImpl implements UserService {
     @Resource(name = "jpaDaoImpl")
     private UserDao dao;
     @Override
     public void register() {
          dao.selectAllUser();
     }
     
     @Override
     public void findUser() {
          System.out.println("ClientUserServiceImpl.findUser");
     }
}
