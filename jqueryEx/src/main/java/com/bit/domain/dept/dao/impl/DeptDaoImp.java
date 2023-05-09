package com.bit.domain.dept.dao.impl;

import com.bit.conf.SqlSessionManager;
import com.bit.data.dept.DeptMapper;
import com.bit.domain.dept.dao.DeptDao;
import com.bit.domain.dept.vo.Departments;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DeptDaoImp implements DeptDao {
     
     private static final DeptDao deptdao = new DeptDaoImp();
     private final SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
     public static DeptDao getDeptdao(){
          return deptdao;
     }
     @Override
     public List<Departments> selectDeptList() {
          List<Departments> departmentsList = null;
          
          try(SqlSession sqlSession = sqlSessionFactory.openSession()){
               DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
               departmentsList = deptMapper.selectDeptList();
          }catch (Exception e){
               e.printStackTrace();
          }
          return departmentsList;
     }
}
