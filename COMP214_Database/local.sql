
/*  
--Q1:  Declared, initialized and printed a variable showing an   
Employee's first_name.

// (Anonymous PL/SQL block)*/


SET SERVEROUTPUT ON;

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

DECLARE
  v_fn VARCHAR2(255) := 'Anne';

BEGIN
  dbms_output.put_line(v_fn);
END;
/*  
Q2b). What is Willow Reyes' employee_ID and designation?  
Display the output in the format:

'Willow Reyes has an emp_id of 82 , and is a Shipping Clerk'.
dbms_output.put_line("Willow Reyes has an emp_id of" + employee_ID + " and is a" + JOB_TITLE);
*/



DECLARE
  v_fn VARCHAR2(255) := 'Willow';
  v_empid INTEGER;
  v_title VARCHAR2(255);

BEGIN
  select employee_ID, JOB_TITLE into v_empid, v_title
  from employees
  where FIRST_NAME =  'Willow';
  dbms_output.put_line('Willow Reyes has an emp_id of' || v_empid || ' and is a' || v_title);
END;
/******************************************

-- (III) ANCHORED DATATYPES:

-- 3a) CREATE TABLE dummy_students .....

-- 3b) PL/SQL block with a variable that is 'normally' declared:

/* 3c) Modify the 'students' table to contain a different datatype.  
Any PL/SQL code previously written that references these base columns,  
will now give an error.  
*/

create table dummy_students (stu_id NUMBER(4),
                             s_name VARCHAR2(20));

insert into dummy_students values(1, 'Prabin');
insert into dummy_students values(2, 'Dipesh');

select * from dummy_students;


DECLARE
  v_sname VARCHAR2(200);

BEGIN
  select s_name into v_sname
  from dummy_students
  where stu_id=1;

  dbms_output.put_line('The student name is ' || v_sname);
END;


alter table dummy_students MODIFY s_name char(50);
-- 3d) Executing the old PL/SQL block:

/*  
-- 3e) Thus, creating a PL/SQL block with a variable that is declared with   
an ANCHORED DATATYPE: 

dummy_students.sname%TYPE; 和这个字段一样的类型
*/


DECLARE
  v_sname dummy_students.sname%TYPE;

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