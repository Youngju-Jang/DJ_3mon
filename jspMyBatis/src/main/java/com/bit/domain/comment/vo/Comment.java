package com.bit.domain.comment.vo;

public class Comment {
     private int no;
     private int userId;
     private String content;
     private String regdate;
     
     private int ref; // 참조하는 원댓글 번호
     private int step; // ref별 순서
     private int lev; // 댓글 레벨
     private int parentNum; // parent number
     private int reply; // 댓글 갯수
     private int boardNo; // 참조 개시글 번호
     
     public void setByParent(Comment parent){
          this.ref = parent.getRef();
          this.step = parent.getStep() + 1;
          this.lev = parent.getLev() + 1;
          this.parentNum = parent.getNo();
     }
     
     public int getRef() {
          return ref;
     }
     
     public void setRef(int ref) {
          this.ref = ref;
     }
     
     public int getStep() {
          return step;
     }
     
     public void setStep(int step) {
          this.step = step;
     }
     
     public int getLev() {
          return lev;
     }
     
     public void setLev(int lev) {
          this.lev = lev;
     }
     
     public int getParentNum() {
          return parentNum;
     }
     
     public void setParentNum(int parentNum) {
          this.parentNum = parentNum;
     }
     
     public int getReply() {
          return reply;
     }
     
     public void setReply(int reply) {
          this.reply = reply;
     }
     
     public int getBoardNo() {
          return boardNo;
     }
     
     public void setBoardNo(int boardNo) {
          this.boardNo = boardNo;
     }
     
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
     
     public Comment(int userId, String content, int boardNo) {
          this.userId = userId;
          this.content = content;
          this.boardNo = boardNo;
     }
}
