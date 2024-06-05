use sakila;
-- Selects all the Columns where the last name ends with G 


SELECT *
FROM actor
WHERE last_name LIKE '%G';