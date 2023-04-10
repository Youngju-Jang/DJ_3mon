package com.bit.board;

import com.bit.board.model.service.BoardServiceImpl;
import com.bit.model.bean.BoardDto;
import com.bit.util.DBUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static com.bit.board.model.service.BoardServiceImpl.getBoardService;

public class BoardMain {
     BufferedReader in;
     
     public BoardMain() {
          in = new BufferedReader(new InputStreamReader(System.in));
          menu();
     }
     
     private void menu() {
          while (true) {
               System.out.println("---------- 게시판 메뉴 ----------");
               System.out.println("1. 글등록");
               System.out.println("2. 글목록(전체)");
               System.out.println("3. 글검색(제목)");
               System.out.println("4. 글보기");
               System.out.println("5. 글수정");
               System.out.println("6. 글삭제");
               System.out.println("-------------------------------------");
               System.out.println("0. 프로그램 종료");
               System.out.println("-------------------------------------");
               System.out.print("메뉴 선택 : ");
               try {
                    int num = Integer.parseInt(in.readLine());
                    switch (num) {
                         case 1:
                              registerArticle();
                              break;
                         case 2:
                              searchListAll();
                              break;
                         case 3:
                              searchListBySubject();
                              break;
                         case 4:
                              viewArticle();
                              break;
                         case 5:
                              modifyArticle();
                              break;
                         case 6:
                              deleteArticle();
                              break;
                         default:
                              System.exit(0);
                    }
               } catch (Exception e) {
                    e.printStackTrace();
               }
          }
     }
     
     private void registerArticle() throws Exception {
          BoardDto boardDto = new BoardDto();
          System.out.println("=======글목록======");
          System.out.println("제목");
          boardDto.setSubject(in.readLine());
          
          System.out.println("내용");
          boardDto.setContent(in.readLine());
          
          System.out.println("아이디");
          boardDto.setUserId(in.readLine());
          
          getBoardService().registerArticle(boardDto);
     }
     
     private void searchListAll() {
          List<BoardDto> list = getBoardService().searchListAll();
          System.out.println("글 목록 --------------");
          for(BoardDto article : list){
               System.out.println(article);
          }
     }
     // 글 검색
     private void searchListBySubject() throws Exception {
          System.out.println("제목 검색어:  --------------");
          List<BoardDto> list = getBoardService().searchListBySubject(in.readLine());
          System.out.println("글 목록 --------------");
          if(list.size()==0) return;
          for(BoardDto article: list){
               System.out.println(article);
          }
     }
     // 글 보기
     private void viewArticle() throws Exception {
          System.out.println("글 번호 : ");
          System.out.println(BoardServiceImpl.getBoardService().viewArticle(Integer.parseInt(in.readLine())));
     }
     
     private void modifyArticle() throws Exception {
          BoardDto boardDto = new BoardDto();
          System.out.print("수정 할 글번호 : ");
          boardDto.setArticleNo(Integer.parseInt(in.readLine()));
          System.out.print("수정 제목 : ");
          boardDto.setSubject(in.readLine());
          System.out.print("수정 내용 : ");
          boardDto.setContent(in.readLine());
          BoardServiceImpl.getBoardService().modifyArticle(boardDto);
     }
     private void deleteArticle()throws Exception{
          System.out.print("삭제 할 글번호 : ");
          int no = Integer.parseInt(in.readLine());
          BoardServiceImpl.getBoardService().deleteArticle(no);
     }
     public static void main(String[] args) {
          try {
               System.out.println(DBUtil.getInstance().getConnection());
          } catch (Exception e) {
               // TODO: handle exception
               e.printStackTrace();
          }
          BoardMain b = new BoardMain();
          b.menu();
     }
     
}
