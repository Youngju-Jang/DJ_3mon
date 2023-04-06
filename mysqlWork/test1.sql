use bitdb;

select * from employees;
-- ex1)employees테이블의 모든 사원의 사원번호(employee_id),이름(last_name),급여(salary) 검색
select employee_id, last_name, salary
from employees;

-- ex2)employees테이블에서 모든 사원의 이름, 입사일(hire_date), 업무ID(job_id)만 검색
select first_name, hire_date, job_id
from employees;

-- ex3)employees테이블에서 모든 사원의 이름(last_name), 연봉(salary*12)만 검색
select last_name, salary*12 'yearSal'
from employees;

-- ex4)별명붙이기(as는 생략가능)
--    employees테이블의 모든 사원의 사원번호,이름(last_name),급여 검색
--    조건) title 사원번호, 이름 ,급여로 출력할것
select employee_id '사원번호', last_name '이름', salary '급여'
from employees;


-- ex5)employee테이블에서 사원번호,이름,연봉을 구하시오
--     조건1) 연봉 = 급여 * 12
--     조건2) 제목을 사원번호,이  름,연  봉으로 출력
select employee_id, last_name, salary*12
from employees;

-- ex6)연결연산자(concat): 컬럼을 연결해서 출력
--    first_name과  last_name을 연결해서 출력하시오
--     이   름
--     ------------
--     Ellen   Abel
-- 일반적인 DBMS에서는 ||로 문자열을 연결하지만 MySQL에서는 ||을 사용할수 없다.
-- concat()사용해야 한다.
select concat(first_name,' ', last_name) '이름'
from employees;

-- ex7)다음처럼 출력하시오
--   사원번호        이  름                 연 봉
--   ---------------------------------------------
--    100      Steven King   288000달러
select employee_id '사원번호', concat(first_name,' ', last_name) '이름', concat(truncate(salary*12,0), ' 달러') '연봉'
from employees;

-- ex8) 다음처럼 출력하시오 (last_name, job_id이용)
--     Employee  Detail
--     --------------------
--     King  is a  AD_PRES
select concat(last_name, ' is a ', job_id)
from employees;

-- 중복제거(distinct)
-- ex9)employees테이블에서 부서를 출력하시오
--    조건1)중복되는 부서는 1번만 출력하시오
--    조건2)부서별 오름차순으로 보여주시오
select distinct department_id
from employees
order by department_id asc;

-- ex10) 10번부서 또는 90번부서 사원들의 이름,입사일,부서ID를 출력하시오
-- 방법1)or 연산자
select first_name, hire_date, department_id
from employees
where department_id = 10 or department_id = 90;

-- 방법2)in연산자(or연산자의 다른표현)
select first_name, hire_date, department_id
from employees
where department_id in (10, 90);

-- ex11)급여가 2500이상 3500이하인 사원의 이름(last_name), 입사일, 급여를 검색하시오 --33건
-- 방법1)and 연산자
select last_name, hire_date, salary
from employees
where 2500<= salary and salary <=3500;

-- 방법2)between연산자(and연산자의 다른 표현): 초과,미만에서는 사용할수 없다
select last_name, hire_date, salary
from employees
where salary between 2500 and 3500;

-- ex12) 급여가 2500이하 이거나 3000이상이면서, 90번 부서인 사원의 이름, 급여, 부서ID를 출력하시오. --3건
--      조건1) 제목은 사원명, 월  급, 부서코드로 하시오
select first_name '사원명', salary '급여', department_id '부서ID'
from employees
where salary between 2500 and 3500 and department_id = 90;
--      조건2) 급여앞에 $를 붙이시오
select first_name '사원명', concat(salary,'$') '급여', department_id '부서ID'
from employees
where salary between 2500 and 3500 and department_id = 10 ;

--      조건3) 사원명은 first_name과 last_name을 연결해서 출력하시오
select concat(first_name,' ',last_name) '사원명', concat(salary,'$') '급여', department_id '부서ID'
from employees
where salary between 2500 and 3500 and department_id = 10 ;

-- ex13)'King'사원의 모든 컬럼을 표시하시오
select *
from employees
where upper(last_name) = 'KING';

-- ex14)업무ID에 CL이 포함되어있는 사원들의 이름,업무ID,부서ID를 출력하시오  --45건
select last_name,job_id, department_id
from employees
where job_id like '%CL%';


-- ex15)업무ID가  IT로 시작하는 사원들의 이름,업무ID,부서ID를 출력하시오  -- 5건
select last_name,job_id, department_id
from employees
where job_id like 'IT%';

-- ex16) is null / is not null
-- 커미션을 받는 사원들의 이름과 급여,커미션을 출력하시오 -- 35건
select last_name,salary, commission_pct
from employees
where commission_pct is not null;

-- ex17)커미션을 받지 않는 사원들의 이름과 급여,커미션을 출력하시오 -- 72건
select last_name,salary, commission_pct
from employees
where commission_pct is null;

-- ex18) 사원명,부서ID,입사일을 부서별로 내림차순 정렬하시오
select last_name, department_id, hire_date
from employees
order by department_id desc;

-- ex19) 사원명, 부서ID, 입사일을  부서별로 내림차순 정렬하시오
--     같은부서가 있을때는  입사일순으로 정렬하시오
select last_name, department_id, hire_date
from employees
order by department_id desc, hire_date asc;

-- ex20) 사원들의 연봉을 구한후 연봉순으로 내림차순정렬하시오
-- 이 름     연 봉
-- ---------------
-- King   28800달러
select last_name '이름', concat(truncate(salary,0),'달러') '연봉'
from employees
order by salary desc;

-- ex21)업무 id가 'SA_MAN'또는'SA_REP'이면 'Sales Dept' 그 외 부서이면 'Another'로 표시
-- 조건) 분류별로 오름차순정렬
--        직무          분류
--       --------------------------
--       SA_MAN    Sales Dept
--       SA_REP      Sales Dept
--       IT_PROG    Another
select job_id '직무', if(job_id = 'SA_MAN' or job_id = 'SA_REP','Sales Dept','Another') '분류'
from employees;
