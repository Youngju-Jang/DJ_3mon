package com.bit.controller;

import com.bit.dao.EmpDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListController implements ProcessController{
     
     private String path;
     private boolean redirect;
     
     public ListController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
          request.setAttribute("empList", EmpDao.getInstance().selectEmpList());
          
          return new ForwardController(path, redirect);
     }
}
