package com.bit.domain.dept.service.impl;

import com.bit.domain.dept.dao.impl.DeptDaoImp;
import com.bit.domain.dept.service.DeptService;
import com.bit.domain.dept.vo.Departments;

import java.util.List;

public class DeptServiceImpl implements DeptService {
     static DeptService deptService = new DeptServiceImpl();
     public static DeptService getDeptService(){
          return deptService;
     }
     @Override
     public List<Departments> selectDeptList() {
          return DeptDaoImp.getDeptdao().selectDeptList();
     }
}
