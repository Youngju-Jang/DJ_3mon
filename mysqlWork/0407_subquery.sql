use scott;

# 다중행임
select avg(sal)
from emp
group by DEPTNO;

select ename, SAL
from emp
where sal = (select avg(SAL) from emp group by DEPTNO);

-- 다중행일 경우
-- where SAL > 2916 and sal > 2175 and sal > 1566  : all
-- where sal > 2916 or sal > 2175 or sal > 1566 : any  =<>
-- where sal = 2916, or = 2175,or = 1566 : IN

# select 단일행, 복수행
# from EMP inner join (select * from EMP) A
# where SAL and or not
# group by
# HAVING

use bitdb;
select * from employees;

use scott;
select EMPNO, ename, sal, COMM
from emp join dept
using (deptno);

select EMPNO, ename, sal, comm, dname, loc, deptno
from emp e natural join dept d;

select sal from emp where deptno = 30;

select empno, ename, sal, COMM
from emp
where sal > any (select sal from emp where deptno = 30);

select empno, ename, sal, COMM
from emp
where sal < any (select sal from emp where deptno = 30);

select empno, ename, sal, COMM
from emp
where sal > all (select sal from emp where deptno = 30);

select empno, ename, sal, COMM
from emp
where sal < all (select sal from emp where deptno = 30);

select empno, ename, sal, COMM
from (select empno, ename, sal, COMM from emp where sal>=2500) A;

select @rownum:=@rownum+1 rownumber, e.*
from emp e, (select @rownum:=10) rownum;

use bitdb;

create table board
(
	article_no INT NOT NULL AUTO_INCREMENT primary key,
	user_id VARCHAR(16) NULL DEFAULT NULL,
    subject VARCHAR(100) NULL DEFAULT NULL,
    content VARCHAR(2000) NULL DEFAULT NULL,
    register_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
