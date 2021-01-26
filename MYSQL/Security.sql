SELECT idx, memberid, password from open.member;
-- 단방향 암호화 함수
SELECT idx, memberid, password, md5(password) from open.member order by password;
-- SELECT idx, memberid, password, password() from open.member order by password;
SELECT idx, memberid, password, sha1(password) from open.member order by password;

-- 쌍방향 암호화 함수
-- 암호화 처리
insert into open.member (memberid, password, membername) 
values('test1231234',
Hex(aes_encrypt('1111', sha2('key_value', 512))),
Hex(aes_encrypt('tester', sha2('key_value',512))));
-- 복호화 처리
select memberid, 
convert(aes_decrypt(UNHEX(password), sha2('key_value', 512)) using utf8),
convert(aes_decrypt(UNHEX(membername), sha2('key_value', 512)) using utf8)
 from open.member where idx=18;