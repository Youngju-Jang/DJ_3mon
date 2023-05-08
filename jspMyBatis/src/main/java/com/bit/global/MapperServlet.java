package com.bit.global;

import com.bit.domain.dept.controller.DeptController;
import com.bit.domain.emp.controller.EmpController;
import com.bit.domain.users.controller.LoginController;
import com.bit.global.controller.MultiSelectController;

public class MapperServlet {
     
     public static ProcessController getMapper(String cmd){
          ProcessController processController = null;
          if(cmd.equalsIgnoreCase("empList")){ // emp list 요청시 cmd = emp
               processController = new EmpController("/dbBase/empListView.jsp", false); //empListView.jsp 로 forward되도록 base 객체생성
          }
          if(cmd.equalsIgnoreCase("emp")){ // emp info 요청시 cmd = emp
               processController = new EmpController("/dbBase/empInfoView.jsp", false); //empListView.jsp 로 forward되도록 base 객체생성
          }
          if(cmd.equalsIgnoreCase("dept")){
               processController = new DeptController("/dbBase/deptView.jsp", false);
          }
          if(cmd.equalsIgnoreCase("login")){ // 로그인시 cmd = login
               processController = new LoginController("/dbBase/mIndex.jsp", false);
          }
          return processController;
     }
}
