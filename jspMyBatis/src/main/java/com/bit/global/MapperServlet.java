package com.bit.global;

import com.bit.domain.board.controller.*;
import com.bit.domain.comment.controller.InsertController;
import com.bit.domain.comment.controller.SelectController;
import com.bit.domain.dept.controller.DeptController;
import com.bit.domain.emp.controller.EmpController;
import com.bit.domain.member.controller.MemberAppController;
import com.bit.domain.users.controller.LoginController;

public class MapperServlet {
     
     public static ProcessController getMapper(String cmd){
          ProcessController processController = null;
          if(cmd.equalsIgnoreCase("empList")){ // emp list 요청시 cmd = emp
               processController = new EmpController("/jsp/empListView.jsp", false); //empListView.jsp 로 forward되도록 base 객체생성
          }
          if(cmd.equalsIgnoreCase("emp")){ // emp info 요청시 cmd = emp
               processController = new EmpController("/jsp/empInfoView.jsp", false); //empListView.jsp 로 forward되도록 base 객체생성
          }
          if(cmd.equalsIgnoreCase("dept")){
               processController = new DeptController("/jsp/deptView.jsp", false);
          }
          if(cmd.equalsIgnoreCase("login")){ // 로그인시 cmd = login
               processController = new LoginController("", false);
          }
          if(cmd.equalsIgnoreCase("listSelect")) {
               processController=new ListController("jsp/list.jsp", false);
          }
          if(cmd.equalsIgnoreCase("insertBoard")){
               processController = new com.bit.domain.board.controller.InsertController("listSelect.do?cmd=listSelect", true);
          }
          if(cmd.equalsIgnoreCase("hit")){
               processController = new HitController("", true);
          }
          if(cmd.equalsIgnoreCase("info")){
               processController = new InfoController("", false);
          }
          if(cmd.equalsIgnoreCase("memberApp")){
               processController = new MemberAppController("/ajaxMvc/ajaxApp1/ajaxView.jsp", false);
          }
          if(cmd.equalsIgnoreCase("insertComment")){
               processController = new InsertController("jsp/commentView.jsp", false);
          }
          if(cmd.equalsIgnoreCase("selectComment")){
               processController = new SelectController("jsp/commentView.jsp", false);
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
