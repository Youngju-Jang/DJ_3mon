package com.bit.domain.emp.service.impl;

import com.bit.domain.emp.dao.impl.EmpDaoImp;
import com.bit.domain.emp.service.EmpService;
import com.bit.domain.emp.vo.Employees;

import java.util.List;

public class EmpServiceImp implements EmpService {
     
     static EmpService empService = new EmpServiceImp();
     
     public static EmpService getEmpService(){
          return empService;
     }
     
     @Override
     public List<Employees> selectEmpList() {
          // DAO 단에서 DB정보 들고오도록 메소드 호출
          return EmpDaoImp.getEmpDao().selectEmpList();
     }
     
     @Override
     public Employees selectEmp(int empId) {
          return EmpDaoImp.getEmpDao().selectEmp(empId);
     }
}
