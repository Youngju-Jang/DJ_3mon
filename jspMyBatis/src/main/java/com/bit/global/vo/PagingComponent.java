package com.bit.global.vo;

import com.bit.domain.board.dao.impl.BoardDaoImp;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class PagingComponent {
     
     public void pagingCreate(HttpServletRequest request) {
          HashMap<String, Object> map = new HashMap<>();
          String search = request.getParameter("search");
          String option = request.getParameter("option");
          if (search != null && option != null) {
               map.put("search", search);
               map.put("option", option);
          }
          
          int pageScale = 2;//보여줄 row
          int blockScale = 3;//  block count
          int currentPage = 1;
          int totalRow = 0;
          totalRow = BoardDaoImp.getBoardDao().countBoard(map);
          int totalPage = totalRow % pageScale == 0 ? (totalRow / pageScale) : (totalRow / pageScale) + 1;
          totalPage = totalPage == 0 ? 1 : totalPage;
          
          try {
               if (request.getParameter("page") != null) { // page 파라미터 있는채로 온경우에만
                    currentPage = Integer.parseInt(request.getParameter("page"));//현재 페이지
               }
          } catch (Exception e) {
               // TODO: handle exception
          }
          //currentPage = 1----> start=1    end=10
          //currentPage = 2----> start=11   end=20
          
          //처음페이지 이전 1 2 3 4 5 6 7 8 9  10 다음 마지막페이지
          //11 12 13 14 15 16 17 18 19  20
          //21 22 23 24 25
          //currentBlock=1   startPage=1   endPage=10
          //currentBlock=2   startPage=11   endPage=20
          //currentBlock=3   startPage=21   endPage=30
          int start = 1 + (currentPage - 1) * pageScale;
          int end = currentPage * pageScale;
          int currentBlock = currentPage % blockScale == 0 ? (currentPage / blockScale) : (currentPage / blockScale) + 1;
          int startPage = 1 + (currentBlock - 1) * blockScale;
          //int endPage=(pageScale+(currentBlock-1)*pageScale)>totalPage?totalPage:(pageScale+(currentBlock-1)*pageScale);
          int endPage = currentBlock * blockScale;
          if (endPage > totalPage) endPage = totalPage;
          
          request.setAttribute("pageBean", new PageBean(currentBlock, currentPage, totalPage, startPage, endPage, pageScale));
     }
}
