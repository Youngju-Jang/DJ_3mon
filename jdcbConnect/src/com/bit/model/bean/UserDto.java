package com.bit.model.bean;

public class UserDto{
     private int userId;
     private String username;
     private String password;
     private int allowance;
     public UserDto(String username, String password){
          this.username = username;
          this.password = password;
     }
     
     @Override
     public String toString() {
          return "UserDto{" +
               "userId=" + userId +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", allowance=" + allowance +
               '}';
     }
     
     public int getUserId() {
          return userId;
     }
     
     public void setUserId(int userId) {
          this.userId = userId;
     }
     
     public String getUsername() {
          return username;
     }
     
     public void setUsername(String username) {
          this.username = username;
     }
     
     public String getPassword() {
          return password;
     }
     
     public void setPassword(String password) {
          this.password = password;
     }
     
     public int getAllowance() {
          return allowance;
     }
     
     public void setAllowance(int allowance) {
          this.allowance = allowance;
     }
}
