package com.bit.board;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
				
				default:
					System.exit(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void registerArticle() throws Exception {
		//BoardDto boardDto = new BoardDto();
		
	}
	
	public static void main(String[] args) {
		BoardMain b = new BoardMain();
		b.menu();
	}

}
