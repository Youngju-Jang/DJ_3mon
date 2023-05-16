package com.bit.web.v1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Person {
     private String name;
     private int age;
     private String address;
     public void initPerson(){
          System.out.println("initPerson");
     }
     public void destroyPerson(){
          System.out.println("destroyPerson");
     }
     public Person(String name){
          this.name = name;
     }
     
     public Person(String name, int age){
          this.name = name;
          this.age = age;
     }
     
     public Person(String name, int age, String address) {
          this.name = name;
          this.age = age;
          this.address = address;
     }
}
