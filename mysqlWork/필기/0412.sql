use SCOTT;

select *
from information_schema.TABLE_CONSTRAINTS
where TABLE_NAME in ('emp', 'empcp1', 'empcp2');

select *
from EMP;

create table empcp1
as
    select * from emp; # table 복사시 제약사항은 복사가 안됨

create table empcp2
    as select * from emp where SAL=-1; # 구조만 복사하기


select * from empcp1;

create view view_emp1
as select * from empcp1
where sal>=3000
with check option;
select * from empcp1 where ENAME='Scott';
select * from view_emp1 ;
update empcp1 set sal=1000 where ENAME='SCOTT';


update view_emp1 set sal=1000 where ENAME='scott';
#[HY000][1369] CHECK OPTION failed 'scott.view_emp1'

select * from information_schema.VIEWS where TABLE_NAME in ('DEPTCP1', 'VIEW_DEPT1','VIEW_DEPT2'); # view 조회
create table DEPTCP1
as select * from DEPT;

create or replace  view VIEW_DEPT1
as select * from DEPTCP1
where DEPTNO >= 20;

create or replace  view VIEW_DEPT2
as select * from DEPTCP1
where DEPTNO >= 20
With check option ;


update VIEW_DEPT1 set DEPTNO=10 where DEPTNO=20;
select * from VIEW_DEPT1;
select * from VIEW_DEPT2;
select * from DEPTCP1;

create or replace  view GVIEW
as
    select  DEPTNO, max(sal) MX
from EMP
group by DEPTNO;

select * from GVIEW;

insert into GVIEW ;

select @@autocommit;
set autocommit = false;

create table ACTION(
    NO int primary key ,
    MSG varchar(20)
);
insert into ACTION values (1, 'JAVA');
commit ; # 1차 커밋
delete from ACTION;
select * from action;
rollback ; # 1차커밋 직후까지 되돌림

create table ACTION2(
    NO int primary key ,
    MM varchar(20)
);
rollback ;

create or replace view view_e
as select DEPTNO, max(sal) m
from EMP
group by  DEPTNO;

select * from view_e;

delete from view_e
where DEPTNO = 10;

create or replace view view_joinMP
as select EMPNO, ename, sal, comm, DNAME, max(sal) over()
from emp e inner join dept d
on e.DEPTNO = d.DEPTNO;

select * from view_joinMP;

update view_joinMP set sal = 3000 where EMPNO  = 7782;
select * from EMP where EMPNO=7782;
