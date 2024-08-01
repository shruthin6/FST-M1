REM   Script: Activity4
REM   Activities

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

alter TABLE salesman ADD grade int;

update salesman SET grade=100;

select * FROM salesman;

