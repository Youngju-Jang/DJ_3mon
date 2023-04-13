package com.bit.board;

import com.bit.model.bean.UserDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.bit.board.model.service.UserServiceImpl.getUserService;

public class DiaryMain {
     BufferedReader in;
     UserDto user;
     public DiaryMain(){
          in = new BufferedReader(new InputStreamReader(System.in));
          start();
     }
     // 로그인 / 회원가입 먼저
     private void start(){
          boolean isUser = false;
          do {
               try {
                    // 로그인 or 종료
                    System.out.println("---------- 용돈기입장 입니다. ----------");
                    System.out.println("1. 로그인");
                    System.out.println("2. 회원가입");
                    System.out.println("3. 종료");
                    int num = Integer.parseInt(in.readLine());
                    if(num==2){ // 회원가입
                         System.out.println("아이디 : ");
                         String username = in.readLine();
                         System.out.println("비밀번호");
                         String password = in.readLine();
                         if(!register(username, password)){
                              System.out.println("이미 존재하는 아이디입니다.");
                         }
                    }else if(num==1){// 로그인
                         // 로그인 정보
                         System.out.println("아이디 : ");
                         String username = in.readLine();
                         System.out.println("비밀번호");
                         String password = in.readLine();
                         // 회원여부 확인
                         isUser = checkUser(username, password);
                         if(!isUser){
                              System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
                         }else{
                              login(username, password);
                         }
                    }else {
                         System.exit(0);
                    }
                    
               } catch (IOException e) {
                    throw new RuntimeException(e);
               }
          }while (!isUser);
          menu();
     }
     
     // 메인 용돈기입장
     private void menu(){
     
     }
     private void login(String username, String password){
          // 전역
     }
     // 회원가입
     private boolean register(String username, String password){
          return getUserService().registerUser(username, password);
     }
     // 회원여부 확인
     private boolean checkUser(String username, String password){
          return false;
     }
     
     public static void main(String[] args) {
     
     }
}
