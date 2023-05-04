package com.bit.global;

import com.bit.domain.dept.controller.DeptController;
import com.bit.domain.emp.controller.EmpController;
import com.bit.global.controller.MultiSelectController;

public class MapperServlet {
     
     public static ProcessController getMapper(String cmd){
          ProcessController processController = null;
          if(cmd.equalsIgnoreCase("emp")){
               processController = new EmpController("/dbBase/empView.jsp", false);
          }
          if(cmd.equalsIgnoreCase("dept")){
               processController = new DeptController("/dbBase/deptView.jsp", false);
          }
          return processController;
     }
}
