use northwind;
-- 1. Products

-- 2. 
SELECT `ProductID`
	, `ProductName`
    , `UnitPrice`
FROM products;

-- 3.
SELECT `ProductID`
	, `ProductName`
    , `UnitPrice`
FROM products
ORDER BY UnitPrice;

-- 4. (konbu, Guaran Fantstica, Geitost, Filo Mix, Tourtire)
SELECT ProductName
	, UnitPrice
FROM products
WHERE UnitPrice <= 7.50;

-- 5. (Geistost, Rhnbru, klosterBier, Sasquatch Ale, Rd Kaviar, Boston Crab Meat, Inlaged sill, Gustaf's Knckebrd, Pt chinois, Grandma's Boysenberry Spread, Sirop d'rable)
SELECT ProductName
	, UnitsInStock 
    ,UnitPrice
FROM products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC; 

-- 6. 
SELECT ProductName
	, UnitsInStock 
    ,UnitPrice
FROM products
WHERE UnitsInStock >= 100
ORDER BY UnitsInStock DESC
, ProductName; 

-- 7. 
SELECT ProductName
, UnitsInStock
, UnitsOnOrder
FROM products
WHERE UnitsInStock = 0 AND UnitsOnOrder >= 1;

-- 8.
SELECT *
FROM Categories;

-- 9. 8
SELECT *
FROM Categories;
 
 -- 10. 
SELECT *
FROM products
WHERE categoryID = 8;

-- 11. 
SELECT FirstName
	, LastName
FROM employees;

-- 12.
SELECT *
FROM employees
WHERE Title LIKE '%Manager%';

-- 13. 
SELECT DISTINCT
	Title
FROM employees;

-- 14.
SELECT FirstName
	, LastName
    , Salary
FROM employees
WHERE Salary BETWEEN 200 AND 2500;

-- 15.
SELECT *
FROM suppliers;

-- 16. (Mishi kobe niku, Ikura, longlife tofu)
SELECT * 
FROM products
WHERE SupplierID = 4;
