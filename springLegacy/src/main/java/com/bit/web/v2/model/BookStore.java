package com.bit.web.v2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@RequiredArgsConstructor
@Getter @Setter
@Component
public class BookStore {
     
//     @Inject
//     @Autowired
//     @Qualifier("book1")
//     private Book book;
     
     private final Book book1;
     
//     public void setBook(Book book){
//          this.book = book;
//     }

}
