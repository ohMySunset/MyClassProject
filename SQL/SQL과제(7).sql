-- 폰북 DDL 작성하기


drop table contact_basic;

-- 테이블 생성
create table contact_basic(
    pidx number(4) constraint basic_pidx_PK primary key,
    ct_name varchar2(20) constraint basic_name_NN not null,
    ct_phonenumber varchar2(20)constraint basic_phonenumber_NN not null ,
    ct_email varchar2(20) default 'N' constraint basic_email_UQ unique,
    ct_address varchar2(20) default 'N'   
);

create table contact_univ(
   pidx number(4) constraint univ_pidx_PK primary key,
   ct_u_major varchar2(20) default 'N'  ,
   ct_u_year number(1) default 1 constraint univ_year_CK check (ct_u_year between 1 and 4),
   ct_ref number(4) constraint univ_ref_NN not null constraint univ_ref_FK REFERENCES contact_basic(pidx)
);

desc contact_univ;

create table contact_com(
  pidx number(4) constraint com_pidx_PK primary key,
  ct_c_company varchar2(20) default 'N' ,
  ct_c_deptname varchar2(20) default 'N',
  ct_c_job varchar2(20) default 'N',
  ct_ref number(4) constraint com_ref_NN not null constraint com_ref_FK references contact_basic(pidx)
);

create table contact_cafe(
  pidx number(4) constraint cafe_pidx_PK primary key,
  ct_c_cafename varchar2(20) default 'N' constraint cafe_cafename_NN not null,
  ct_c_nickname varchar2(20) default 'N ' constraint cafe_nickname_NN not null,
  ct_ref number(4) constraint cafe_ref_NN not null constraint cafe_ref_FK REFERENCES contact_basic(pidx)
);



-- 시퀀스 생성
--drop sequence seq_cafe_pidx;

create sequence seq_basic_pidx
MINVALUE 0
start with 0
INCREMENT by 1
;

create sequence seq_univ_pidx
MINVALUE 0
start with 0
INCREMENT by 1
;

create sequence seq_com_pidx
MINVALUE 0
start with 0
INCREMENT by 1
;

create sequence seq_cafe_pidx
MINVALUE 0
start with 0
INCREMENT by 1
;


-- create (insert) 데이터 삽입
insert into contact_basic values ( seq_basic_pidx.nextval, '김보배', '010-1234-1234', null, null); 

insert into contact_basic values (seq_basic_pidx.nextval, '홍길동', '010-1234-1234',null, null);
insert into contact_univ values (seq_univ_pidx.nextval, '컴퓨터', 1, seq_basic_pidx.currval); -- 외래키는 위의 현재값을 받아야 하므로  currval

insert into contact_basic values (seq_basic_pidx.nextval, '장나라', '010-2345-2345','nara@gmail.com', '서울 강남');
insert into contact_com values(seq_com_pidx.nextval, '삼성', '마케팅','대리', SEQ_BASIC_PIDX.currval);

insert into contact_basic values (seq_basic_pidx.nextval, '김태희', '010-3456-3456','taehee@gmail.com', '경기 포천');
insert into contact_cafe values (seq_cafe_pidx.nextVAL, '코딩이 좋아', '코딩의 왕', SEQ_BASIC_PIDX.currval);





--검색을 위한 SQL
-- read( select) : 데이터 검색
--1. 전체 검색 (조인을 이용해서 모든 데이터 출력)
-- null값이 있는경우 비교할 수 없기 때문에 outer join을 해주어야 함.!!!!!
select *
from contact_basic b, contact_univ u, contact_com c1, contact_cafe c2
where b.pidx = u.ct_ref(+) and b.pidx = c1.ct_ref(+) and b.pidx = c2.ct_ref(+)
;

--2. 회사 친구의 데이터 출력
select * from contact_basic b, contact_com c
where b.pidx = c.ct_ref ;


--3. 학교 친구의 데이터 출력
select * from contact_basic b, contact_univ u
where b.pidx = u.ct_ref
;





-- 수정을 위한 SQL
-- update : 데이터 수정
--1. 회사 친구의 정보 변경
update contact_com 
set ct_c_job = '과장'
where pidx = 3
;

--2. 학교 친구의 정보 변경 
update contact_univ
set ct_u_year = 4
where pidx = 3
;

-- 삭제를 위한 sql
-- delete :  데이터 삭제
--1. 회사 친구 정보를 삭제
delete from contact_com where pidx=3;

--2. 학교 친구 정보를 삭제
delete from contact_univ where pidx=3;