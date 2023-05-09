package com.bit.data.emp;

import com.bit.domain.emp.vo.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeesMapper {
     List<Employees> selectEmpList();
     
     Employees selectEmp(@Param("empId") int empId);
}
