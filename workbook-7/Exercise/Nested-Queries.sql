USE northwind;

-- 1)  -- giving us the productName and price of the max price in products
SELECT ProductName
	, UnitPrice
FROM products
WHERE UnitPrice = (
	SELECT MAX(UnitPrice)
    FROM products
);

-- 2) -- getting the shipper id by searching for the federalshipping company name and listing the orderId, shipName, ShipAddress
SELECT OrderId
	, ShipName
	, ShipAddress
FROM `orders`
WHERE shipVia = (
	SELECT ShipperID
    FROM shippers
    WHERE CompanyName = 'Federal Shipping'
);

-- 3)  -- getting the product detials of the product name sasquatch ale by getting the productid with the productName from the product table
SELECT *
FROM `order details`
WHERE ProductID = (
	SELECT ProductID
    FROM products
    WHERE ProductName = 'Sasquatch Ale'
);

-- 4) getting the employee name that sold the order with order id of 10266 by getting employee id from the orders table with order id of 10266
SELECT *
FROM employees
WHERE EmployeeID = (
	SELECT EmployeeID
    FROM orders
    WHERE OrderID = 10266
);

-- 5) getting the customer name with the customer id from the orders table with orderId of 10266
SELECT CompanyName AS Customer_Name
FROM customers
WHERE customerID = (
	SELECT customerID
    FROM orders
    WHERE OrderID = 10266
);