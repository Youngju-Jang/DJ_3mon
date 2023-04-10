-- 콘솔에서 root계정으로 로그인
-- C:\Program Files\MySQL\MySQL Server 8.0\bin>mysql -u root -p
-- Enter password: ***** <---1234(비번)
-- status (상태확인)
-- select user();  (접속사용자확인)

-- 콘솔에서 계정생성
-- create user 'ssafy'@'%' identified by 'ssafy'; (모든 아이피 접속가능, 계정:ssafy / 비번:ssafy)
-- grant all privileges on *.* to 'ssafy'@'%' with grant option; (모든 데이터베이스에 대해서 루트와 동일 권한 부여)
-- flush privileges  (설정한 권한이 바로 적용되도록 실행(적용이 안되는 경우)
-- drop user ssafy;  (ssafy 계정삭제)


-- 콘솔에서 데이터베이스 생성
-- create database ssafydb default character set utf8mb3 collate utf8mb3_general_ci;

-- ssafy계정으로 로그인 한후 연습sql 파일실행
-- mysql> use ssafydb;
-- mysql> source c:/mysql_creobjects.sql
-- --------------------------------------------------------------
-- 콘솔에서 사용자 계정으로 로그인(예: ssafy / ssafy)
-- [형식]
-- mysql -u 계정명 -p [데이터베이스명]
-- 비밀번호 입력

-- C:\Program Files\MySQL\MySQL Server 8.0\bin>mysql -u ssafy -p
-- Enter password: *****
-- mysql>
-- mysql> show databases;
-- +--------------------+
-- | Database           |
-- +--------------------+
-- | information_schema |
-- | mydb               |
-- | mysql              |
-- | performance_schema |
-- | sakila             |
-- | ssafydb            |
-- | ssafyweb           |
-- | sys                |
-- | world              |
-- +--------------------+
-- 9 rows in set (0.00 sec)

-- mysql> use ssafydb;
-- Database changed
-- mysql> show tables;
-- +-------------------+
-- | Tables_in_ssafydb |
-- +-------------------+
-- | countries         |
-- | departments       |
-- | employees         |
-- | job_history       |
-- | jobs              |
-- | locations         |
-- | regions           |
-- | salgrades         |
-- | student           |
-- +-------------------+
-- 9 rows in set (0.02 sec)

-- mysql> exit (작업종료)
-- -------------------------------------------------------------
-- ※ 이클립스에서 Database Connections에 다음과 같이 셋팅
-- URL: ssafydb
-- Database: jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8
-- 계정: ssafy 
-- 비밀번호: ssafy
