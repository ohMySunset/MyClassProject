-- 2. DEPT 테이블에 데이터를 삽입하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.

insert into dept values(50 , 'MARKETING', 'LA');

update dept set dname = 'CS', loc = 'TEXAS' where deptno = 50;

commit;

delete from dept where deptno = 50;

select * from emp_view;

desc emp;

select * from user_constraints;

create index index_emp_ename
on emp(ename);

rollback;

create view emp_view
as
select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
;

update emp set deptno = ( select deptno from emp where ename = 'SCOTT');

--3. DEPT 테이블에 위에서 삽입한 데이터의 dname, loc 데이터를 변경하는 SQL을 작성하시오.

--   입력 데이터는 임의로 작성하시오.
--4. DEPT 테이블에 위에서 삽입한 데이터를 deptno 컬럼의 값을 기반으로 삭제하는 SQL을 작성하시오.
--5. 사용자가 보유한 테이블 목록을 확인하는 SQL문을 작성하시오.
--6. EMP 테이블의 구조를 확인하는 SQL을 작성하시오.
--7. 사용자가 정의한 제약조건들을 확인하는 SQL문을 작성하시오.


--#2 아래 요구사항에 맞도록 고급 SQL 문을 작성하시오.

--1. EMP 테이블의 ename 컬럼에 인덱스를 생성하는 SQL을 작성하시오. 인덱스의 이름은 emp_index
--2. EMP 테이블과 DEPT 테이블을 조인하는 SQL을 기반으로 view 객체를 생성하는 SQL을 작성하시오.
--   view 의 이름은 emp_view 로 하시오.
--3. EMP 테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호로 변경하는 SQL을 작성하시오.


