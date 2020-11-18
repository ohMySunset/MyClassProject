-- 2020.11.16

-- phonebook DDL : 테이블 정의서를 참고하여  DDL을 작성한다.

create table phoneinfo_basic(
   idx number(6) constraint pi_basic_idx_PK primary key,
   fr_name varchar2(20) not null,
   fr_phonenumber varchar2(20) not null,
   fr_email varchar2(20),
   fr_address varchar2(20),
   fr_regdate date default sysdate

);

-- 테이블 구조 확인
desc phoneinfo_basic;

-- 제약 조건 확인 user_constraints
select constraint_name, constraint_type
from user_constraints
where table_name = 'PHONEINFO_BASIC'
;

-- 시퀀스 : 숫자 재생기
create sequence seq_pibasic_idx
MINVALUE 0
start with 0
INCREMENT by 1
;


-- 데이터의 질의 : read
select * from phoneinfo_basic;

-- 데이터의 입력 : create
insert into phoneinfo_basic 
values(SEQ_PIBASIC_IDX.nextval, 'SCOTT', '010-0000-0000', 'SCOTT@GMAIL.COM', '서울', sysdate);

insert into phoneinfo_basic (idx , fr_name, fr_phonenumber)
values(SEQ_PIBASIC_IDX.nextval, 'KING', '010-9999-9999');

-- 데이터 삭제 : delete
delete from phoneinfo_basic;  --where절이 없으면 모든행이 대상

 -- 데이터 업데이트 : update
 update phoneinfo_basic
 set fr_email = 'KING@NAVER.COM', fr_address ='부산'
 where idx =7
 ;
 
 -- C(create), R(read), U(update), D(delete)
 -- insert, select, update, delete
 
 
 --phoneinfo_univ
 create table phoneinfo_univ(
      idx number(6),
      fr_u_major varchar2(20) default 'N',
      fr_u_year number(1) default 1 constraint pi_univ_year_CK check ( fr_u_year between 1 and 4 ),
      fr_ref number(6) not null,
     constraint pi_univ_idx_PK primary key (idx),
     constraint pi_univ_ref_FK FOREIGN key (fr_ref) references phoneinfo_basic(idx)
     
 );
 
 drop table phoneinfo_univ;
 
 
 desc phoneinfo_univ;
 
 select constraint_name, constraint_type 
 from user_constraints
 where table_name = 'PHONEINFO_UNIV'
 ;
 
-- CRUD
--create : 대학 친구 입력
insert into phoneinfo_basic (idx , fr_name, fr_phonenumber)
values (SEQ_PIBASIC_IDX.nextval, 'JAMES', '010-8888-8888');

insert into phoneinfo_univ values(1, 'computer', 2, 7);
insert into phoneinfo_univ values(3, 'computer', 2, seq_pibasic_idx.currval);


--read 
select * from phoneinfo_univ;

select * 
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx = pu.fr_ref;

-- update : phoneinfo_univ  where idx=3;
update phoneinfo_univ 
set fr_u_major = '체육', fr_u_year =4
where idx = 1;

-- delete : idx=10 행을 삭제 -> 외래키인 자식테이블의 데이터부터 지워주어야 함.
delete from phoneinfo_univ where fr_ref = 8;
delete from phoneinfo_basic where idx=8;

 
 
 --phoneinfo_com
 create table phoneinfo_com(
      idx number(6) constraint pi_com_idx_PK primary key,
      fr_c_company varchar2(20) default 'N',
      fr_ref number(6) not null constraint pi_com_ref_PK REFERENCES phoneinfo_basic(idx)
 );
 
 desc phoneinfo_com;
 
 -- create (insert)
 insert into phoneinfo_basic (idx , fr_name, fr_phonenumber)
values (SEQ_PIBASIC_IDX.nextval, '손흥민', '010-1111-1111');

insert into phoneinfo_com values(1, '토트넘', seq_pibasic_idx.currval);

-- read (select)
select *
from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx = pc.fr_ref 
--and pb.fr_name = '손흥민'
;

--update
update phoneinfo_com
set fr_c_company = '레알마드리드'
where idx=1;


-- delete 
-- 자식 테이블의 행부터 삭제하고 부모테이블 행을 삭제
delete from phoneinfo_com where fr_ref = 9;
delete from phoneinfo_basic where idx= 9;


--  전체 데이터 출력 --> outer join
select *
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
where pb.idx = pu.fr_ref(+) and pb.idx = pc.fr_ref(+)
;




