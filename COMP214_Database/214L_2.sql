select to_date(hire_date,'yy/mm/dd')  from employees where hire_date BETWEEN '2016-01-01' and '2016-02-29';

select first_name, last_name,to_char(hire_date+1, 'yyyy/mm/dd') as Tomorrow from employees;

select * from employees;

select * from products;

/*--*/
select product_id as productID, 
       product_name as productName, 
       list_price as listPrice, 
       (list_price*1.02) as SecListPRice,
       round(list_price*1.02) as ThirdListPRice 
from products;

/*
Q3: For employees whose manager ID is 2, write a query that displays the 
employee's Full Name and Job Title in the following format:

Summer, Payne is Public Accountant.
*/
select  concat(FIRST_NAME,', ', LAST_NAME,' is ', JOB_TITLE) as "all"
from employees
where MANAGER_ID = 2;
/*
Q4: For each employee hired before October 2016, 
display the employee's 
  last name, 
  hire date 
  and calculate the number of YEARS between TODAY and the date the employee was hired.
1)    Label the column Years worked. 
2)    Order your results by the number of years employed.  
Round the number of years employed up to the closest whole number.
*/

-- select LAST_NAME, HIRE_DATE, round(months_between(TO_DATE('2024/09/20','YYYY/MM/DD'),hire_date)/12) AS "Years worked"
-- from employees
-- where hire_date < to_date('01/10/2016', 'dd-mm-yy');   
select LAST_NAME, 
       HIRE_DATE, 
       round(months_between(sysdate,hire_date)/12) AS "Years_worked"
from employees
where hire_date < to_date('01/10/2016', 'dd-mm-yy')
order by "Years_worked" DESC; 

/*
Q5. Display each employee's last name, hire date, 
and the review date, 
which is the first Tuesday after a year of service, 
but only for those hired after January 1, 2016.  
1)  Label the column REVIEW DAY. 
2)    Format the dates to appear in the format like:
    TUESDAY, August the Thirty-First of year 2016

*/
select LAST_NAME, 
       hire_date,
       ADD_MONths(hire_date, 12) as OneYearAnniv,
       Next_Day(ADD_MONths(hire_date, 12), 'Tuesday') as review_date
from employees
where hire_date > to_date('01/01/2016', 'dd-mm-yy');

/*
Q6: For all warehouses, display warehouse id, warehouse name, city, and state. 
For warehouses with the null value for the state column, display 'unknown'. 
*/
-- select w.warehouse_id,
--        w.warehouse_name,
--        w.location_id,
--        l.city,
--        nvl(l.state, 'unknown')
-- from warehouses w LEFT OUTER JOIN locations l 
-- on w.LOCATION_ID == l.LOCATION_ID
-- using(location_id);

select w.warehouse_id,
       w.warehouse_name,
       w.location_id,
       l.city,
       nvl(l.state, 'unknown')
from warehouses w 
LEFT OUTER JOIN locations l 
on w.LOCATION_ID = l.LOCATION_ID;