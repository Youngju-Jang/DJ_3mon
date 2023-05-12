package com.bit.global.vo;

import com.bit.domain.board.dao.impl.BoardDaoImp;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class PagingComponent {
     int pageScale = 2;//보여줄 row
     int blockScale = 3;//  block count
     int currentPage = 1;
     int totalRow = 0;
     public PageBean pagingCreate(int totalRow, int currentPage) {
          this.totalRow = totalRow;
          int totalPage = totalRow % pageScale == 0 ? (totalRow / pageScale) : (totalRow / pageScale) + 1;
          totalPage = totalPage == 0 ? 1 : totalPage;
          this.currentPage = currentPage;
          
//          int start = 1 + (currentPage - 1) * pageScale;
//          int end = currentPage * pageScale;
          int currentBlock = currentPage % blockScale == 0 ? (currentPage / blockScale) : (currentPage / blockScale) + 1;
          int startPage = 1 + (currentBlock - 1) * blockScale;
          int endPage = currentBlock * blockScale;
          if (endPage > totalPage) endPage = totalPage;
          
          return new PageBean(currentBlock, currentPage, totalPage, startPage, endPage, pageScale);
     }
}
