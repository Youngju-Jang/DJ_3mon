package com.bit.web.v2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Book {
     private String author;
     private int price;
     private String publisher;
     private String title;
}
