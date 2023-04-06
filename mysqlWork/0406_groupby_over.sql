use scott;

select count(SAL) from emp;
select count(COMM) from emp;

select DEPTNO, EMPNO, count(SAL) over(order by EMPNO desc ) from emp;

select * from emp;
select * from dept;
select * from salgrade;

select *
from emp join dept d on emp.DEPTNO = d.DEPTNO
join salgrade;

select EMPNO, ENAME, SAL, COMM, avg(SAL) over(order by EMPNO asc), 0 avg
from emp;

select EMPNO, ENAME, SAL, COMM,job, count(SAL) over(partition by job order by EMPNO asc) avg
from emp;

select EMPNO, ENAME, comm,SAL,
       rank() over (order by sal desc) RK,
       dense_rank() over (order by sal desc) DRK,
       row_number() over(order by sal desc) drk
from emp;

select deptno, sal, row_number() over(partition by deptno order by sal desc) drk
from emp;


select avg(sal)
from emp;

select EMPNO, ENAME, COMM, sal,
       case
              when 800 <= sal and sal < 1500 then 'C'
              when 1500 <= sal and sal < 3000 then 'B'
              when 3000 <= sal then 'A'
              else 'F'
       end grade
from emp;

select EMPNO, ENAME, COMM, sal,
       case
              when sal between 800 and 1400 then 'C' # 이상이하
              when sal between 1401 and 3000 then 'B'
              else 'A'
       end grade
from emp;

select EMPNO, ENAME, SAL, COMM, ntile(2) over (order by sal desc)
from emp;

select EMPNO, ENAME, COMM, SAL,DEPTNO, ntile(3) over (partition by DEPTNO order by sal desc) 'ntile'
from emp;

select EMPNO, ENAME, JOB, MGR, e.SAL, s.GRADE, s.LOSAL, s.HISAL
from emp e, salgrade s
where e.SAL between s.LOSAL and s.HISAL;

select * from emp;
select * from salgrade;

select DEPTNO, JOB, COUNT(SAL), min(SAL), max(SAL)
from emp
group by DEPTNO, JOB;

-- JOIN SUBQUERY

select e1.EMPNO, e1.ENAME, e1.MGR, e2.ENAME
from emp e1, emp e2
where e1.MGR = e2.EMPNO;
