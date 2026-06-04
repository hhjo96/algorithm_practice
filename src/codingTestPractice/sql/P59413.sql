
-- https://school.programmers.co.kr/learn/courses/30/lessons/59413
-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 0시부터 23시까지, 각 시간대별로
-- 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해야 합니다.

-- case when으로는 없는시간을 만들 수 없으므로 다른 방법 사용

-- 1번 풀이: 재귀 CTE(WITH RECURSIVE)
WITH RECURSIVE HOURS AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1
    FROM HOURS
    WHERE HOUR < 23
    )

SELECT
    H.HOUR,
    IFNULL(COUNT(A.DATETIME), 0) AS COUNT
FROM HOURS H
    LEFT JOIN ANIMAL_OUTS A
ON H.HOUR = HOUR(A.DATETIME)
GROUP BY H.HOUR
ORDER BY H.HOUR;


-- 2번 풀이
-- @HOUR = -1 라는 변수를 만들고 select @HOUR 하면 -1이 나옴.
SET @HOUR := -1;

SELECT
    (@HOUR := @HOUR + 1) AS HOUR,
    (SELECT COUNT(*)
     FROM ANIMAL_OUTS
     WHERE HOUR(DATETIME) = @HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23;
