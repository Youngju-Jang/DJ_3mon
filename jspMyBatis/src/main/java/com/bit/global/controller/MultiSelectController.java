package com.bit.global.controller;

import com.bit.domain.dept.service.DeptService;
import com.bit.domain.dept.service.impl.DeptServiceImpl;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;
import com.bit.domain.emp.service.EmpService;
import com.bit.domain.emp.service.impl.EmpServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;

public class MultiSelectController implements ProcessController {
     
     private String path;
     private boolean redirect;
     private EmpService empService = EmpServiceImp.getEmpService();
     private DeptService deptService = DeptServiceImpl.getDeptService();
     public MultiSelectController(String path, boolean redirect) {
          this.redirect = redirect;
          this.path = path;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          String table=request.getParameter("t");
          
//          Hashtable<String, Object>map=new Hashtable<String, Object>();
//          map.put("table", table);
//          request.setAttribute("list", MultiSelectServiceImp.getMultiSelectService().selectEmp(map));
          return new ForWardController(path, redirect);
     
     }
}
