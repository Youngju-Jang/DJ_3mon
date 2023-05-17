package com.bit.web.v3;

import com.bit.web.v3.model.ServerSystem;
import org.apache.logging.log4j.core.jmx.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@ComponentScan(basePackages = {"com.bit.web.v3"})
public class ServerSystemMain {
     public static void main(String[] args) {
          ApplicationContext applicationContext = new FileSystemXmlApplicationContext("/src/main/resources/dbms.xml");
          ServerSystem serverSystem = applicationContext.getBean("serverSystem", ServerSystem.class);
          serverSystem.test();
     }
}
