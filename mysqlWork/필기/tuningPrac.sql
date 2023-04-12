select engine, transactions, comment
from information_schema.engines;

use bitStudent;
select NAME, (select count(*) from student s2 where s2.name = s1.NAME) cnt
from student s1;