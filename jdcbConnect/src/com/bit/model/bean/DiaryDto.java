package com.bit.model.bean;

public class DiaryDto {
     private int diaryId;
     private int userId;
     private String date;
     private int expense;
     private String category;
     private String note;
     
     @Override
     public String toString() {
          return "DiaryDto{" +
               "diaryId=" + diaryId +
               ", userId=" + userId +
               ", date='" + date + '\'' +
               ", expense=" + expense +
               ", category='" + category + '\'' +
               ", note='" + note + '\'' +
               '}';
     }
     
     public int getDiaryId() {
          return diaryId;
     }
     
     public void setDiaryId(int diaryId) {
          this.diaryId = diaryId;
     }
     
     public int getUserId() {
          return userId;
     }
     
     public void setUserId(int userId) {
          this.userId = userId;
     }
     
     public String getDate() {
          return date;
     }
     
     public void setDate(String date) {
          this.date = date;
     }
     
     public int getExpense() {
          return expense;
     }
     
     public void setExpense(int expense) {
          this.expense = expense;
     }
     
     public String getCategory() {
          return category;
     }
     
     public void setCategory(String category) {
          this.category = category;
     }
     
     public String getNote() {
          return note;
     }
     
     public void setNote(String note) {
          this.note = note;
     }
}
