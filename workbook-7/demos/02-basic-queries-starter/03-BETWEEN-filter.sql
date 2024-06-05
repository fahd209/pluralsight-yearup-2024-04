use world; -- uses the world data base

SELECT Name
	, LifeExpectancy
From country
WHERE LifeExpectancy BETWEEN 40 AND 70
ORDER BY LifeExpectancy ;
