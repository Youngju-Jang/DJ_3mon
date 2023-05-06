package com.bit.global;

import com.bit.global.controller.MultiSelectController;

public class MapperServlet {
     
     public static ProcessController getMapper(String cmd){
          ProcessController processController = null;
          if(cmd.equalsIgnoreCase("emp")){
               processController = new MultiSelectController("/dbBase/empView.jsp", false);
          }
          if(cmd.equalsIgnoreCase("dept")){
               processController = new MultiSelectController("/dbBase/deptView.jsp", false);
          }
          return processController;
     }
}
