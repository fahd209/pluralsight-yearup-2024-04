USE northwind;

-- 1)
SELECT *
FROM suppliers;

-- 2)
SELECT SUM(Salary) AS 'Sum of employees Salary'
FROM employees;

-- 3)
SELECT  ProductName
	, UnitPrice
FROM products
WHERE UnitPrice = (
	-- getting minimum price from products and using it as my filter
	SELECT MIN(UnitPrice) 
    FROM products
);

-- 4)
SELECT AVG(UnitPrice) AS 'Average unit price'
FROM products;

-- 5)
SELECT MAX(UnitPrice) AS 'Most expensive item'
FROM products;

-- 6)
SELECT SupplierID, UnitsInStock
FROM products;

-- 7)
SELECT CategoryID
	, AVG(UnitPrice) AS 'Average Price'
FROM products
GROUP BY CategoryID;

-- 8)
SELECT supplierID
	, UnitsInStock
FROM products
WHERE UnitsInStock >= 5;

-- 9)
SELECT productId
		, ProductName
        , (UnitPrice * UnitsInStock)  AS 'Inventory Value'
FROM products
ORDER BY (UnitPrice * UnitsInStock) DESC, ProductName;        