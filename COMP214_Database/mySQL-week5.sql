
/*  
--Q1:  Declared, initialized and printed a variable showing an   
Employee's first_name.

// (Anonymous PL/SQL block)*/


SET SERVEROUTPUT ON;

/**/
DECLARE
  v_fn VARCHAR2(255) := 'Anne';

BEGIN
  dbms_output.put_line(v_fn);
END;


/*  
Q2a). Fetch the value of the last_name of the employee with ID 83.  
Store this in a variable and print out its value. */

select last_name
from store
where id = 83;

SET SERVEROUTPUT ON;

/*声明,创建变量,赋值*/
DECLARE
  v_fn VARCHAR2(255) := 'Anne'; 
  /*赋值
  v_fn 变量, 以 v_开头,这样就和数据库里的各种参数都区分开来
  VARCHAR2(255) 变量类型 
  := 赋值
  */


/*sql 语句存放区*/
BEGIN
  /*输出*/
  dbms_output.put_line(v_fn);
END;

/*  
Q2b). What is Willow Reyes' employee_ID and designation?  
Display the output in the format:

'Willow Reyes has an emp_id of 82 , and is a Shipping Clerk'.
*/

DECLARE
  v_fn VARCHAR2(255) := 'Willow';
  v_empid INTEGER;
  v_title VARCHAR2(255);

BEGIN
/*
into 将 sql 语句获得的值, 赋值给两个变量
|| string 拼接
*/
  select employee_ID, JOB_TITLE into v_empid, v_title
  from employees
  where FIRST_NAME =  'Willow';
  dbms_output.put_line('Willow Reyes has an emp_id of' || v_empid || ' and is a' || v_title);
END;
/******************************************

-- (III) ANCHORED DATATYPES:
锚定数据类型
-- 3a) CREATE TABLE dummy_students .....
*/
create table dummy_students (stu_id NUMBER(4),
                             s_name VARCHAR2(20));
insert into dummy_students values(1, 'Prabin');
insert into dummy_students values(2, 'Dipesh');

/*
-- 3b) PL/SQL block with a variable that is 'normally' declared:
*/
select * from dummy_students;

DECLARE
  v_sname VARCHAR2(200);

BEGIN
  select s_name into v_sname
  from dummy_students
  where stu_id=1;

  dbms_output.put_line('The student name is ' || v_sname);
END;

/* 3c) Modify the 'students' table to contain a different datatype.  
Any PL/SQL code previously written that references these base columns,  
will now give an error.  
*/

alter table dummy_students MODIFY s_name char(50);

-- 3d) Executing the old PL/SQL block:

/*  
-- 3e) Thus, creating a PL/SQL block with a variable that is declared with   
an ANCHORED DATATYPE: 
*/


DECLARE
  v_sname dummy_students.sname%TYPE;
/*
dummy_students.sname%TYPE; 和这个字段一样的类型
*/

BEGIN
  select s_name into v_sname
  from dummy_students
  where stu_id=1;

  dbms_output.put_line('The student name is ' || v_sname);
END;


-- IV) Constants:

  
/*  
Q4. Display the value of pi as:  
"The value of pi is 3.141592"  
*/
SET SERVEROUTPUT ON;
DECLARE
  v_pi CONSTANT NUMBER(7,6) := 3.141592; 

  
BEGIN
  /*输出*/
  dbms_output.put_line('The value of pi is' || v_pi);
END;
/*  
--- V) Control stmts:  
5.1) IF stmts  
    5.1.1)IF...THEN  
    5.1.2) IF...THEN...ELSE  
    5.1.3) IF..THEN...ELSIF  
      
5.2) Case stmts:  
    5.2.1) Simple CASE  
    5.2.2) Searched CASE  
*/

------ 5.1.1)IF...THEN:

-- Q5. IF..THEN:


/*  
--- V) Control stmts:  
5.1) IF stmts  
    5.1.1)IF...THEN  
    5.1.2) IF...THEN...ELSE  
    5.1.3) IF..THEN...ELSIF  
*/
SET SERVEROUTPUT ON;
DECLARE
  v_pi CONSTANT NUMBER(7,6) := 3.141592; 

  
BEGIN
  /*输出*/
  dbms_output.put_line('The value of pi is' || v_pi);
END;
/





/*    

5.2) Case stmts:  
    5.2.1) Simple CASE  
    5.2.2) Searched CASE  
*/




------ 5.1.1)IF...THEN:

-- Q5. IF..THEN:
SET SERVEROUTPUT ON;
DECLARE
  v_num CONSTANT NUMBER := 9;   
BEGIN

  if v_num < 10 then
    dbms_output.put_line(' v_num < 10 ');
  end if;  
  /*输出*/
  dbms_output.put_line('The outside');
  
END;
/

DECLARE
  v_num CONSTANT NUMBER := 15;
  v_big NUMBER := 100;
BEGIN
  -- 1)
  --if v_num < 10 AND v_big > 10 then
  --  dbms_output.put_line(' v_num < 10 ');
  --end if;  
  
  -- 2) if else
  if v_num < 10 then
    dbms_output.put_line(' v_num < 10 ');
  else
    dbms_output.put_line(' v_num > 10 ');
  end if; 
  
  /*输出*/
  dbms_output.put_line('The outside');
  
END;

-- 6) 
-- a. For user inputted number
-- b. MOD() 除于
accept x number prompt 'Please enter a number: '
DECLARE
  v_num NUMBER;   
BEGIN
  v_num := &x;

  if MOD(v_num, 2) =0  then
    dbms_output.put_line(' v_num: 2 ');
  else
    dbms_output.put_line(' v_num:1 ');
  end if;  
END;



DECLARE
  v_small NUMBER := &123;
  v_big NUMBER := 15;
  
BEGIN
  -- 1)
  --if v_num < 10 AND v_big > 10 then
  --  dbms_output.put_line(' v_num < 10 ');
  --end if;  
  
  -- 2) if else
  if v_small > 100 then
    dbms_output.put_line(' v_num > 100 ');
  elsif  v_small > 10 then
    dbms_output.put_line(' v_num < 100, >5 ');
  else 
    dbms_output.put_line(' v_num < 5 ');
  end if;
  
  dbms_output.put_line(' v_num < 10 ');
END;



/*
Syntax for SIMPLE Case:
CASE search_expression
    WHEN concn1 Then result1;
    
*/


/*

WHEN condl THEN resultl
WHEN cond2 THEN result2
WHEN CondoN THEN rESUlEN
ELSE else_resule
wIthout using JOINS, write a PL/SQL block
CO
display the ProductID, product_name and extract the Category name as well-- for all records in the PRODUCTS table.
pbox
aled unfoL
ENG US

*/

SET SERVEROUTPUT ON;

SELECT product_id, product_name,
(
CASE category_id
  WHEN 1 THEN 'CPU' 
  WHEN 2 THEN 'Videocard'
  WHEN 3 THEN 'RAM'
  WHEN 4 THEN 'MotherBoard'
  ELSE  '--i-Check again----'
END
) As extr_category_name
from products;


/*
serach case
CASE 
   WHEN selector = 'value1' THEN S1; 
   WHEN selector = 'value2' THEN S2; 
   WHEN selector = 'value3' THEN S3; 
   ... 
   ELSE Sn;  -- default case 
END CASE; 
*/


select first_name, last_name,
(
case 
   when first_name = 'Willow' and last_name = 'Reyes' then 'Toronto'
   when first_name = 'Ivy' and last_name = 'Burns' then 'Vanc'
   when first_name = 'Erin' and last_name = 'Gordon' then 'Calgary'
END
) as work_city
from employees;


/*
   when job_title like '%Marketing%' then 'tax-slab-2'
   when job_title like '%Marketing%' then 'tax-slab-3'
   when job_title like '%Programmer%' OR job_title like '%Public Accountant%' or job_title like '%Public RElations Represenative%' then 'tax-slab-7'

*/

select first_name, last_name,job_title,
(
case 
   when job_title like '%Clerk%'  then 'tax-slab-1'
   when job_title like '%Marketing%' then 'tax-slab-2'
   when job_title like '%Marketing%' then 'tax-slab-3'
   when job_title like '%Programmer%' OR job_title like '%Public Accountant%' or job_title like '%Public RElations Represenative%' then 'tax-slab-7'
END
) as tax_slab
from employees;


select first_name, last_name
from employees
where job_title like '%Clerk%';


/*  when others then DBMS_output.put_line('ERROR!');*/

DECLARE
  vnum_1 NUMBER :=20;   
  vnum_2 NUMBER :=0;
  v_div NUMBER;
  
BEGIN
  v_div := vnum_1 / vnum_2;
  DBMS_output.put_line('division:  ' || v_div ); 
exception

  when ZERO_DIVIDE THEN
         DBMS_output.put_line('Denominator shold not be zero!');
END;


  select product_name, list_price
  from products
  where product_id = 300;
  
  
--

Declare
  v_id number : =300;
  v_name products.product_name%TYPE;
  v_price number(9,2);
Begin
  select product_name, List_price into v_name,v_price
  from products
  where product_id = v_id;
exception
when NO_DATA_FOUND then
       DBMS_output.put_line('NO_DATA_FOUND!');
end;  