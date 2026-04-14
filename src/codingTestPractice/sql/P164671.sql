
-- https://school.programmers.co.kr/learn/courses/30/lessons/164671
/* USED_GOODS_BOARD와 USED_GOODS_FILE 테이블에서 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일
   경로를 조회하는 SQL문을 작성해주세요. 첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬해주세요.
   기본적인 파일경로는 /home/grep/src/ 이며, 게시글 ID를 기준으로 디렉토리가 구분되고,
   파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성되도록 출력해주세요.
   조회수가 가장 높은 게시물은 하나만 존재합니다.
*/
SELECT CONCAT('/home/grep/src/', file.board_id, '/', file.file_id, file.file_name, file.file_ext)
FROM used_goods_file file
WHERE file.board_id IN (
    SELECT board_id
    FROM USED_GOODS_BOARD
    WHERE views = (SELECT MAX(views) FROM used_goods_board)
)
ORDER BY file.file_id DESC;