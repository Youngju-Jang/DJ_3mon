package com.bit.board;

import com.bit.model.bean.DiaryDto;
import com.bit.model.bean.UserDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static com.bit.board.model.service.DiaryServiceImpl.getDiaryService;
import static com.bit.board.model.service.UserServiceImpl.getUserService;

public class DiaryMain {
     BufferedReader in;
     UserDto user = null;
     public DiaryMain(){
          in = new BufferedReader(new InputStreamReader(System.in));
          start();
     }
     // 로그인 / 회원가입 먼저
     private void start(){
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
                         }else System.out.println(username +"님 회원가입 되었습니다.");
                         
                    }else if(num==1){// 로그인
                         // 로그인 정보
                         System.out.println("아이디 : ");
                         String username = in.readLine();
                         System.out.println("비밀번호");
                         String password = in.readLine();
                         UserDto tmp = getUserByName(username);
                         if(tmp == null){
                              System.out.println("존재하지 않는 아이디입니다.");
                         }else{
                              if(tmp.getPassword().equals(password)){
                                   user = tmp;
                              }else {
                                   System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
                              }
                         }
                    }else {
                         System.exit(0);
                    }
                    
               } catch (IOException e) {
                    throw new RuntimeException(e);
               }
          }while (user==null);
          menu();
     }
     
     // 메인 용돈기입장
     private void menu(){
          while(true){
               System.out.println("용돈기입장 메뉴");
               System.out.println("1. 수입 입력");
               System.out.println("2. 지출 입력");
               System.out.println("3. 월별 내역보기");
               System.out.println("4. 현재 잔액 확인");
               System.out.println("0. 프로그램 종료");
               try{
                    int num = Integer.parseInt(in.readLine());
                    switch(num){
                         case 1:
                              increase();
                              break;
                         case 2:
                              decrease();
                              break;
                         case 3:
                              showMonthList();
                              break;
                         case 4:
                              showAllowance();
                              break;
                         default:
                              System.exit(0);
                    }
               } catch (IOException e) {
                    e.printStackTrace();
               }
          }
     }
     
     private void showAllowance() throws IOException{
          int allowance = getUserService().showAllowance(user.getUserId());
          System.out.println(user.getUsername() + "님의 현재 잔액은 "+ allowance + "원 입니다.");
     }
     
     private void showMonthList() throws IOException{
          System.out.println("======원하는 년, 월의 용돈기입 리스트======");
          System.out.println("원하는 년 (ex 2023년: 2023) : ");
          int year = Integer.parseInt(in.readLine());
          System.out.println("원하는 월 (ex 1월: 1) : ");
          int month = Integer.parseInt(in.readLine());
          List<DiaryDto> diaryDtoList = getDiaryService().getRecordByMonthAndYear(user.getUserId(), year, month);
          System.out.println(user.getUsername()+"님의 " + year +"년 " + month + "월 용돈기입 목록 ");
          for(DiaryDto diary : diaryDtoList){
               System.out.println(diary);
          }
     }
     
     private void decrease() throws IOException{
          DiaryDto diaryDto = new DiaryDto();
          System.out.println("======지출한 용돈 정보======");
          System.out.println("날짜 (ex.2000-01-01) : ");
          diaryDto.setDate(in.readLine());
          
          System.out.println("사용한 용돈 금액 : ");
          diaryDto.setExpense(-Integer.parseInt(in.readLine()));
          
          System.out.println("지출 카테고리 : ");
          diaryDto.setCategory(in.readLine());
          
          System.out.println("기록사항 : ");
          diaryDto.setNote(in.readLine());
          
          diaryDto.setUserId(user.getUserId());
          
          getDiaryService().writeDiary(diaryDto);
     }
     private void increase() throws IOException {
          DiaryDto diaryDto = new DiaryDto();
          System.out.println("======받은 용돈 정보======");
          System.out.println("날짜 (ex.2000-01-01) : ");
          diaryDto.setDate(in.readLine());
          
          System.out.println("받은 용돈 금액 : ");
          diaryDto.setExpense(Integer.parseInt(in.readLine()));
          
          System.out.println("용돈 카테고리 : ");
          diaryDto.setCategory(in.readLine());
          
          System.out.println("기록사항 : ");
          diaryDto.setNote(in.readLine());
          
          diaryDto.setUserId(user.getUserId());
          
          getDiaryService().writeDiary(diaryDto);
     }
     
     // 회원가입
     private boolean register(String username, String password){
          return getUserService().registerUser(username, password);
     }
     // 회원여부 확인
     private UserDto getUserByName(String username){
          return getUserService().getUserByUsername(username);
     }
     
     public static void main(String[] args) {
          DiaryMain d = new DiaryMain();
     }
}
