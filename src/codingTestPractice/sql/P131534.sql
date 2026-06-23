-- USER_INFO 테이블과 ONLINE_SALE 테이블에서 2021년에 가입한 전체 회원들 중 상품을 구매한 회원수와
-- 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)
-- 을 년, 월 별로 출력하는 SQL문을 작성해주세요. 상품을 구매한 회원의 비율은 소수점 두번째자리에서
-- 반올림하고, 전체 결과는 년을 기준으로 오름차순 정렬해주시고 년이 같다면 월을 기준으로 오름차순 정렬해주세요.


with total as (
    SELECT user_id
    from user_info
    where date_format(joined, '%Y') = '2021'
),
     buy as (
         select distinct user_id, year(sales_date) as year, month(sales_date) as month
from online_sale
    )

select buy.year as YEAR, buy.month as MONTH, count(distinct buy.user_id) as PURCHASED_USERS,
round(count(distinct buy.user_id)/(select count(*) from total), 1) as PURCHASED_RATIO
from buy join total on buy.user_id = total.user_id
group by 1, 2
order by 1, 2
