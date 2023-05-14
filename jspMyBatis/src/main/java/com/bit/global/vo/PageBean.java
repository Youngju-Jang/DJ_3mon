package com.bit.global.vo;

public class PageBean {
     private int currentBlock; // 1부터임
     private int currentPage;
     private int totalPage;
     private int startPage;
     private int endPage;
     private int pageScale;
     
     public int getCurrentBlock() {
          return currentBlock;
     }
     
     public void setCurrentBlock(int currentBlock) {
          this.currentBlock = currentBlock;
     }
     
     public int getCurrentPage() {
          return currentPage;
     }
     
     public void setCurrentPage(int currentPage) {
          this.currentPage = currentPage;
     }
     
     public int getTotalPage() {
          return totalPage;
     }
     
     public void setTotalPage(int totalPage) {
          this.totalPage = totalPage;
     }
     
     public int getStartPage() {
          return startPage;
     }
     
     public void setStartPage(int startPage) {
          this.startPage = startPage;
     }
     
     public int getEndPage() {
          return endPage;
     }
     
     public void setEndPage(int endPage) {
          this.endPage = endPage;
     }
     
     public int getPageScale() {
          return pageScale;
     }
     
     public void setPageScale(int pageScale) {
          this.pageScale = pageScale;
     }
     
     public PageBean() {
     }
     
     public PageBean(int currentBlock, int currentPage, int totalPage, int startPage, int endPage, int pageScale) {
          this.currentBlock = currentBlock;
          this.currentPage = currentPage;
          this.totalPage = totalPage;
          this.startPage = startPage;
          this.endPage = endPage;
          this.pageScale = pageScale;
     }
     
     @Override
     public String toString() {
          return "PageBean{" +
               "currentBlock=" + currentBlock +
               ", currentPage=" + currentPage +
               ", totalPage=" + totalPage +
               ", startPage=" + startPage +
               ", endPage=" + endPage +
               ", pageScale=" + pageScale +
               '}';
     }
}
