-- https://www.hackerrank.com/challenges/print-prime-numbers/problem?isFullScreen=true
/*
 Write a query to print all prime numbers less than or equal to .
 Print your result on a single line, and use the ampersand () character as your separator
 (instead of a space).

For example, the output for all prime numbers  would be:

2&3&5&7

 */

-- numbers 가 임시테이블이름
-- 2부터 1씩 늘어나는데 2가 1000보다 작으므로 3추가, 4이 1000보다 작으므로 4추가 이런식임
WITH RECURSIVE numbers AS (
    SELECT 2 AS n -- 2 하나를 n이라는 이름의 컬럼으로 만든 것
    UNION ALL
    SELECT n + 1 FROM numbers WHERE n < 1000
),
               primes AS (
                   SELECT n
                   FROM numbers a
                   WHERE NOT EXISTS (
                       SELECT 1 FROM numbers b
                       WHERE b.n < a.n AND b.n > 1 AND a.n % b.n = 0
                   )
               )
SELECT GROUP_CONCAT(n ORDER BY n SEPARATOR '&') FROM primes;