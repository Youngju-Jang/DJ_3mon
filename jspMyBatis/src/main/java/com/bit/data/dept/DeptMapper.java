package com.bit.data.dept;

import com.bit.domain.dept.vo.Departments;

import java.util.List;

public interface DeptMapper {
     List<Departments> selectDeptList();
}
