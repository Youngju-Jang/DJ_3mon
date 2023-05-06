package com.bit.domain.emp.controller;

import com.bit.domain.dept.service.DeptService;
import com.bit.domain.dept.service.impl.DeptServiceImpl;
import com.bit.domain.emp.service.EmpService;
import com.bit.domain.emp.service.impl.EmpServiceImp;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpController implements ProcessController {
     
     private String path;
     private boolean redirect;
     private EmpService empService = EmpServiceImp.getEmpService();
     public EmpController(String path, boolean redirect) {
          this.redirect = redirect;
          this.path = path;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
//          Hashtable<String, Object>map=new Hashtable<String, Object>();
//          map.put("table", table);
//          request.setAttribute("list", MultiSelectServiceImp.getMultiSelectService().selectEmp(map));
          request.setAttribute("list", empService.selectEmpList());
          return new ForWardController(path, redirect);
     }
}
