-- GET a list of all countries in north american
-- with a popilation greater than 10,000,000
-- sorted by population
-- include name, continent, popilation
-- sorted by popilation

use world; -- defines what date base i'm working with

SELECT `Name`    -- Select these columns
		, `Continent`
        , `Region`
        , `Population`
FROM country -- From this table
WHERE (Continent = 'North America' -- The continent name has to be north american and the population has to be greater than 10000000
	AND Population > 10000000)
	OR Region = 'Caribbean'
ORDER BY Population; -- sorts list by population in asdent order