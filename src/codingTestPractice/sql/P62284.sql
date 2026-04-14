SELECT cart_id
from CART_PRODUCTS
group by cart_id
having group_concat(name order by name separator ', ') like '%Milk, %Yogurt%'
    or group_concat(name order by name separator ', ') like '%Yogurt, %Milk%'


-- https://school.programmers.co.kr/learn/courses/30/lessons/62284
-- 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회하는 SQL 문을 작성해주세요.

-- version.2
SELECT cart_id
FROM CART_PRODUCTS
WHERE name IN ('Milk', 'Yogurt')
GROUP BY cart_id
HAVING COUNT(DISTINCT name) = 2;