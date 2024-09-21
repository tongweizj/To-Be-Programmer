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

-- Q2. Find the Min, Max and Average Credit_limit, among all the customers.

/* Q3. Find the total number of locations, per country:
Show first, the country that has the maximum locations.
Only show the countries that have atleast 3 locations in them.

/*
Q4. For each warehouse, display the region that it belongs to.
Display how many products exist in that warehouse, 
and what is the total quantity of all products present, in that warehouse--
only for those warehouses that start with 'B' and whose inventories exceed 10,000.
*/


*/