package com.bit.domain.dept.dao;

import com.bit.domain.dept.vo.Departments;

import java.util.List;

public interface DeptDao {
     public List<Departments> selectDeptList();
}
