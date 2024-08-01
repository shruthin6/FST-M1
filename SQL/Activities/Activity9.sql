REM   Script: Activity9
REM   Activities

create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

select a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission from customers a 
inner join salesman b ON a.salesman_id=b.salesman_id;


select a.customer_name, a.city, a.grade, b.salesman_name AS "Salesman", b.salesman_city from customers a 
left outer join salesman b ON a.salesman_id=b.salesman_id where a.grade<300 
ORDER BY a.customer_id;

select a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customers a 
inner join salesman b ON a.salesman_id=b.salesman_id 
WHERE b.commission>12;

select a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.salesman_name AS "Salesman", c.commission FROM orders a 
inner join customers b ON a.customer_id=b.customer_id 
inner join salesman c ON a.salesman_id=c.salesman_id;