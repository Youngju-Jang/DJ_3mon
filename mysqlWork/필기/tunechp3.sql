use tuning;
show databases ;
show tables;
select count(1) from 사원;

explain
select * from 사원
where 사원번호 between 100001 and 200000;

explain
select 사원.사원번호, 급여.연봉
from 사원,
    (select 사원번호, max(연봉) as 연봉
     from 급여
     where 사원번호 between 10001 and 20000
     group by 사원번호) as 급여
where 사원.사원번호 = 급여.사원번호;

select * from 사원;

explain
select *
from 사원
where 사원번호 between 10001 and 100000
    and 입사일자 = '1985-11-21';

explain
select 사원번호, 시작일자
from 직급
where 직급명 = 'Manager';

desc 직급;
