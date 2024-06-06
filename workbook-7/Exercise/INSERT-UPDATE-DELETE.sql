USE northwind;

-- 1)
INSERT INTO suppliers
(
     CompanyName
     , ContactName
     , ContactTitle
     , Address
     , City
     , Region
     , Country
     , UnitPrice
)
VALUES (
	'Salehs airBnb company'
    , 'Smith'
    , 'Airbnb furniture'
    , '109 w lincoln st'
    , 'Stockton'
    , NULL
    , 'USA'
);

-- 2)
INSERT INTO products
(
	ProductName
    , Discontinued
    , SupplierID
)
VALUES
(
	'Bed'
    , 0
    , ( 
		SELECT SupplierID 
		FROM suppliers
		WHERE CompanyName = 'Salehs airBnb company'
		)
);

-- 3)
SELECT ProductName
	, s.ContactName
FROM products AS p
INNER JOIN suppliers AS s
	ON s.SupplierID = p.SupplierID;
    
-- 4)
UPDATE products
SET UnitPrice = UnitPrice * 1.15
WHERE ProductName = 'Bed';    

-- 5)
SELECT p.ProductName
	, s.ContactName
FROM suppliers AS s
INNER JOIN products AS p
	ON p.SupplierID = s.SupplierID
    WHERE p.SupplierID = 30;
    
-- 6)
SELECT *
FROM products
WHERE productName = 'Bed';   

DELETE FROM products
WHERE productName = 'Bed';

-- 7)
SELECT *
FROM suppliers
WHERE supplierID = 30;

DELETE FROM suppliers
WHERE supplierID = 30;

-- 8)
SELECT *
FROM products;

-- 9)
SELECT *
FROM suppliers;