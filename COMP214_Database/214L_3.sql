CREATE TABLE dumy_player
  (
    player_id int PRIMARY KEY,
    firstname VARCHAR2( 50 ) NOT NULL,
    lastname VARCHAR2( 50 ),
    ShirtNumber int,
    teamID int
  );

CREATE TABLE dumy_teams
  (
    teamID int PRIMARY KEY,
    teamName VARCHAR2(50) NOT NULL,
    teamColor VARCHAR2(10),
    homeField  VARCHAR2(15) 
  );

insert ALL
into DUMY_PLAYER values(1,'John', 'Smith', 10, 10)
into DUMY_PLAYER values(2,'Bob', 'Marley', 2, 10)
into DUMY_PLAYER values(3,'Steven', 'King', 13, 11)
into DUMY_PLAYER values(4,'Jim', 'P', 7, NULL)
select * from dual;

insert ALL
into dumy_teams values(10, 'Hornets', 'Yellow', 'Toronto') 
into dumy_teams values(11, 'Falcons', 'Brown', 'Barrie')  
into dumy_teams values(12, 'Bloopers', 'Red', 'Kitchener')  
into dumy_teams values(13, 'Kings', 'Puple', 'Oshawa') 
select * from dual;

-- Q1. How many players exist in each team?
select t.teamID,
       t.teamName,
       Count(p.player_id) as NumPlayers
from DUMY_TEAMS t
left join DUMY_PLAYER p
on t.teamID = p.teamID
group by t.teamid, t.TEAMNAME
order by NumPlayers DESC;

-- Q2. Find the Min, Max and Average Credit_limit, among all the customers.
select MIN(credit_limit) as min,
       Max(credit_limit) as max,
       Round(AVG(credit_limit)) as AVG
from CUSTOMERS


/* Q3. Find the total number of locations, per country:
Show first, the country that has the maximum locations.
Only show the countries that have atleast 3 locations in them.
*/


CREATE TABLE inventories
  (
    product_id   NUMBER( 12, 0 )        , -- fk
    warehouse_id NUMBER( 12, 0 )        , -- fk
    quantity     NUMBER( 8, 0 ) NOT NULL,
    CONSTRAINT pk_inventories 
      PRIMARY KEY( product_id, warehouse_id ),
    CONSTRAINT fk_inventories_products 
      FOREIGN KEY( product_id )
      REFERENCES products( product_id ) 
      ON DELETE CASCADE,
    CONSTRAINT fk_inventories_warehouses 
      FOREIGN KEY( warehouse_id )
      REFERENCES warehouses( warehouse_id ) 
      ON DELETE CASCADE
  );

select 
       l.country_id,
       Count(l.country_id) as NumLocation
from locations l
left join countries c
on l.country_id = c.country_id
group by l.country_id
order by NumLocation DESC;


/*
Q4. For each warehouse, display the region that it belongs to.
Display how many products exist in that warehouse, 
and what is the total quantity of all products present, in that warehouse--
only for those warehouses that start with 'B' and whose inventories exceed 10,000.
*/

select *
from WAREHOUSES;

select *
from LOCATIONS;

select *
from COUNTRIES;

select w.warehouse_name,
    w.location_id,
    r.region_name
from WAREHOUSES w
join LOCATIONS l
on w.location_id = l.location_id
join COUNTRIES c
on l.COUNTRY_ID = c.COUNTRY_ID
join regions r
on c.region_id = r.region_id
where w.warehouse_name like 'B%';

select * from PRODUCTS;
select * from PRODUCT_CATEGORIES;
select * from ORDER_ITEMS;
select * from orders;


select * from inventories;

select Count(product_id), 
       i.WAREHOUSE_ID,    
       r.region_name
from inventories i
join WAREHOUSES w
  on w.WAREHOUSE_ID = i.WAREHOUSE_ID
    join LOCATIONS l
      on w.location_id = l.location_id
        join COUNTRIES c
          on l.COUNTRY_ID = c.COUNTRY_ID
            join regions r
              on c.region_id = r.region_id
where w.WAREHOUSE_NAME like 'B%'              
group by i.WAREHOUSE_ID,r.region_name

order by WAREHOUSE_ID desc;
