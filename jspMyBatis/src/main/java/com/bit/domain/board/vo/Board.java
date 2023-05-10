package com.bit.domain.board.vo;

public class Board {
     private int no;
     private String title;
     private String writer;
     private String password;
     private String contents;
     private String id;
     private int hit;
     private String fileName;
     private String regdate;
     
     public int getNo() {
          return no;
     }
     
     public void setNo(int no) {
          this.no = no;
     }
     
     public String getTitle() {
          return title;
     }
     
     public void setTitle(String title) {
          this.title = title;
     }
     
     public String getWriter() {
          return writer;
     }
     
     public void setWriter(String writer) {
          this.writer = writer;
     }
     
     public String getPassword() {
          return password;
     }
     
     public void setPassword(String password) {
          this.password = password;
     }
     
     public String getContents() {
          return contents;
     }
     
     public void setContents(String contents) {
          this.contents = contents;
     }
     
     public String getId() {
          return id;
     }
     
     public void setId(String id) {
          this.id = id;
     }
     
     public int getHit() {
          return hit;
     }
     
     public void setHit(int hit) {
          this.hit = hit;
     }
     
     public String getFileName() {
          return fileName;
     }
     
     public void setFileName(String fileName) {
          this.fileName = fileName;
     }
     
     public String getRegdate() {
          return regdate;
     }
     
     public void setRegdate(String regdate) {
          this.regdate = regdate;
     }
     
     public Board(String title, String writer, String password, String contents, String id, String fileName) {
          this.title = title;
          this.writer = writer;
          this.password = password;
          this.contents = contents;
          this.id = id;
          this.fileName = fileName;
     }
     
     public Board() {
     }
     
     @Override
     public String toString() {
          return "Board{" +
               "no=" + no +
               ", title='" + title + '\'' +
               ", writer='" + writer + '\'' +
               ", password='" + password + '\'' +
               ", contents='" + contents + '\'' +
               ", id='" + id + '\'' +
               ", hit=" + hit +
               ", fileName='" + fileName + '\'' +
               ", regdate='" + regdate + '\'' +
               '}';
     }
}
