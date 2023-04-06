use scott;

-- 사원번호, 사원이름, 연봉, 연봉등급, 부서이름, 전체평균연봉, 상사이름
select e1.EMPNO `사원번호`, e1.ENAME `사원이름`, e1.sal*12 `연봉`,  s.GRADE `연봉등급`,
d.DNAME `부서이름`, truncate(avg(e1.sal*12) over(),0) `전체평균연봉`, e2.ENAME `상사이름`
from emp e1
    left outer join emp e2
    on e1.MGR = e2.EMPNO
    join dept d
    on e1.DEPTNO = d.DEPTNO
    join salgrade s
    on e1.SAL between s.LOSAL and s.HISAL;

select E.EMPNO, E.ENAME, E.SAL, D.DNAME, M.ENAME MANAGER, S.GRADE, avg(E.sal) over()
from EMP E, dept D, EMP M, salgrade S
where E.DEPTNO = d.DEPTNO and e.MGR = m.EMPNO
    and e.SAL between s.LOSAL and s.HISAL;

select EMPNO, ENAME, SAL, GRADE
from emp E inner join salgrade S
on e.SAL between S.LOSAL and s.HISAL;

select * from emp;

select e1.EMPNO,e1.ENAME, e1.MGR, e2.ENAME
from emp e1 left outer join emp e2
on e1.MGR = e2.EMPNO;

select EMPNO, avg(sal)
from emp
group by EMPNO;

select EMPNO, rank() over()
from emp;

select EMPNO, avg(sal)
from emp;
