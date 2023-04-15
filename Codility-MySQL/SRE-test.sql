-- Implement your solution here
--DELIMITER //
CREATE FUNCTION max_items(price FLOAT, quantity INT)
RETURNS INT
BEGIN
    DECLARE max_quantity INT;
    SET max_quantity = FLOOR(100/price);
    IF max_quantity > quantity THEN
        SET max_quantity = quantity;
    END IF;
    RETURN max_quantity;
END 
--DELIMITER;

SELECT max_items(quantity, FLOOR(100/price)) as Quantity
FROM products
WHERE price <= 100

insert into products values ('Pencil', 3, 30);
insert into products values ('Rubber', 5, 3);
insert into products values ('Notebook', 5, 3);
insert into products values ('Pen', 6, 20);
