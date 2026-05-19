
-- https://school.programmers.co.kr/learn/courses/30/lessons/131124
-- MEMBER_PROFILE와 REST_REVIEW 테이블에서 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요.
-- 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고, 결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이
-- 같다면 리뷰 텍스트를 기준으로 오름차순 정렬해주세요.

with A as (
        select member_id
        from rest_review
        group by member_id
        order by count(member_id) desc
        limit 1
    )

select mem.member_name, review.review_text, review.review_date
from REST_REVIEW review join MEMBER_PROFILE mem on review.member_id = mem.member_id
where mem.member_id in (select member_id from A)
order by review.review_date, review.review_text
