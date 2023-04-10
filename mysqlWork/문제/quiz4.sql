use sqldb;
-- 1. 이름이 '김경호'인 사람보다 키가 큰 사람들의 이름과 키를 출력하라
select name, height
  from usertbl
 where height > (select height 
                   from usertbl
                  where name = '김경호');
-- 2. 주소가 "경남" 인 사람들의 최소 키보다 큰 사람들에 대한 이름과 키를 출력하라
 select name, height
   from usertbl
  where height > (select height
                    from usertbl
				   where addr = "경남");
-- 3. 주소가 "경남" 인 모든 사람들의 키보다 큰 사람들에 대한 이름과 키를 출력하라
select name, height
 from usertbl
where height > any (select height
                      from usertbl
 			         where addr = "경남");
-- 4. userid를 기준으로 해당 회원의 id, name, prodname, addr, 연락처를 출력하라
select B.userid, U.username, B.prodname, U.addr, 
       concat(U.mobile1, U.mobile2) as '연락처'
  from usertbl U
  inner join buytbl B
  on U.userid = B.userid
  order by U.userid;