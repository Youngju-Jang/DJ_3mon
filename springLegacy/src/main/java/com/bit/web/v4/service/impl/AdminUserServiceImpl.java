package com.bit.web.v4.service.impl;

import com.bit.web.v4.dao.UserDao;
import com.bit.web.v4.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AdminUserServiceImpl implements UserService {
     
     @Resource(name = "myBatisDaoImpl")
     private UserDao dao;
     @Override
     public void register() {
          dao.selectAllUser();
     }
     
     @Override
     public void findUser() {
     
     }
}
