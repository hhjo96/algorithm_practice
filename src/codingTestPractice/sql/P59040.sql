

/*https://school.programmers.co.kr/learn/courses/30/lessons/59040
동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요.
 이때 고양이를 개보다 먼저 조회해주세요.*/


SELECT animal_type, count(animal_type)
from animal_ins
group by animal_type
order by
case when animal_type = 'cat' then 1
when animal_type = 'dog' then 2
end;