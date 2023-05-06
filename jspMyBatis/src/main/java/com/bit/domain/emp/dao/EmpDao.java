package com.bit.domain.emp.dao;

import com.bit.domain.emp.vo.Employees;

import java.util.List;

public interface EmpDao {
     public List<Employees> selectEmpList();
}
