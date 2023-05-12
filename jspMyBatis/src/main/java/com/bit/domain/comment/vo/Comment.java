package com.bit.domain.comment.vo;

public class Comment {
     private int no;
     private int userId;
     private String content;
     private String regdate;
     
     public int getNo() {
          return no;
     }
     
     public void setNo(int no) {
          this.no = no;
     }
     
     public int getUserId() {
          return userId;
     }
     
     public void setUserId(int userId) {
          this.userId = userId;
     }
     
     public String getContent() {
          return content;
     }
     
     public void setContent(String content) {
          this.content = content;
     }
     
     public String getRegdate() {
          return regdate;
     }
     
     public void setRegdate(String regdate) {
          this.regdate = regdate;
     }
     
     public Comment() {
     }
     
     public Comment(int userId, String content) {
          this.userId = userId;
          this.content = content;
     }
}
