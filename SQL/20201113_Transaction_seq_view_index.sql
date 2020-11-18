-- 2020.11.13

-- Transaction (트렌젝션)
-- : 여러개의 SQL명령문을 하나의 *논리적인 작업 단위*로 처리
--   All or Nothing : 다 처리 되던지 다 안되던지 둘 중 하나
--   처리과정에서 오류가 발생하면 처음으로 돌아가 다시 트랜젝션 시작. 
--   데이터의 일관성 유지, 안정적인 데이터 복구 가능  -> 데이터의 무결성이 보장됨
-- ex) 은행 현금인출기 
-- 추가, 수정, 삭제 작업을 하는 DML을 실행함과 동시에 트렌잭션이 진행


-- commit -> 정상처리 -> 변경된 내용 모두 영구 저장
-- rollback -> 작업취소 -> 마지막으로 commit(저장)한 장소로 복귀


-- Commit 
--                                         |-------transaction----------|
--1) insert -> 2)delete -> 3)update -> 4) delete -> 5) insert
--                                (commit)                                               (commit)
-- ※ 물리적 저장이 되지 않으면 다른 계정으로 접속하더라도 보이지 않음.  
--     commit한 순간 모든 사용자가 변경된 데이터를 볼 수 있다.


-- Rollback
--                                         |-------transaction----------|
--1) insert -> 2)delete -> 3)update -> 4) delete -> 5) insert
--                                (commit)   <------------------ (rollback)
-- 1), 2)는 물리적으로 저장되어 있기 때문에 롤백을 하면 3), 4), 5)의 작업만 취소된다. 


------------------------------------------
-- ※ 주의!!!
-- DML ---> DDL로 넘어갈 때 주의해야함!!!!!
-- DDL, DCL 명령문이 수행된 경우 자동으로 commit된다
-- 정전, 컴퓨터down-> 자동으로 rollback
------------------------------------------



select * from emp10;
desc emp10;
select * from dept01;

-- 부서 테이블에 데이터 하나를 저장. - 정상처리 
-- 사원테이블에 새로운 사원을 입력.  - 오류발생  --> rollback

-- transaction의 시작
insert into dept01 values (50, 'RD', 'SEOUL');
insert into emp10 (empno, ename, job, sal) values ('ten', 'ten', 'MANAGER', 2500);
rollback; -- 오류 발생 -> 초기화 (마지막 저장 commit 단계로)

-- 새로운 transaction의 시작
insert into dept01 values (50, 'RD', 'SEOUL');
insert into emp10 (empno, ename, job, sal) values (7777, 'seven', 'MANAGER', 2500);
select * from dept01;
select * from emp10;
commit;

-- 새로운 transaction의 시작
update emp10 
set mgr  = (select empno from emp10 where ename = 'KING') ;
-- 잘못된 처리된 작업이네? rollback
rollback;
-- 이전에 commit한 단계로 이동







-- 테이블 인 뷰 
-- 물리적 테이블에 근거한 가상의 테이블
-- 실질적으로 데이터를 저장하고 있지 않음. 실제 테이블에 저장된 데이터를 뷰를 통해 볼 수 있음. 
--* Create[or replace] view 뷰이름 as 서브쿼리

-- 1) 자주 사용되는 select문을 간단학 접근할 수 있도록 한다. -> 복잡한 SQL문에서 유용하게 사용!

-- 자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다. 
create view view_emp30 
as
select empno, ename, deptno
from emp
where deptno =30;

select * from view_emp30;



-- 전체 정보 출력 (사원 정보, 부서정보)
select *
from emp, dept
where emp.deptno = dept.deptno
--and deptno = 10
;

-- 전체 정보 중에 필요한 데이터만 뷰에 집어넣을 수 있다
--  2) 특정 사용자에게 맞는 데이터만 제공함으로써 데이터 보안의 목적으로 사용할 수 있다. 
create or replace view view_emp_dept
as 
select empno, ename, job, mgr, hiredate, emp.deptno, dname, loc
from emp, dept
where emp.deptno = dept.deptno
;

select * from view_emp_dept where deptno = 10;

-- view의 정보 확인 : user_views 테이블을 통해 확인이 가능  -> 로그인 한 사용자의 view 인스턴스의 정보 
select view_name, text from user_views;



-- view_emp30을 통해 데이터 insert
insert into view_emp30 values (9999, 'TESTER', 40);
select * from emp;
rollback;


-- view의 삭제 : 객체를 삭제하는 방식과 동일하다
-- drop view view_name
drop view view_emp_dept;
select * from user_views; -- 삭제 확인





-- view_hire : 입사일 기준으로 오름차순으로 정렬된 결과를 가상테이블로 정의
select rownum, empno, ename, hiredate
from emp
order by hiredate
;

create or replace view view_hire
as 
select empno, ename, hiredate
from emp
order by hiredate
;

--  view가 가지는 rownum의 순서가 오름차순 결과와 동일하게 변경됨.
select rownum, empno, ename, hiredate from view_hire;

select * from view_hire where rownum <=5;

--*** 인라인 뷰를 이용해서 가장 최근에 입사한 사원 5명을 추출
select * 
from( select * from emp order by hiredate desc)
where rownum <= 5
;







-- sequence : 숫자 자동 생성기  --> pk를 만들기에 용이
-- 시작값, 증가값, 최대값, 최소값, 반환여부
-- dept 테이블  deptno -> pk   10-20-30..
-- deptno에 사용할 sequence를 생성

-->> insert문의 value절에서 pk 일련번호를 설정하는데 주로 사용됨

drop sequence seq_dept_deptno;
create sequence  seq_dept_deptno  --> 그냥 생성할경우 default값 생성
minvalue 10
MAXVALUE 90
start with 10
INCREMENT by 10
;

-- emp 테이블의  empno 기본키에 사용할 sequence를 생성하자
create sequence seq_emp_empno
MINVALUE 0
start with 0 
increment by 1
;

-- sequence 객체로 숫자를 생성, 현재 숫자를 읽어오는 명령
-- 숫자 생성 : nextval - 새로운 숫자를 생성하고 숫자를 반환
-- 현재 숫자를 반환 : currval

-- 새롭게 생성되는 숫자를 확인
select seq_dept_deptno.nextval from dual;  --  dept 테이블의 deptno값을 입력할 때 사용할 수 있다.

-- 현재 숫자를 확인
select seq_dept_deptno.currval from dual;

insert into dept01 values (seq_dept_deptno.nextval, 'test', 'test');

select * from dept01;








-- index(인덱스)
-- 데이터를 빠르게 검색하는데 사용, 컬럼 하나를 개체로 사용하여 저장공간을 새로 만들어 줌. 
-- but, 많은 인덱스는 성능을 저하시킬 수 있다는 단점이 있다. 데이터를 추가하거나 삭제할 때 모든 인덱스를 수정해주어야 하기 때문에
-- create index index_name on target table_name(column_name)

-- index 확인을 하는 user_ind_columns
desc user_ind_columns;

select index_name, table_name, column_name
from user_ind_columns
;

--primary key 또는 unique 속성은 자동으로 index가 생성이 된다. 


select * from emp10;

insert into emp10 
select * from emp10;

insert into emp10 (empno, ename) values (2222, 'COOL');

select empno, ename from emp10 where ename = 'COOL';
select empno, ename from emp10 where empno = 2222;

-- ename을 인덱스로 정의
create index index_emp10_ename
on emp10(ename);

-- empno를 인덱스로 정의
create index index_emp10_empno
on emp10(empno);


-- 인덱스를 사용하는 경우
-- 테이블의 행이 많을 때
-- where문에 해당 컬럼이 많이 사용될때
-- 검색 결과가 전체 데이터의 2~4% 정도 일 때
-- join에 자주 사용되는 컬럼 혹은 null을 포함하는 컬럼이 많을 때

-- but, DML작업이 많은 경우에는 사용하지 말아야 한다!! 성능저하 가능성 높음. 


commit;