use tuning;
show databases ;
show tables;
select count(1) from 사원;

explain
select * from 사원
where 사원번호 between 100001 and 200000;

explain
select 사원.사원번호, 사원.이름, 사원.성, 급여.연봉,
    (select max(부서번호)
     from 부서사원_매핑 as 매핑 where 매핑.사원번호 = 사원.사원번호) 카운트
from 사원, 급여
where 사원.사원번호 = 10001
and 사원.사원번호 = 급여.사원번호;

select * from 사원;