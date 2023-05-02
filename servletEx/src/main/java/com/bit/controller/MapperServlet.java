package com.bit.controller;

public class MapperServlet {
     
     public static ProcessController getMapper(String cmd){
          ProcessController processController = null;
          if(cmd.equalsIgnoreCase("login")){
               processController = new LoginController("cookieLogin2.jsp", true);
          }
          if(cmd.equalsIgnoreCase("list")){
               processController = new ListController("jspMvc/list.jsp", false);
          }
          if(cmd.equalsIgnoreCase("cookie")){
               processController = new CookieController("cookie/cookieLogin3.jsp", false);
          }
          return processController;
     }
}
