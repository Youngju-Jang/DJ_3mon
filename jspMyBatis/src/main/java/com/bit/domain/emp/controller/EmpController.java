package com.bit.domain.emp.controller;

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
          // 서비스단의 비즈니스 로직수행되도록 메소드 호출
          String empId = request.getParameter("empId");
          if (empId != null) { // empId가 존재하는 경우 = Emp info 요청시
               request.setAttribute("emp", empService.selectEmp(Integer.parseInt(empId)));
          }else{ // emp list 요청시
               request.setAttribute("list", empService.selectEmpList());
          }
          return new ForWardController(path, redirect);
     }
}
