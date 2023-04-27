package com.bit.model;

public class BoardBean {
     private int no;
     private String writer;
     private String title;
     private String pass;
     private String contents;
     
     @Override
     public String toString() {
          return "BoardBean{" +
               "no=" + no +
               ", writer='" + writer + '\'' +
               ", title='" + title + '\'' +
               ", pass='" + pass + '\'' +
               ", contents='" + contents + '\'' +
               '}';
     }
     
     public int getNo() {
          return no;
     }
     
     public void setNo(int no) {
          this.no = no;
     }
     
     public String getWriter() {
          return writer;
     }
     
     public void setWriter(String writer) {
          this.writer = writer;
     }
     
     public String getTitle() {
          return title;
     }
     
     public void setTitle(String title) {
          this.title = title;
     }
     
     public String getPass() {
          return pass;
     }
     
     public void setPass(String pass) {
          this.pass = pass;
     }
     
     public String getContents() {
          return contents;
     }
     
     public void setContents(String contents) {
          this.contents = contents;
     }
}
