# create database bitStudent default character set utf8mb3 collate utf8mb3_general_ci;
use bitStudent;
select * from student;
/*************************************************************************
* 기존에 저장되 있는 STUDENT, PROFESSOR, DEPARTMENT, SALGRADE 테이블 삭제
*************************************************************************/

DROP TABLE STUDENT;
# DROP TABLE PROFESSOR;
# DROP TABLE DEPARTMENT;
# DROP TABLE SALGRADE;


/*************************************************************************
*                         STUDNET 테이블 생성
*************************************************************************/
CREATE TABLE STUDENT
(
    STUDNO    int(5),
    NAME      VARCHAR(10) NOT NULL,
    SERID     varchar(10),
    GRADE     VARCHAR(1),
    IDNUM     VARCHAR(13),
    BIRTHDATE DATE,
    TEL       VARCHAR(13),
    HEIGHT    decimal(5, 2),
    WEIGHT    decimal(5, 2),
    DEPTNO    INT(4),
    PROFNO    INT(4)
);


/*************************************************************************
*                        STUDNET 테이블 데이터 입력
*************************************************************************/

INSERT INTO STUDENT
VALUES (101013, '전인하2', 'jun123', '4', '7907021369824',
        STR_TO_DATE('02-JUL-1979', '%d-%b-%Y'), '051)781-2158', 176, 72, '101', 9903);

INSERT INTO STUDENT
VALUES (20101, '이동훈', 'Dals', '1', '8312101128467',
        STR_TO_DATE('10-DEC-1983', '%d-%b-%Y'), '055)426-1752', 172, 64, '201', NULL);

INSERT INTO STUDENT
VALUES (10102, '박미경', 'ansel414', '1', '8405162123648',
        STR_TO_DATE('16-MAY-1984', '%d-%b-%Y'), '055)261-8947', 168, 52, '101', NULL);

INSERT INTO STUDENT
VALUES (10103, '김영균', 'mandu', '3', '8103211063421',
        STR_TO_DATE('11-JAN-1981', '%d-%b-%Y'), '051)824-9637', 170, 88, '101', 9906);

INSERT INTO STUDENT
VALUES (20102, '박동진', 'Ping2', '1', '8511241639826',
        STR_TO_DATE('24-NOV-1985', '%d-%b-%Y'), '051)742-6384', 182, 70, '201', NULL);

INSERT INTO STUDENT
VALUES (10201, '김진영', 'simply', '2', '8206062186327',
        STR_TO_DATE('06-JUN-1982', '%d-%b-%Y'), '055)419-6328', 164, 48, '102', 9905);
INSERT INTO STUDENT
VALUES (10104, '지은경', 'Gomo00', '2', '8004122298371',
        STR_TO_DATE('12-APR-1980', '%d-%b-%Y'), '055)418-9627', 161, 42, '101', 9907);

INSERT INTO STUDENT
VALUES (10202, '오유석', 'yousuk', '4', '7710121128379',
        STR_TO_DATE('12-OCT-1977', '%d-%b-%Y'), '051)724-9618', 177, 92, '102', 9905);

INSERT INTO STUDENT
VALUES (10203, '하나리', 'hanal', '1', '8501092378641',
        STR_TO_DATE('18-DEC-1984', '%d-%b-%Y'), '055)296-3784', 160, 68, '102', NULL);

INSERT INTO STUDENT
VALUES (10105, '임유진', 'YouJin12', '2', '8301212196482',
        STR_TO_DATE('21-JAN-1983', '%d-%b-%Y'), '02)312-9838', 171, 54, '101', 9907);

INSERT INTO STUDENT
VALUES (10106, '서재진', 'seolly', '1', '8511291186273',
        STR_TO_DATE('29-NOV-1985', '%d-%b-%Y'), '051)239-4861', 186, 72, '101', NULL);

INSERT INTO STUDENT
VALUES (10204, '윤진욱', 'Samba7', '3', '7904021358671',
        STR_TO_DATE('02-APR-1979', '%d-%b-%Y'), '053)487-2698', 171, 70, '102', 9905);

INSERT INTO STUDENT
VALUES (10107, '이광훈', 'huriky', '4', '8110131276431',
        STR_TO_DATE('13-OCT-1981', '%d-%b-%Y'), '055)736-4981', 175, 92, '101', 9903);

INSERT INTO STUDENT
VALUES (20103, '김진경', 'lovely', '2', '8302282169387',
        STR_TO_DATE('28-FEB-1983', '%d-%b-%Y'), '052)175-3941', 166, 51, '201', 9902);

INSERT INTO STUDENT
VALUES (20104, '조명훈', 'Rader214', '1', '8412141254963',
        STR_TO_DATE('16-SEP-1984', '%d-%b-%Y'), '02)785-6984', 184, 62, '201', NULL);

INSERT INTO STUDENT
VALUES (10108, '류민정', 'cleanSky', '2', '8108192157498',
        STR_TO_DATE('19-AUG-1981', '%d-%b-%Y'), '055)248-3679', 162, 72, '101', 9907);


/*************************************************************************
*                         PROFESSOR 테이블 생성
*************************************************************************/
CREATE TABLE PROFESSOR
(
    PROFNO   int(4) PRIMARY KEY,
    NAME     VARCHAR(10) NOT NULL,
    USERID   VARCHAR(10),
    POSITION VARCHAR(20),
    SAL      int(10),
    HIREDATE DATE,
    COMM     int(2),
    DEPTNO   int(4)
);


/*************************************************************************
*                        ROFESSOR 테이블 데이터 입력
*************************************************************************/
INSERT INTO PROFESSOR
VALUES (9901, '김도훈', 'capool', '교수', 500,
        STR_TO_DATE('24-JUN-1982', '%d-%b-%Y'), 20, 101);

INSERT INTO PROFESSOR
VALUES (9902, '이재우', 'sweat413', '조교수', 320,
        STR_TO_DATE('12-APR-1995', '%d-%b-%Y'), NULL, 201);

INSERT INTO PROFESSOR
VALUES (9903, '성연희', 'Pascal', '조교수', 360,
        STR_TO_DATE('17-MAY-1993', '%d-%b-%Y'), 15, 101);

INSERT INTO PROFESSOR
VALUES (9904, '염일웅', 'Blue77', '전임강사', 240,
        STR_TO_DATE('02-DEC-1998', '%d-%b-%Y'), NULL, 102);

INSERT INTO PROFESSOR
VALUES (9905, '권혁일', 'refresh', '교수', 450,
        STR_TO_DATE('08-JAN-1986', '%d-%b-%Y'), 25, 102);

INSERT INTO PROFESSOR
VALUES (9906, '이만식', 'Pocari', '부교수', 420,
        STR_TO_DATE('13-SEP-1988', '%d-%b-%Y'), NULL, 101);

INSERT INTO PROFESSOR
VALUES (9907, '전은지', 'totoro', '전임강사', 210,
        STR_TO_DATE('01-JUN-2001', '%d-%b-%Y'), NULL, 101);

INSERT INTO PROFESSOR
VALUES (9908, '남은혁', 'Bird13', '부교수', 400,
        STR_TO_DATE('18-NOV-1990', '%d-%b-%Y'), 17, 202);

/*************************************************************************
*                          DEPARTMENT 테이블 생성
*************************************************************************/
CREATE TABLE DEPARTMENT
(
    DEPTNO  int(4) PRIMARY KEY,
    DNAME   VARCHAR(16) NOT NULL,
    COLLEGE int(4),
    LOC     VARCHAR(10)
);

/*************************************************************************
*                        DEPARTMENT 테이블 데이터 입력
*************************************************************************/
INSERT INTO DEPARTMENT
VALUES (101, '컴퓨터공학과', 100, '1호관');

INSERT INTO DEPARTMENT
VALUES (102, '멀티미디어학과', 100, '2호관');

INSERT INTO DEPARTMENT
VALUES (201, '전자공학과', 200, '3호관');

INSERT INTO DEPARTMENT
VALUES (202, '기계공학과', 200, '4호관');

INSERT INTO DEPARTMENT
VALUES (100, '정보미디어학부', 10, NULL);

INSERT INTO DEPARTMENT
VALUES (200, '메카트로닉스학부', 10, NULL);

INSERT INTO DEPARTMENT
VALUES (10, '공과대학', NULL, NULL);


/*************************************************************************
*                          SALGRADE 테이블 생성
*************************************************************************/
CREATE TABLE SALGRADE
(
    GRADE int(2),
    LOSAL int(5),
    HISAL int(5)
);

/*************************************************************************
*                         SALGRADE 테이블 데이터 입력
*************************************************************************/
INSERT INTO SALGRADE
VALUES (1, 100, 300);
INSERT INTO SALGRADE
VALUES (2, 301, 400);
INSERT INTO SALGRADE
VALUES (3, 401, 500);

COMMIT;

ALTER TABLE student
    ADD CONSTRAINT stud_deptno_fk FOREIGN KEY (deptno) REFERENCES department (deptno);

ALTER TABLE professor
    ADD CONSTRAINT prof_deptno_fk FOREIGN KEY (deptno) REFERENCES department (deptno);