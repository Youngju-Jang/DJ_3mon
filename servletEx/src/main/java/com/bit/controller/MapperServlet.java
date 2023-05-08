package com.bit.controller;

public class MapperServlet {
     
     public static ProcessController getMapper(String cmd) {
          ProcessController processController=null;
          if(cmd.equalsIgnoreCase("login")) {
               processController=new LoginController("", true);
          }
          if(cmd.equalsIgnoreCase("list")) {
               processController=new ListController("jspMvc/list.jsp", false);
          }
          if(cmd.equals("cookie")) {
               processController=new CookieController("cookieMVC/cookieLogin.jsp", true);
          }
          return processController;
     }

}
