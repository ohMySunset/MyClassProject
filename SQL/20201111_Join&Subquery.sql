-- 2020.11.11


-- Join(조인) : 여러 테이블의 컬럼을 붙여준다




-- 1-1) Cross Join : 조건 없이 Table + Table
-- From절에 콤마로 연결하여 연속해서 기술
-- 조건이 없으면 아무런 의미를 갖지 못함
select *
from emp, dept
;

-- 1-2) ANSI Join :  위와 같은 개념, Cross Join으로 묶어줌
select *
from emp cross join dept
;




-- 2-1) ★ Equi Join : 동일 컬럼을 기준으로 조인 (자식테이블의 외래키 - 부모테이블의 pk)
select * 
from emp, dept
where emp.deptno = dept.deptno
;

-- scott의 사원번호와 이름,  -- emp
-- 부서이름, 지역을 출력해보자.  -- dept           ==>join!
select emp.empno, emp.ename, emp.deptno, dept.dname, dept,loc
from emp, dept
where emp.deptno = dept.deptno and ename = 'SCOTT'
;

-- select절의 emp.deptno에서 emp는 생략이 불가하다. 애매모호한 값이 되버리기 때문에
select empno, ename, emp.deptno, dname, loc
from emp, dept
where emp.deptno = dept.deptno and ename = 'SCOTT'
;

-- 별칭 사용하기
select e.empno, e.ename, e.deptno, d.dname, d,loc
from emp e, dept d  --> from절에서 긴 테이블명은 별칭을 사용하여 줄여줄 수 있음,
where e.deptno = d.deptno and e.ename = 'SCOTT'
;


-- 2-2) ANSI Inner Join
-- T1 Inner Join T2 On 조인의 조건
select *
from emp inner join dept
on emp .deptno = dept.deptno
;

-- Using 이용
select *
from emp join dept
-- on emp .deptno = dept.deptno
Using(deptno) --> 공통 컬럼을 하나만 가지게 해준다. 공통 컬럼을 구별할 필요가 없다.
;

-- Natural Join 이용 : 조인을 정의한 두 테이블의 컬럼 이름이 동일할 때, Using도 생략가능. 
select ename, deptno, dname   --> 따로 별칭을 써서 구분해주지 않아도 된다. 
from emp Natural join dept 
;




-- 3) Non-Equi Join : 동등비교 X, 비교연산 O , 특정 기준에 포함이되는지 확인
--급여 등급을 5개로 나누어 놓은 salgrade에서 정보를 얻어 와서
--각 사원의급여 등급을 지정해보도록 합시다. 
--이를 위해서 사원(emp) 테이블과 급여등급(salgrade) 테이블을 조인하도록 합시다.
--다음은 사원의 급여가 몇등급인지 살펴보자.
-- 1. cross join -> 2. where 조건
select e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal
;

select * from salgrade;



-- 4) Self Join : 자신의 테이블을 조인
-- SMITH의 매니저 이름이 무엇인지 알아보자.
-- 필요한한 만큼 select문을 만들고 필요한 데이터를 찾아서 합친다. 
select e.ename, m.mgr, m.ename as "SMITH의 매니저"
from emp e, emp m
where e.mgr = m.empno and e.ename = 'SMITH'
;

select ename from emp where empno = 7902;


-- 예외)
select e.ename, m.mgr, m.ename  as "상관이름"
from emp e, emp m
where e.mgr = m.empno 
;
--> null값을 가진 KING의 데이터는 비교가 불가능 하기 때문에 출력이 되지 않는다. 
--> 모든 사원의 데이터를 출력하기 위해서는 조건이 만족하지 않더라도 출력해주는 outer join을 사용해주어야 한다!  
--                            ▼ 
--                            ▼



-- 5-1) Outer Join : 조인 조건이 만족하지 않는 행도 나타낸다
-- 정보가 부족한 쪽에 (+)를 붙여준다. (오라클에서만 사용)
select e.ename, m.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+) 
;

-- 5-2) ANSI Outer Join
--  T1 [ left | rihgt | full ] outer join T2  조건
select *
from emp e left outer join emp m 
on e.mgr = m.empno
;


-- 회원 , 구매
-- customer, orders
select * from customer;
select * from orders order by custid;

select * 
from customer c, orders o
where c.custid = o.custid (+)
;

-- 회원별(group by) 구매 회수
select c.name, count(o.orderid), sum(o.saleprice), avg(o.saleprice) 
from customer c, orders o
where c.custid = o.custid (+)
group by c.name
;







-- 서브쿼리 (Sub Query)

-- 스칼라 부속질의    SELECT 부속질의   : 단일 행, 단일 열
-- 인라인 뷰            FROM 부속질의       : 복합 행, 복합 열
-- 중첩질의             WHERE 부속질의     : 단일 열, 단순비교 -> 단일 행,  집합비교-> 복합 행


-- * 중첩질의 : 단순 비교
-- 평균 급여보다(Sub Query) 더 많은 급여를 받는 사원을 검색하자.
-- 1. 단일행함수와 집합함수 이므로 join으로 묶기 힘들다
--     서브쿼리를 먼저 작성하고>>
select avg(sal)
from emp;
-->평균급여 = 2073.214285714285714285714285714285714286
-- 2. 메인쿼리에 넣어준다.
select *
from emp
where sal > (select avg(sal)
                        from emp)
;

-- scott 사원과 같은 부서에 근무하는 사원의 리스트
--1. 들어갈 서브쿼리를 먼저 만들고 >>
select deptno
from emp
where ename = 'SCOTT'
;
-- 2. 메인쿼리에 넣어 합쳐준다.
select ename
from emp
where deptno = (select deptno
                                from emp
                                 where ename = 'SCOTT')
;



-- 다중행 서브쿼리 -> 서브쿼리에서 반환되는 결과가 하나 이상의 행일 때 사용

-- In연산자
-- : 메인쿼리의 비교조건이 서브쿼리의 결과 중에 하나라도 일치하면 참
-- sal 3000이상 받는 사원이 소속된 부서를 찾아보자
select distinct deptno
from emp
where sal>=3000
;

select *
from emp
where deptno in( select distinct deptno
                                from emp
                                where sal>=3000)
;

-- ALL연산자
-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 
-- 더 많은 급여를받는
-- 사람의 이름, 급여를 출력하자

select max(sal) 
from emp
where deptno = 30
;
-- 30번 부서에서 일하는 사원들의 급여
select sal from emp where deptno = 30;

select ename, sal 
from emp
--where sal > (select max(sal) from emp where deptno = 30)
--where sal > all (select sal from emp where deptno = 30)   --> and
where sal > any (select sal from emp where deptno = 30) --> or
;


-- Inline View
-- ROWNUM  --> 가상 컬럼  
select rownum, empno, ename,hiredate
from emp
where rownum < 4
order by hiredate
;

select rownum, empno, ename, hiredate -- rownum이 입력순으로 처리 
from emp order by hiredate
;

select rownum, empno, ename, hiredate --> 아래의 테이블을 대상으로 질의 --> 다시 정렬
from (select rownum empno, ename, hiredate from emp order by hiredate) -- 인라인 뷰 생성 -> 가상의 테이블 
where rownum < 4 -- 입사일이 빠른 3명을 출력
;


-- 가장 급여를 많이 받는 사원 3명 출력
select rownum, ename, sal from emp order by sal desc;

select rownum, ename, sal
from (select rownum, ename, sal from emp order by sal desc)
where rownum < 6
;



-- 1) 스칼라 부속질의 : select절  프리젠테이션 영역에 쓸 수 있는 부속질의, 
-- 단일 행, 단일 열, 즉, 단일값의 결과만 나와야 한다.

select name from customer where custid = 1;

select custid, (select name from customer where customer.custid = orders.custid) as "고객이름",
         saleprice, orderdate
from orders
;


-- 마당서점의 고객별 group by
-- 판매액을 보이시오 orders
-- (결과는 고객이름과 고객별 판매액을 출력).
-- join 사용
select c.custid, c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid(+)
group by c.custid, c.name
order by sum(o.saleprice)
;

--  서브쿼리 사용
select o.custid, 
         (select name from customer c where o.custid = c.custid),
     sum(o.saleprice) 
from orders o
group by o.custid
;




-- 2) Inline View (인라인 뷰) : from절 이후에 들어가는 서브 쿼리, 가상테이블, rownum이 새롭게 생김
select custid, name 
from customer 
where custid <= 2
;

select c.name, sum(o.saleprice), avg(o.saleprice)

from orders o, (select custid, name 
                            from customer 
                            where custid <= 2
                            ) c
where o.custid = c.custid
group by c.name
;



-- 3) Nested Subquery(중첩질의) : where절에서에서 데이터를 선택하는 조건을 설명하는 부속질의
-- 반드시 단일 행 단일 열을 반환해야 한다.

--  비교연산자
-- 평균 주문금액 이하의
-- 주문에 대해서 주문번호와 금액을 보이시오.
select orderid, saleprice
from orders
where saleprice <=(select avg(saleprice)
                                   from orders)                                   
;





--  연습문제 >>>
-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
--> custid = 1이면, 고객의 평균과 비교해서 큰 주문 금액만 출력
select avg(saleprice) from orders where custid = 1;

select orderid, o1.custid, saleprice
from orders o1
where saleprice > (select avg(saleprice) from orders o2 where o2.custid = o1.custid)                            
;



-- 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오.
select * from customer where address like '%대한민국%';

select sum(saleprice)
from orders
where custid in(select custid from customer where address like '%대한민국%')
;


--3번 고객이 주문한 도서의 최고 금액보다 
--더 비싼 도서를 구입한 
-- 주문의 주문번호와 금액을 보이시오.

select max(saleprice) from orders where custid = 3;

select orderid, saleprice
from orders
--where saleprice > (select max(saleprice) from orders where custid = 3)
where saleprice > all (select saleprice from orders where custid = 3)
;


-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
-- EXISTS 연산자 : 데이터의 존재 유무를 확인하는 연산자
-- 값이 존재하면 참이 되고, 주질의는 해당 행의 데이터를 출력

select * from customer where address like '%대한민국%';

select sum(saleprice) 
from orders o
where exists (select * from customer c where address like '%대한민국%' and o.custid = c.custid)
;