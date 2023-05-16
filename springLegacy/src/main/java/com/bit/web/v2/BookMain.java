package com.bit.web.v2;

import com.bit.web.v2.model.Book;
import com.bit.web.v2.model.BookStore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BookMain {
     public static void main(String[] args) {
          ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/BookConfig.xml");
          BookStore bookStore1 = applicationContext.getBean("bookStore", BookStore.class);
          System.out.println(bookStore1.getBook1());
     }
}
