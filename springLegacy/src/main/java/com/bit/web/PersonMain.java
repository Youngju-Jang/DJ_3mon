package com.bit.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PersonMain {
     public static void main(String[] args) {
          ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/person.xml");
          
     }
}
