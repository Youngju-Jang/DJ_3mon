package com.bit.web.v4;

import com.bit.web.v4.service.UserService;
import com.bit.web.v4.service.impl.AdminUserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ControllerServiceMain {
     public static void main(String[] args) {
          ApplicationContext applicationContext=new FileSystemXmlApplicationContext("src/main/java/com/bit/web/v4/service.xml");
          UserService service = applicationContext.getBean("adminUserServiceImpl", AdminUserServiceImpl.class);
          service.register();
     }
}
