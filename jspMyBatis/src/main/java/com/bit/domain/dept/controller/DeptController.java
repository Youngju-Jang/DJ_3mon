package com.bit.domain.dept.controller;

import com.bit.domain.dept.service.DeptService;
import com.bit.domain.dept.service.impl.DeptServiceImpl;
import com.bit.domain.emp.service.EmpService;
import com.bit.domain.emp.service.impl.EmpServiceImp;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptController implements ProcessController {
     
     private String path;
     private boolean redirect;
     
     private DeptService deptService = DeptServiceImpl.getDeptService();
     public DeptController(String path, boolean redirect) {
          this.redirect = redirect;
          this.path = path;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          request.setAttribute("list", deptService.selectDeptList());
          return new ForWardController(path, redirect);
     }
}
