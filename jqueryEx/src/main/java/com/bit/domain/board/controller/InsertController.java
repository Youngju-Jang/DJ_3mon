package com.bit.domain.board.controller;

import com.bit.domain.board.service.BoardService;
import com.bit.domain.board.service.impl.BoardServiceImp;
import com.bit.domain.board.vo.Board;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class InsertController implements ProcessController {
     private String path;
     private boolean redirect;
     private BoardService boardService = BoardServiceImp.getBoardService();
     public InsertController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          // upload, insert
          int size = 10 * 1024 * 1024; // 10mb
          String uploadPath = "/Users/joj1043/Documents/bit/DJ_3mon/jqueryEx/src/main/webapp/upload";
          try {
               MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
               
               Enumeration e = multi.getFileNames();
               String file = (String)e.nextElement();
               
               Board board=new Board(multi.getParameter("title"),
                    multi.getParameter("writer"),
                    multi.getParameter("password"),
                    multi.getParameter("contents"),
                    multi.getParameter("id") ,
                    multi.getOriginalFileName(file));
               System.out.println("board password: " + board.getPassword());
               boardService.insertBoard(board);
          }catch (Exception e){
               e.printStackTrace();
          }
          return new ForWardController(path, redirect);
     }
}
