package com.bit.global.vo;

public class Page {
     public int page = 1 ;
     public int pageSize = 5;
     
     public Page() {
     }
     
     public Page(int page) {
          this.page = page;
     }
     
     public Page(int page, int pageSize) {
          this.page = page;
          this.pageSize = pageSize;
     }
     
     public int getPage() {
          return page;
     }
     
     public void setPage(int page) {
          this.page = page;
     }
     
     public int getPageSize() {
          return pageSize;
     }
     
     public void setPageSize(int pageSize) {
          this.pageSize = pageSize;
     }
}
