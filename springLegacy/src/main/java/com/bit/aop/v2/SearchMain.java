package com.bit.aop.v2;

import com.bit.aop.v2.service.Search;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SearchMain {
     public static void main(String[] args) {
          FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/bit/aop/v2/search.xml");
          Search search = context.getBean("adminSearch", Search.class);
          
          search.fileSearch();
          search.xmlParsing();
          search.domSaxSearch();
     }
}
