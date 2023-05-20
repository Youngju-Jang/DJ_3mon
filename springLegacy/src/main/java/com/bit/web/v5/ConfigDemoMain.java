package com.bit.web.v5;

import com.bit.web.v5.conf.ConfigDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

public class ConfigDemoMain {
     public static void main(String[] args) {
          ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigDemo.class);
          System.out.println(applicationContext.getBean("stateServer"));
          
          System.out.println(applicationContext.getBean("getMap", Map.class));
          System.out.println(applicationContext.getBean("getProperties", Properties.class));
          System.out.println(applicationContext.getBean("person1"));
     }
}
