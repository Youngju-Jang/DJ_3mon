package com.bit.domain.emp.dao.impl;


import com.bit.conf.SqlSessionManager;
import com.bit.data.emp.EmployeesMapper;
import com.bit.domain.emp.dao.EmpDao;
import com.bit.domain.emp.vo.Employees;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class EmpDaoImp implements EmpDao {
     
     private static final EmpDao empDao = new EmpDaoImp();
     private final SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
     public static EmpDao getEmpDao(){
          return empDao;
     }
     @Override
     public List<Employees> selectEmpList() {
          List<Employees> employeesList = null;
          
          try(SqlSession sqlSession = sqlSessionFactory.openSession()){
//               list = sqlSession.selectList("com.bit.data.emp.EmployeesMapper.selectEmpList");
               EmployeesMapper employeesMapper = sqlSession.getMapper(EmployeesMapper.class);
               employeesList = employeesMapper.selectEmpList();
          }catch (Exception e){
               e.printStackTrace();
          }
          return employeesList;
     }
}
