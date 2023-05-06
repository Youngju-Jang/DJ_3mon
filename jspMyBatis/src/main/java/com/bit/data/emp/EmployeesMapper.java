package com.bit.data.emp;

import com.bit.domain.emp.vo.Employees;

import java.util.List;

public interface EmployeesMapper {
     List<Employees> selectEmpList();
}
