USE Labor_SQL;
SELECT pc.model, pc.speed, pc.hd FROM pc , product
WHERE maker = 'A' and hd BETWEEN 10 and 20 and type = 'PC'
ORDER BY speed 
;
SELECT * FROM Outcome_o
WHERE date LIKE '____-__-14 __:__:__'
;
SELECT maker FROM pc, product
WHERE speed > 600 and type = 'PC'
;
SELECT * FROM pc, product
WHERE EXISTS (SELECT model FROM product WHERE model IS NULL)
;
SELECT maker FROM pc, product
WHERE EXISTS(SELECT model FROM product)
;
SELECT CONCAT("name:", name , " class:",class," launched:", launched) FROM Ships
;
SELECT name , country FROM Ships, Classes, Outcomes
WHERE result = 'sunk' and result IS NOT NULl
;
SELECT DISTINCT product.maker,
CASE
WHEN form.count IS NOT NULL THEN concat('yes(', form.count, ')')
ELSE 'no' END AS pc FROM Product
LEFT JOIN (SELECT maker, count(*) AS count FROM pc JOIN Product ON pc.model = product.model GROUP BY maker) 
AS form ON product.maker = form.maker
ORDER BY maker 
;
SELECT  model, max(price), 'pc' AS type FROM pc
GROUP BY model
UNION 
SELECT  model, max(price), 'laptop' FROM laptop
GROUP BY model
UNION 
SELECT  model, max(price), 'printer' FROM printer
GROUP BY model
;
