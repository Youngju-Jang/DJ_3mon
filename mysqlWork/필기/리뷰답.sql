-- 과제 답
use restReview;

-- 1. MEMBER_PROFILE에서 성별이 남자인 사람 중에 최고 연장자의 이름, 연락처, 나이를 구하시오
select member_name '이름', tlno '연락처', year(now())-year(date_of_birth)+1 '나이'
from member_profile
where gender='M'
order by date_of_birth limit 1;

-- 2. MEMBER_PROFILE에서 성이 ‘김’인 남자의 수와 여자의 수를 구하시오.
select gender,count(*) '수'
from member_profile
where member_name like '김%'
group by gender;

-- 3. REST_REVIEW에서 평점 별 리뷰의 갯수를 구하시오.
select review_score '평점', count(*) '리뷰 갯수'
from rest_review
group by review_score
order by review_score;

-- 4. MEMBER_PROFILE에 기록된 생일에 식당 리뷰를 남긴 사람의 이름과 전화번호, 평점을 구하세요.
select date_of_birth, review_date, member_name, tlno, review_score, review_id
from rest_review r join member_profile mp on mp.member_id = r.member_id
where date_format(r.review_date,'%m %d') = date_format(mp.date_of_birth,'%m %d');


# insert into rest_review (rest_id, member_id, review_score, review_text, review_date) values
# (3, 3, 9, '이번에 친구들과 같이 방문했는데, 맛있고 분위기도 좋았어요. 특히 새우튀김과 생맥주가 인상적이었습니다. 다음에 또 가고 싶은 식당 중 하나입니다.', '2021-02-23');

select *
from rest_review join member_profile mp on rest_review.member_id = mp.member_id
where mp.member_id=3;
select * from rest_review where review_id=78;
select *
from member_profile

-- 5. REST_LIST에서 주소가 부산인 식당의 수를 구하시오.
select count(*) '부산 식당수'
from rest_list
where address like '부산%';

-- 6. REST_REVIEW에서 한식 음식점의 평점의 평균을 구하시오.
-- 평균은 소숫점 2자리에서 반올림하시오.
use restReview;
select round(avg(review_score), 2)
from rest_review rr join rest_list rl on rr.rest_id = rl.rest_id
where rl.rest_category = '한식'
group by rl.rest_id;

-- 7.REST_LIST에서 음식점 종류가 한식이면 ‘국내’, 음식점 종류가 중식이거나 일식 또는 양식이면 ‘해외’라고 출력하시오.

-- 8. REST_REVIEW, REST_LIST 테이블에서 가게 평균 평점이 8점~10점은 5성, 6점~8점은 4성, 5점 ~ 6점은 3성,
-- 그 이하는 비추천으로 하여 음식점의 이름, 평균 평점, 별점을 출력해주세요.


-- 9. REST_REVIEW에서 리뷰 작성일이 4월과 5월인 리뷰의 식당 ID와 별점, 내용을 출력하시오.


-- 10. MEMBER_PROFILE에서 30세 이상인 사람들이 가장 많이 준 평점을 출력하세요.


-- 11. REST_REVIEW, REST_LIST 테이블에서 ‘순’이 들어가는 음식점 중 별점이 가장 높은 식당의 이름과 주소, 별점을 출력해주세요.


-- 12.REST_REVIEW, REST_LIST 테이블에서 평균 평점이 제일 높은 가게를 찾고 해당 음식점이 속한 종류의 음식점들을 출력해주세요.
-- 이름을 기준으로 오름차순으로 정렬해주세요.


-- 13.REST_REVIEW, MEMBER PROFILE 테이블에서 리뷰에 떡사리를 쓴 사람의 이름, 연락처, 성별, 생일을 구하시오


-- 14.MEMBER_PROFILE, REST_REVIEW 테이블에서 10대, 20대, 30대 별로 가장 많은 리뷰를 남긴 음식점의 종류와 리뷰의 개수를 출력하시오.
use restReview;
(SELECT '20대', rl.rest_category 종류, count(*) 개수
FROM member_profile m
         JOIN rest_review rr ON m.member_id = rr.member_id
         JOIN rest_list rl ON rr.rest_id = rl.rest_id
WHERE year(now()) - year(date_of_birth) + 1 BETWEEN 20 AND 29
GROUP BY rl.rest_category
ORDER BY count(*) DESC
LIMIT 1)
UNION
(SELECT '30대', rl.rest_category 종류, count(*) 개수
FROM member_profile m
         JOIN rest_review rr ON m.member_id = rr.member_id
         JOIN rest_list rl ON rr.rest_id = rl.rest_id
WHERE year(now()) - year(date_of_birth) + 1 BETWEEN 30 AND 39
GROUP BY rl.rest_category
ORDER BY count(*) DESC
LIMIT 1);

-- 15. 성별이 남자인 회원이 부산시에 속해있는 식당에 가서 쓴 리뷰 중 평점이 5점 이상인 리뷰의 갯수를 구하세요.


-- 16.REST_REVIEW, MEMBER_PROFILE, REST_LIST 테이블에서 가장 긴 리뷰를 남긴 사람보다 어린 사람들이 방문한 식당의 이름, 식당 주소, 리뷰 점수를 구하시오.
select  rest_name, address, review_score, date_of_birth
    from rest_review rr join member_profile mp on rr.member_id = mp.member_id
    join rest_list rl on rr.rest_id = rl.rest_id
where mp.date_of_birth >
(select mp.date_of_birth
from rest_review join member_profile mp on rest_review.member_id = mp.member_id
order by length(review_text) desc limit 1);

select mp.date_of_birth
from rest_review join member_profile mp on rest_review.member_id = mp.member_id›
order by length(review_text) desc limit 1;
-- 17.REST_REVIEW 테이블에서 식당 ID와 회원 ID, 회원 ID별 별점의 평균을 출력해주세요.
-- 회원 ID별 별점의 평균은 내림차순으로 정렬해주세요.


-- 18.MEMBER_PROFILE, REST_REVIEW 테이블에서 년, 월, 성별 별로 리뷰를 쓴 회원의 수를 집계하는 SQL문을 작성해주세요.
-- 결과는 년, 월, 성별을 기준으로 오름차순으로 정렬해주세요.
-- 이때, 성별 정보가 없는 경우 결과에서 제외시켜주세요.
select count(*)
from rest_review r left join member_profile mp on r.member_id = mp.member_id
;

-- 19. MEMBER_PROFILE, REST_REVIEW, REST_LIST에서 리뷰 작성일이 3월인 회원들이 방문했던 식당의 이름들을 출력해주세요.
-- 식당의 이름은 리뷰 작성일 기준으로 내림차순으로 정렬해주세요.


-- 20.MEMBER_PROFILE와 REST_REVIEW 테이블에서 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요.
-- 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고, 결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬해주세요



