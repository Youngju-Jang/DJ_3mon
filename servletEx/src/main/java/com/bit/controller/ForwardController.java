package com.bit.controller;

// DB까지 가는 코드
public class ForwardController {
     private String path;
     private boolean redirect;
     
     public ForwardController(String path, boolean redirect) {
          super();
          this.path = path;
          this.redirect = redirect;
     }
     
     public String getPath() {
          return path;
     }
     
     public void setPath(String path) {
          this.path = path;
     }
     
     public boolean isRedirect() {
          return redirect;
     }
     
     public void setRedirect(boolean redirect) {
          this.redirect = redirect;
     }
}
