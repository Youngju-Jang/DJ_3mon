use tuning;

show variables like 'profiling%';
set profiling = 'ON';

select 사원번호 from 사원 where 사원번호 = 100000;
show profiles;
show profile for query 1;

Select count(1) from 직급;
desc 직급;

SELECT *
FROM INFORMATION_SCHEMA.STATISTICS
WHERE TABLE_SCHEMA = 'tuning';

SELECT *
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'tuning';