

CREATE TABLE Bill( bill_code CHAR(5) PRIMARY KEY,
				 customer_name NVARCHAR(50) NOT NULL, 
				 created_date DATE,
				 discount DECIMAL)
CREATE TABLE Item(product_name NVARCHAR(50), 
				bill_code CHAR(5) FOREIGN KEY REFERENCES Bill(bill_code), 
				quantity INT, 
				price MONEY DEFAULT 0, 
				PRIMARY KEY (product_name, bill_code))
GO

INSERT INTO Bill(bill_code, customer_name, created_date, discount) VALUES 
			('A1', 'Duy Bach', '2014-02-02', 0)
INSERT INTO Item(product_name, bill_code, quantity, price) VALUES 
			('Macbook Pro 2018', 'A1', 1, 50000000), 
			('Iphone 10s', 'A1', 1, 40000000)

GO

CREATE PROC usp_AddBill
	@bill_code CHAR(5), @customer_name NVARCHAR(50), @created_date DATE, @discount INT, @result INT OUTPUT
AS
BEGIN
	INSERT INTO Bill(bill_code, customer_name, created_date, discount) VALUES (@bill_code, @customer_name, @created_date, @discount)
	SET @result = @@ROWCOUNT
	RETURN @result
END

GO	
DECLARE @result INT
EXEC usp_addBill 'ACA', 'Bc', '2201-02-02',0, @result OUT
PRINT @result
GO

CREATE PROC usp_DeleteBill
	@bill_code INT, @result INT OUTPUT
AS
BEGIN
	IF EXISTS (SELECT * FROM Item WHERE bill_code = @bill_code)
		DELETE FROM Item WHERE bill_code = @bill_code
	DELETE FROM Bill WHERE bill_code = @bill_code
	SET @result = @@ROWCOUNT
	RETURN @result
END
GO

CREATE FUNCTION udf_ComputeBillTotal
( @bill_code char)
RETURNS MONEY
AS
BEGIN
	DECLARE @total_price MONEY

	SELECT @total_price = SUM(quantity * price) 
	FROM Item 
	WHERE bill_code = @bill_code
	GROUP BY bill_code

	RETURN @total_price
END
GO

CREATE FUNCTION udf_FindItemsByBillCode(@bill_code CHAR(5))
RETURNS TABLE
AS
RETURN (SELECT *
		FROM Item 
		WHERE bill_code = @bill_code)

GO

select * from udf_FindItemsByBillCode('B0000')