use scott;
drop table membersi;
CREATE TABLE IF NOT EXISTS `MemberSi` (
    `NO` int(11) not null ,
  `NAME` varchar(10) DEFAULT NULL,
  `JID` varchar(14) DEFAULT NULL,
  `TEL` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `MemberSi` values
(1, '장영주', '940207-210000', '010)3823-5151'),
(2, '박지호', '920207-210000', '010)3823-5150'),
(3, '김병훈', '910207-210000', '010)3823-5159'),
(4, '우지안', '900207-210000', '010)3823-5158'),
(5, '박혜주', '970207-210000', '010)3823-5157'),
(6, '이원진', '980207-210000', '010)3823-5156');
ALTER TABLE MemberSi MODIFY NO INT NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
select * from membersi;
insert into `MemberSi` (name, jid, tel) values
('김영주', '000207-410000', '010)3823-5151');


select no, name, jid, tel,
       YEAR(NOW())-SUBSTR(JID,1,2)+1 -
       IF(SUBSTR(JID, 8, 1) < 3, 1900, 2000) age,
        if(substr(jid, 8, 1) in (1, 3), 'M', 'F') GENDER,
        case substring_index(tel, ')', 1)
        when 02 then '서울' when 051 then '부산' when 031 then '경기도' when 033 then '강원도'
        when 055 then '경남' else 'etc'
        end LOCATION,
        concat(if(substr(jid, 8,1 ) in (1,2), 19, 20),
        substr(jid, 1, 2),'/',substr(jid, 3, 2),'/',substr(jid, 5,2)) BIRTHDAY
from membersi;

select YEAR(NOW())-SUBSTR(JID,1,2)+1 - IF(SUBSTR(JID, 8, 1) < 3, 1900, 2000) age
from membersi;
select concat(if(substr(jid, 8,1 ) in (1,2), 19, 20),
    substr(jid, 1, 2),'/',substr(jid, 3, 2),'/',substr(jid, 5,2)) BIRTHDAY
from membersi;
select substring_index(tel, ')', 1)
from membersi;

select str_to_date(substr(jid, 1, 6), '%y%m%d')
from membersi;
select substr(jid, 3, 4)
from membersi;