-- 입력 SQL
INSERT INTO `open`.`guestbook_message`(`guest_name`,`password`,`message`) VALUES('test','1234','반갑습니다');
-- INSERT INTO guestbook_message(guest_name,password,message) VALUES(?,?,?);

-- 질의 SQL
SELECT * FROM `open`.`guestbook_message`;
-- SELECT * FROM guestbook_message;

-- 삭제 SQL
DELETE FROM `open`.`guestbook_message` WHERE message_id=1;
-- DELETE FROM guestbook_message WHERE message_id=?;

-- 전체 게시물의 개수 구하기
SELECT count(*) from open.guestbook_message;
-- SELECT count(*) from guestbook_message

-- 페이지 별 메세지 리스트
SELECT * FROM `open`.`guestbook_message` order by message_id desc limit 3,3;
-- SELECT * FROM guestbook_message order by message_id desc limit ?, ?;

-- 게시물 하나를 검색하는 질의
select * from open.guestbook_message where message_id=10;
-- select * from guestbook_message where message_id=?
