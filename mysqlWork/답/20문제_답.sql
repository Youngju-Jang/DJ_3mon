use bitstudent;
-- 1. 키가 170보다 큰 학생의 이름, 학년, 키, 학과이름, 지도교수 이름 출력하되 키가 큰 순으로 출력하여라.
SELECT STUDNO, S.NAME, SERID, GRADE, IDNUM, BIRTHDATE, TEL, HEIGHT,
WEIGHT, S.DEPTNO, S.PROFNO,P.NAME PANME
FROM STUDENT S inner join DEPARTMENT D
ON S.DEPTNO=D.DEPTNO
LEFT OUTER JOIN PROFESSOR P
ON S.PROFNO=P.PROFNO
WHERE HEIGHT>170
ORDER BY HEIGHT DESC;

-- 2.101번 학과 학생 중에서 3학년 이상인 학생의 이름, 사용자 아이디, 학년 ,학과이름 을 출력하여라
SELECT name, serid, grade,d.dname
FROM student s INNER JOIN DEPARTMENT d
ON s.DEPTNO=d.DEPTNO
WHERE s.deptno=101 AND grade >= 3;

-- 3. 학생중에서 성이 '이'씨인 학생의 이름, 사용자 아이디, 학과번호를 출력하여라.
SELECT name, serid, deptno
FROM student
WHERE name LIKE '이%';

-- 4. 소속 교수는 있으나 소속 학생이 없는 학과 번호를 출력하여라.
 SELECT distinct p.deptno
 FROM professor p  inner join  department d
 on p.deptno=d.deptno
 left join student s
 on p.deptno=s.deptno
 where s.deptno is null;
 -- MINUS
--  SELECT deptno
--  FROM student;


 -- 5. 보직수당을 받지 않는 교수의 이름, 급여, 학과 번호,학과이름을  출력하여라
  SELECT name, sal, p.deptno,d.dname
  FROM professor p inner join department d
  on p.deptno=d.deptno
  WHERE comm IS NULL;
-- 6. 학생 테이블에서 학생들의 비만도를 측정하여 10보다 작으면 '정상', 10보다 크고
--    20보다 작으면 '과체중', 20보다 크면 '비만'으로 분류하여 출력하여라. 비만도 계산 공식
--    은 ((실제 체중 - 표준 체중)/표준 체중)*100이고 표준 체중은 (키-실제 체중)*0.9 이다.
   SELECT name, weight, CASE WHEN ((weight-((height-weight)*0.9))
/ ((height-weight)*0.9))*100 < 11 THEN '정상'
 WHEN ((weight-((height-weight)*0.9))/((height-weight)*0.9))*100
BETWEEN 11 AND 19 THEN '과체중'
 WHEN ((weight-((height-weight)*0.9))/((height-weight)*0.9))*100 > 19
THEN '비만'
 END weight_state
 FROM student;


-- 7.학생을 3개 팀으로 분류하기 위해 학번을 3으로 나누어 나머지가 0이면 'A팀', 1이면
--  'B팀', 2이면 'C팀'으로 분류하여 학생 번호, 이름, 학과 번호, 팀 이름을 출력하여라.
 SELECT studno, name, deptno,
 CASE WHEN MOD(studno,3)=0 THEN 'A팀'
 WHEN MOD(studno,3)=1 THEN 'B팀'
 ELSE 'C팀' END teamname
 FROM student;
-- 8. 학생 전화번호의 지역번호가 '02'이면 '서울', '051'이면 '부산', '052'이면 '울산', '053'
--  이면 '대구', 나머지는 '기타'로 출력하여라.

SELECT name, tel, CASE WHEN SUBSTR(tel,1,2) = '02' THEN '서울'
 WHEN SUBSTR(tel,1,3) = '051' THEN '부산'
 WHEN SUBSTR(tel,1,3) = '052' THEN '울산'
 WHEN SUBSTR(tel,1,3) = '053' THEN '대구'
 ELSE '기타'
 END city
 FROM student;

-- 9. 학과별로 평균 몸무게와 학생 수를 출력하되 평균 몸무게의 내림차순으로 정렬하여라
select deptno, avg(weight) avg_weight, count(*)
from student
group by deptno
order by avg_weight desc;
-- 10. 동일 학과내에서 같은 학년에 재학중인 학생 수가 3명 이상인 그룹의 학과 번호,
--    학년, 학생 수, 최대 키, 최대 몸무게를 출력하여라.
 select deptno, grade, count(*), max(height), max(weight)
 from student
 group by deptno, grade
 having count(*) >= 3;

-- 11. 학과와 학년별 키의 평균, 학과별 키의 평균, 전체 학생에 대한 키의 평균을 출력  하여라
select deptno, grade, avg(height)
from student
group by  deptno, grade with rollup;

-- 12. 학과별 교수 수가 2명 이하인 학과 번호, 교수 수를 출력하여라.
 select deptno, count(*)
 from professor
 group by deptno
 having count(*) <=2;
-- 13. 교수 중에서 급여와 보직수당을 합친 금액이 가장 많은 경우와 가장 적은 경우 그리고
-- 평균 금액을 출력하여라. 단, 보직수당이 없는 교수의 급여는 0으로 계산
select round(max(sal+comm),2) max_sal, round(min(sal+comm),2) min_sal,
round(avg(sal+comm),2) avg_sal
from professor;
-- 14. 직급별로 평균 급여가 300보다 크면 '우수', 작거나 같으면 '보통'을 출력하여라.
select position, avg(sal),
case when avg(sal) > 300 then '우수'
when avg(sal) <=300 then '보통'
end "구분"
from professor
group by position;

-- 15. 학생 테이블에서 키의 범위에 따라 A, B, C ,D등급으로 나눈 후, 등급별 인원 수를 출력 하여라.
 select case when height <=160 then 'A'
 when height between 161 and 170 then 'B'
 when height between 171 and 180 then 'C'
 when height >=180 then 'D'
 end acc, count(*)
 from student
 group by (case when height <=160 then 'A'
 when height between 161 and 170 then 'B'
 when height between 171 and 180 then 'C'
 when height >= 180 then 'D' end ) with rollup;

Use bitStudent;
select case when height <=160 then 'A'
 when height between 161 and 170 then 'B'
 when height between 171 and 180 then 'C'
 when height >=180 then 'D'
 end acc, count(*)
 from student
 group by acc with rollup;
-- A	1
-- B	6
-- C	6
-- D	3
-- 	   16

-- 16. 부서 테이블에서 각 부서의 상위 부서 이름을 출력하여라.
 select concat(concat(dept.dname,'의 소속은'), org.dname)
 from department dept, department org
 where dept.college = org.deptno;
-- 17. 각 학과에 소속된 학과 이름, 학생 이름, 교수 이름을 모두 출력하여라.
 select d.dname "학과이름", s.name "학생이름", p.name "교수이름"
 from department d, student s, professor p
 where d.deptno = s.deptno and s.profno = p.profno;


 select d.dname "학과이름", s.name "학생이름", p.name "교수이름"
 from department d inner join  student s
 on d.deptno = s.deptno
 inner join professor p
 on s.profno = p.profno;


 select d.dname "학과이름", s.name "학생이름", p.name "교수이름"
 from department d inner join  student s
 on d.deptno = s.deptno
 left outer join professor p
 on s.profno = p.profno;



-- 18.  교수 별로 교수 이름과 지도 학생 수를 출력하여라
 select p.name, count(s.deptno)
 from professor p, student s
 where p.profno = s.profno
 group by p.name;
-- 19. 학생증에서 생년월일이 가장 빠른 학생의 학번, 이름, 생년월일을 출력하여라
 select studno, name, birthdate
 from student
 where birthdate = (select min(birthdate)
 from student);

-- 20. 학년별로 체중이 가장 적은 학년과 평균 몸무게를 출력하여라

select grade,avg(weight)
from student
group by grade
having round(avg(weight))=(
 select  round(min(a.avg_weight))
 from(
 select  grade,avg(weight) avg_weight
 from student
 group by grade)a);


