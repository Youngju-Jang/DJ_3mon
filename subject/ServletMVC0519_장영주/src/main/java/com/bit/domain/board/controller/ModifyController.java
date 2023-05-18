package com.bit.domain.board.controller;

import com.bit.domain.board.service.impl.BoardServiceImp;
import com.bit.domain.board.vo.Board;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class ModifyController implements ProcessController {
     private String path;
     private boolean redirect;
     
     public ModifyController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          int no = 0;
          int size = 10 * 1024 * 1024; // 10mb
          String uploadPath = "/Users/joj1043/Documents/bit/DJ_3mon/jspMyBatis/src/main/webapp/upload";
          System.out.println("_________________");
          try {
               MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
               
               Enumeration<String> e = multipartRequest.getFileNames();
               String file = e.nextElement();
               
               no = Integer.parseInt(multipartRequest.getParameter("no"));
               
               Board board = new Board(multipartRequest.getParameter("title"),
                    multipartRequest.getParameter("writer"),
                    multipartRequest.getParameter("password"),
                    multipartRequest.getParameter("contents"),
                    multipartRequest.getParameter("id"),
                    multipartRequest.getOriginalFileName(file));
               
               board.setNo(no);
               
               BoardServiceImp.getBoardService().updateBoard(board);
          } catch (Exception e) {
               e.printStackTrace();
          }
          System.out.println("no = " + no);
          path = "info.do?cmd=info&no=" + no + "&page=1&job=info";
          return new ForWardController(path, redirect);
     }
}
