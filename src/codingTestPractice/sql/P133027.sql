-- 7월 아이스크림 총 주문량과 상반기의 아이스크림
-- 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.
-- https://school.programmers.co.kr/learn/courses/30/lessons/133027

with A as (
    select sum(total.total_order + july.total_order) as sum, total.flavor
from FIRST_HALF total join july on total.flavor = july.flavor
group by total.flavor
    )
select flavor
from A
order by sum desc
    limit 3