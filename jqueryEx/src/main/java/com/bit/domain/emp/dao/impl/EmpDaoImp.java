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
               // DB와 연결할 세션객체 통해서, 설정된 employee매퍼객체 호출
               EmployeesMapper employeesMapper = sqlSession.getMapper(EmployeesMapper.class);
               // EmployeesMapper 에 등록한 emp list 불러오는 쿼리실행 메소드 호출
               // xml 파일에 등록된  resultType에 맞춰 Employees형태로 매핑된 결과값이 여러개이기 때문에 list로 리턴됨
               employeesList = employeesMapper.selectEmpList();
          }catch (Exception e){
               e.printStackTrace();
          }
          return employeesList;
     }
     
     @Override
     public Employees selectEmp(int empId) {
          Employees emp = null;
          
          try(SqlSession sqlSession = sqlSessionFactory.openSession()){
               // DB와 연결할 세션객체 통해서, 설정된 employee매퍼객체 호출
               EmployeesMapper employeesMapper = sqlSession.getMapper(EmployeesMapper.class);
               // EmployeesMapper 에 등록한 emp list 불러오는 쿼리실행 메소드 호출
               // xml 파일에 등록된  resultType에 맞춰 Employees형태로 매핑된 결과값이 여러개이기 때문에 list로 리턴됨
               emp = employeesMapper.selectEmp(empId);
          }catch (Exception e){
               e.printStackTrace();
          }
          return emp;
     }
}
