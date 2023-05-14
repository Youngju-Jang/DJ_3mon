package com.bit.domain.member.vo;

public class Member {
     private int no;
     private String name;
     private String hobby;
     private String today;
     
     public Member() {
     }
     
     public Member(String name, String hobby) {
          this.name = name;
          this.hobby = hobby;
     }
     
     public Member(int no, String name, String hobby, String today) {
          this.no = no;
          this.name = name;
          this.hobby = hobby;
          this.today = today;
     }
     
     public int getNo() {
          return no;
     }
     
     public void setNo(int no) {
          this.no = no;
     }
     
     public Member(int no, String name, String hobby) {
          this.no = no;
          this.name = name;
          this.hobby = hobby;
     }
     
     public Member(String name, String hobby, String today) {
          this.name = name;
          this.hobby = hobby;
          this.today = today;
     }
     
     public String getToday() {
          return today;
     }
     
     public void setToday(String today) {
          this.today = today;
     }
     
     public String getName() {
          return name;
     }
     
     public void setName(String name) {
          this.name = name;
     }
     
     public String getHobby() {
          return hobby;
     }
     
     public void setHobby(String hobby) {
          this.hobby = hobby;
     }
}
