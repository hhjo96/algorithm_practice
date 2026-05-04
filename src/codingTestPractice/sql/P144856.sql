-- https://school.programmers.co.kr/learn/courses/30/lessons/144856

-- 2022년 1월의 도서 판매 데이터를 기준으로 저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가) 을
-- 구하여, 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트를
-- 출력하는 SQL문을 작성해주세요.
-- 결과는 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리를 내림차순 정렬해주세요.
with A as (
    SELECT book_id, sales, sales_date
    from book_sales
    where sales_date between '2022-01-01' and '2022-01-31'),
     B as
         (
             select book.author_id, book.category, A.sales * book.price as TOTAL_SALES
             from A join book on A.book_id = book.book_id
         ),
     C as (
         select B.AUTHOR_ID, author.AUTHOR_NAME, B.CATEGORY, sum(B.TOTAL_SALES) as TOTAL_SALES
         from B join author on B.author_id = author.author_id
         group by 1, 2, 3
     )
select * from C
order by author_id, category desc