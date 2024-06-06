-- 1)
SELECT p.ProductID
	, p.ProductName
	, p.UnitPrice
	, c.CategoryName
FROM products AS p
INNER JOIN categories AS c
	ON p.CategoryID = c.CategoryID
ORDER BY c.CategoryName, p.ProductName; 
	
-- 2)
SELECT p.ProductID
	, p.ProductName
    , p.UnitPrice
    , s.CompanyName
FROM products AS p
INNER JOIN suppliers AS s
	ON p.SupplierID = s.SupplierID
WHERE p.UnitPrice > 75
ORDER BY ProductName;

-- 3)
SELECT p.ProductID
	, p.ProductName
    , p.UnitPrice
    , s.CompanyName
    , c.CategoryName
FROM products AS p
INNER JOIN suppliers AS s 
	ON p.SupplierID = s.SupplierID
INNER JOIN categories AS c
		ON p.CategoryID = c.CategoryID
ORDER BY p.ProductName;

-- 4)
SELECT p.ProductName
	, c.CategoryName
    , p.UnitPrice
FROM products AS p
INNER JOIN categories AS c 
	ON p.CategoryID = c.CategoryID
WHERE UnitPrice = (
	SELECT MAX(UnitPrice)
    FROM products
);

-- 5)
SELECT O.OrderID
	, O.ShipName
    , O.shipAddress
    , S.CompanyName
FROM Orders AS O
INNER JOIN shippers AS S
	ON O.shipVia = S.ShipperID
WHERE ShipCountry = 'Germany';

-- 6)
SELECT O.OrderID
	, O.OrderDate
    , P.ProductName
    , O.ShipName
    , O.ShipAddress
FROM orders AS O
INNER JOIN `order details` AS OD
	ON O.OrderID = OD.OrderID
INNER JOIN products AS P
	ON P.ProductID = OD.ProductID
WHERE P.ProductName = 'Sasquatch Ale';
