REM   Script: Activity5
REM   Activities

select * from salesman;

update salesman SET grade=200 WHERE salesman_city='Rome';

update salesman SET grade=300 WHERE salesman_name='James Hoog';

update salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

select * FROM salesman;