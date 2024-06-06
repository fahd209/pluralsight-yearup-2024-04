USE world;
/*
	SQL syntax
    DML - Data manipulation language
    INSERT - add new record
    UPDATE - Modify a record
    DELETE - Deleting a record
    SELECT - Retreving a record
*/

INSERT INTO city
(
	Name
    , CountryCode
    , District
    , Population
)
VALUES
(
	'Stockton'
    , 'USA'
    , 'California'
    , 320000
);

SELECT *
FROM city
WHERE Name = 'Stockton';