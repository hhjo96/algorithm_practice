SELECT board.writer_id, user.nickname, concat(city, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2),
concat(substring(tlno, 1, 3), '-', substring(tlno, 4, 4), '-', substring(tlno, 8, 4))
from USED_GOODS_BOARD board join USED_GOODS_USER user on board.writer_id = user.user_id
group by 1, 2, 3, 4
having count(*) >= 3
order by board.writer_id desc