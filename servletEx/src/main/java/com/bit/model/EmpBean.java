package com.bit.model;

public class EmpBean {
     private int empno;
     private String ename;
     private int sal;
     private int mgr;
     private int comm;
     private String hiredate;
     private int deptno;
     
     public EmpBean() {
     }
     
     public int getEmpno() {
          return empno;
     }
     
     public EmpBean(int empno, String ename, int sal, int mgr, int comm, String hiredate, int deptno) {
          this.empno = empno;
          this.ename = ename;
          this.sal = sal;
          this.mgr = mgr;
          this.comm = comm;
          this.hiredate = hiredate;
          this.deptno = deptno;
     }
     
     public void setEmpno(int empno) {
          this.empno = empno;
     }
     
     public String getEname() {
          return ename;
     }
     
     public void setEname(String ename) {
          this.ename = ename;
     }
     
     public int getSal() {
          return sal;
     }
     
     public void setSal(int sal) {
          this.sal = sal;
     }
     
     public int getMgr() {
          return mgr;
     }
     
     public void setMgr(int mgr) {
          this.mgr = mgr;
     }
     
     public int getComm() {
          return comm;
     }
     
     public void setComm(int comm) {
          this.comm = comm;
     }
     
     public String getHiredate() {
          return hiredate;
     }
     
     public void setHiredate(String hiredate) {
          this.hiredate = hiredate;
     }
     
     public int getDeptno() {
          return deptno;
     }
     
     public void setDeptno(int deptno) {
          this.deptno = deptno;
     }
     
     @Override
     public String toString() {
          return "EmpBean{" +
               "empno=" + empno +
               ", ename='" + ename + '\'' +
               ", sal=" + sal +
               ", mgr=" + mgr +
               ", comm=" + comm +
               ", hiredate='" + hiredate + '\'' +
               ", deptno=" + deptno +
               '}';
     }
}
