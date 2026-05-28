-- https://school.programmers.co.kr/learn/courses/30/lessons/164673
-- USED_GOODS_BOARD와 USED_GOODS_REPLY 테이블에서 2022년 10월에 작성된 게시글 제목,
-- 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성해주세요.
-- 결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을
-- 기준으로 오름차순 정렬해주세요.

SELECT board.title, board.board_id, reply.reply_id, reply.writer_id, reply.contents, reply.created_date
from USED_GOODS_REPLY reply join USED_GOODS_BOARD board on reply.board_id = board.board_id
where board.created_date >= '2022-10-01' and board.created_date <= '2022-10-31'
order by reply.created_date, board.title