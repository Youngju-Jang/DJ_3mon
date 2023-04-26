package com.bit.dao;

import com.bit.model.EmpBean;

import java.util.ArrayList;
import java.util.List;

public class EmpDao {
     private static EmpDao dao;
     
     public static EmpDao getInstance(){
          if(dao==null){
               dao = new EmpDao();
          }
          return dao;
     }
     public List<EmpBean> selectEmpList(){
          ArrayList<EmpBean> list = new ArrayList<EmpBean>();
//          EmpBean(int empno, String ename, int sal, int mgr, int comm, String hiredate, int deptno) {
          list.add(new EmpBean(1, "jyj1", 200020, 3030, 499, "2022/04/03", 10));
          list.add(new EmpBean(2, "jyj2", 200003, 3030, 499, "2022/05/03", 12));
          list.add(new EmpBean(3, "jyj3", 202000, 3030, 499, "2022/02/03", 13));
          
          return list;
     }
}
