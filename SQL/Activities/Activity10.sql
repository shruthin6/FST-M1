REM   Script: Activity10
REM   Activities

select * from orders
where salesman_id=(select distinct salesman_id FROM orders where customer_id=3007);


select * from orders
where salesman_id IN (select salesman_id from salesman where salesman_city='New York');

SELECT grade, COUNT(*) FROM customers
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE salesman_city='New York');


SELECT order_no, purchase_amount, order_date, salesman_id FROM orders
WHERE salesman_id IN( SELECT salesman_id FROM salesman
WHERE commission=( SELECT MAX(commission) FROM salesman));