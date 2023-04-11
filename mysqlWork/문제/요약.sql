-- 1. 키가 170보다 큰 학생의 이름, 학년, 키, 학과이름, 지도교수 이름 출력하되 키가 큰 순으로 출력하여라.
-- 2.101번 학과 학생 중에서 3학년 이상인 학생의 이름, 사용자 아이디, 학년 ,학과이름 을 출력하여라
-- 3. 학생중에서 성이 '이'씨인 학생의 이름, 사용자 아이디, 학과번호를 출력하여라.
-- 4. 소속 교수는 있으나 소속 학생이 없는 학과 번호를 출력하여라.
-- 5. 보직수당을 받지 않는 교수의 이름, 급여, 학과 번호,학과이름을  출력하여라
-- 6. 학생 테이블에서 학생들의 비만도를 측정하여 10보다 작으면 '정상', 10보다 크고
--     20보다 작으면 '과체중', 20보다 크면 '비만'으로 분류하여 출력하여라. 비만도 계산 공식
--     은 ((실제 체중 - 표준 체중)/표준 체중)*100이고 표준 체중은 (키-실제 체중)*0.9 이다.
--
-- 7.학생을 3개 팀으로 분류하기 위해 학번을 3으로 나누어 나머지가 0이면 'A팀', 1이면
--   'B팀', 2이면 'C팀'으로 분류하여 학생 번호, 이름, 학과 번호, 팀 이름을 출력하여라.
--
-- 8. 학생 전화번호의 지역번호가 '02'이면 '서울', '051'이면 '부산', '052'이면 '울산', '053'
--   이면 '대구', 나머지는 '기타'로 출력하여라.
--
-- 9. 학과별로 평균 몸무게와 학생 수를 출력하되 평균 몸무게의 내림차순으로 정렬하여라
--
-- 10. 동일 학과내에서 같은 학년에 재학중인 학생 수가 3명 이상인 그룹의 학과 번호,
--     학년, 학생 수, 최대 키, 최대 몸무게를 출력하여라.
--
-- 11. 학과와 학년별 키의 평균, 학과별 키의 평균, 전체 학생에 대한 키의 평균을 출력  하여라
--
-- 12. 학과별 교수 수가 2명 이하인 학과 번호, 교수 수를 출력하여라.
--
-- 13. 교수 중에서 급여와 보직수당을 합친 금액이 가장 많은 경우와 가장 적은 경우 그리고
--      평균 금액을 출력하여라. 단, 보직수당이 없는 교수의 급여는 0으로 계산
--
-- 14. 직급별로 평균 급여가 300보다 크면 '우수', 작거나 같으면 '보통'을 출력하여라.
--
-- 15. 학생 테이블에서 키의 범위에 따라 A, B, C ,D등급으로 나눈 후, 등급별 인원 수를 출력 하여라.
select grade, count(*)
from (select HEIGHT, case when ntile(4) over (order by HEIGHT) =1 then 'D'
when ntile(4) over (order by HEIGHT)=2 then 'C'
when ntile(4) over (order by HEIGHT)=3 then 'B'
when ntile(4) over (order by HEIGHT)=4 then 'A' end grade
from student) t
group by grade
order by grade;
-- 16. 부서 테이블에서 각 부서의 상위 부서 이름을 출력하여라.
select NAME, sal, grade
from professor p
         join SALGRADE s
where p.SAL between s.LOSAL and s.HISAL
  and grade = 3;

select * from DEPARTMENT;


-- 17. 각 학과에 소속된 학과 이름, 학생 이름, 교수 이름을 모두 출력하여라.
select DNAME, s.NAME, p.NAME
from student s join department d on s.DEPTNO = d.DEPTNO
join professor p on s.DEPTNO = p.DEPTNO
-- 18.  교수 별로 교수 이름과 지도 학생 수를 출력하여라
select p.NAME, count(*)
from professor p join student s on p.DEPTNO = s.DEPTNO
group by p.NAME;
-- 19. 학생증에서 생년월일이 가장 빠른 학생의 학번, 이름, 생년월일을 출력하여라
select *
from student
order by BIRTHDATE asc limit 1;
-- 20. 학년별로 체중이 가장 적은 학년과 평균 몸무게를 출력하여라
select grade, avg(weight)
from student
group by grade
order by GRADE limit 1;