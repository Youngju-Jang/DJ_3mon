package com.bit.web.v1;

import com.bit.web.v1.model.PersonCollection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PersonMain {
     public static void main(String[] args) {
          ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/appConfig.xml");
          PersonCollection pc1 = applicationContext.getBean("pc1", PersonCollection.class);
          Properties properties = pc1.getProperties();
          Set<Map.Entry<Object, Object>> entries = properties.entrySet();
          Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
          while(iterator.hasNext()){
               Map.Entry<Object, Object> entry = iterator.next();
               System.out.println(entry.getKey() + " : " + entry.getValue());
               System.out.println();
          }
     }
}