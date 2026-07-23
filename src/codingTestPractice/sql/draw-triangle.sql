/*
https://www.hackerrank.com/challenges/draw-the-triangle-2/problem?isFullScreen=true

P(R) represents a pattern drawn by Julia in R rows. The following pattern represents P(5):

*
* *
* * *
* * * *
* * * * *
Write a query to print the pattern P(20).
*/

with recursive stars as (
    select 1 as n
    union all
    select n+1 from stars where n < 20
)

--repeat: 문자열을 횟수만큼 이어붙여주는 함수
select repeat('* ', n) from stars