
SELECT
case when HOUR(datetime) = 9 then 9
     when HOUR(datetime) = 10 then 10
     when HOUR(datetime) = 11 then 11
     when HOUR(datetime) = 12 then 12
     when HOUR(datetime) = 13 then 13
     when HOUR(datetime) = 14 then 14
     when HOUR(datetime) = 15 then 15
     when HOUR(datetime) = 16 then 16
     when HOUR(datetime) = 17 then 17
     when HOUR(datetime) = 18 then 18
     when HOUR(datetime) = 19 then 19
     end as hour, count(*)
from animal_outs
where hour(datetime) between 9 and 19
group by HOUR(datetime)
order by hour(datetime)