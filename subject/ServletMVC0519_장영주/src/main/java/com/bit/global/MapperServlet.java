package com.bit.global;

import com.bit.domain.board.controller.*;
import com.bit.domain.comment.controller.InsertController;
import com.bit.domain.comment.controller.SelectController;
import com.bit.domain.users.controller.LoginController;

public class MapperServlet {
     
     public static ProcessController getMapper(String cmd){
          ProcessController processController = null;
          if(cmd.equalsIgnoreCase("login")){ // 로그인시 cmd = login
               processController = new LoginController("", false);
          }
          if(cmd.equalsIgnoreCase("listSelect")) {
               processController=new ListController("board.jsp", false);
          }
          if(cmd.equalsIgnoreCase("insertBoard")){
               processController = new InsertController("listSelect.do?cmd=listSelect", true);
          }
          if(cmd.equalsIgnoreCase("hit")){
               processController = new HitController("", true);
          }
          if(cmd.equalsIgnoreCase("info")){
               processController = new InfoController("", false);
          }
          if(cmd.equalsIgnoreCase("insertComment")){
               processController = new InsertController("/commentView.jsp", false);
          }
          if(cmd.equalsIgnoreCase("selectComment")){
               processController = new SelectController("/commentView.jsp", false);
          }
          if(cmd.equalsIgnoreCase("passCheck")){
               processController = new PasswordController("", false);
          }
          if (cmd.equalsIgnoreCase("modify")) {
               processController = new ModifyController("", true);
          }
          if (cmd.equalsIgnoreCase("deleteBoard")) {
               processController = new DeleteController("/listSelect.do?cmd=listSelect&page=1", true);
          }
          return processController;
     }
}
