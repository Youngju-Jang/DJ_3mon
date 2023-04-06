use scott;
--  돌발질문 1 : 10번 부서 소속 사원중에서 커미션을 받는 사원의 수
select count(comm)
from emp
where deptno = 10;


-- 1. 업이 salesman이 아닌 사원들의 이름, 월급,커미션,월급+커미션을 출력하시요
select ename '이름', sal '월급', comm '커미션', sal+ifnull(comm, 0) '월급+커미션'
from emp
where job != 'salesman';

-- 2. 직업, 직업별 토탈월급을 출력하는데, 직업별 토탈월급이 4000이상인것만 출력하시오
select job '직업', sum(sal) '직업별 토탈월급'
from emp
group by job
having sum(sal) >4000;

-- 3. 최대월급을 받는 사원의 이름과 월급을 출력하시요
select ename, sal
from emp
where sal = (select max(sal) from emp );

select ename, SAL
from emp
where sal in (select max(sal) from emp group by DEPTNO) ;
-- 4. 입사동기별 최대연봉을 받는 사람의 정보 출력
select e.*
from emp e
join (select max(sal) maxsal, date_format(HIREDATE, '%Y') donggi
    from emp
    group by donggi) t
on date_format(e.HIREDATE, '%Y') = t.donggi
where e.sal = t.maxsal and date_format(e.HIREDATE, '%Y') = t.donggi;


select group_concat(ename), max(sal) maxsal, date_format(HIREDATE, '%Y') donggi
from emp
group by donggi;


