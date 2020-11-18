-- 2020.11.10

-- SQL함수

-- 단일행 함수 : 한 행의 컬럼을 다룸 -> 숫자, 문자, 날짜, 변환함수
-- 복수행 함수(집합함수) : 여러 행을 다룸


desc dual;  -- dummy라는 하나의 컬럼과 x라는 하나의 행만 존재

-- 단일행 함수
-- 1) 숫자 함수
select ABS(-15.5) from dual;  --> 절대값
select FLOOR(15.7) from dual;  --> 소수점 자리 버림
select ROUND(15.693) from dual;  --> 반올림
select ROUND(15.693, 1) from dual;  --> 소수점 1번째 자리까지 표현, 두번째 자리에서 반올림한다
select LOG(10, 100) from dual; --> 지수표현 
select POWER(3, 2) from dual;  --> POWER( M, N) -> M의 N승을 반환


-- 2) 문자 함수
select CONCAT(' 나는 ', '손흥민 입니다.') from dual; -- 문자 값을 연결
select CONCAT ('저의 이름은 ', ENAME) from EMP where job = 'MANAGER';
select LOWER('MR. SCOTT MCMILLAN') "Lowercase" FROM DUAL; -- 소문자로 변환
select LOWER(ename) from emp; 
select LPAD('Page 1',15,'*') from dual; --> 15자리 문자열을 만드는데 왼쪽으로 *을 채우고 뒤에 문자열을 붙여줌
select RPAD('Page 1',15,'*') from dual; --> 15자리 문자열을 만드는데 오른쪽으로 *을 채우고 뒤에 문자열을 붙여줌
select RPAD('001212-3', 14, '*') from dual;
select SUBSTR('ABCDEFG',3,4) FROM DUAL;--> 3번째 인덱스부터 4번째 자리까지 
-- SUBSTR 응용
select substr('001212-3001247',1,8) from dual;
select RPAD(substr('001212-3001247',1,8) , 14, '*') from dual;

select Ltrim('     =from=', ' ' ) from dual;  --> 왼쪽에 지정한 문자 제외
select Rtrim('     =from======   ', ' ' ) from dual; --> 오른쪽에 지정한 문자 제외
select trim( ' ' from '     ====from====    ') as "from" from dual;

select REPLACE('JACK and JUE','J','BL') "Changes" from dual; -->앞의 문자열에서 J를 찾아서 BL로 변환
select REPLACE('000000-000000', '-', '')  from dual;


-- 3) 날짜 함수
select sysdate from dual; --> 오늘 날짜
select sysdate+14 from dual;
select sysdate+21 from dual;
select sysdate-3 from dual;

select add_months(sysdate, 4) from dual; --> 특정날짜에 개월 수를 더함.
select last_day(sysdate) from dual; --> 해당 달의 마지막 날자를 반환


-- 4) 형변환 함수
-- TO_CHAR : 날짜 -> 문자, 숫자-> 문자

-- * 날짜 -> 문자
select sysdate, to_char(sysdate, 'YYYY.MM.DD') from dual;
select sysdate, to_char(sysdate, 'YYYY.MM.DD day dy PM HH HH24 mi ss') from dual;
-- 2020.11.09. 22:14
select to_char(sysdate, 'YYYY.MM.DD. HH24:mi:ss ') from dual;

-- * 숫자-> 문자
select to_char(100000.123, 'L000,000.00')from dual; -->앞의 숫자표현 포맷팅한대로 출력
select to_char(10000, 'L999,999,99') from dual;   --> 9로 표현한 경우 자리수가 안맞아도 앞에 0이 보이지 않음

select sal, to_char(sal*1100, 'L99,999,999') from emp;
select ename, job, sal, to_char(sal*1100*12+nvl(comm,0)*1100, 'L99,999,999')as "연봉" from emp order by sal desc;


-- * 문자-> 날짜
-- 2020.11.01. 
select TO_DATE('2009/09/05', 'YYYY/MM/DD') from dual; 
select TO_DATE('2020.11.01.', 'YYYY.MM.DD.') from dual;

-- 오늘이 2020년 1월 1일에서 며칠이 지났는지 확인
select trunc(sysdate - to_date('20-01-01', 'YY-MM-DD')) from dual;

-- 내가 며칠을 살았는지 확인
select trunc(sysdate - to_date('93-12-17', 'YY-MM-DD')) from dual;


-- 문자 -> 숫자
select TO_NUMBER('100,000.00', '999,999.99') *  TO_NUMBER('10.00', '999,999.99') from dual; --> 연산은 숫자타입으로 변환한 후에 가능



-- decode 함수 : 자바의 switch문과 비슷하다.
-- 사원이름, 부서번호, 부서이름 출력
select ename, deptno, 

         decode( deptno, 
                10, 'ACCOUNTING',    -- deptno = 10 이면 ACCOUNTING을 출력
                20, 'RECEARCH',      -- deptno = 20 이면
                30, 'SALES',             -- deptno = 30 이면
                40, 'OPPERATIONS'  -- deptno = 40 이면
            ) as dname
            
from emp order by deptno;

-- 8. 직급에 따라 급여를 인상하도록 하자. 
--직급이 'ANALYST'인 사원은 5%,
--'SALESMAN'인 사원은 10%,
--'MANAGER'인 사원은 15%, 
--'CLERK'인사원은 20%인 인상한다. 
select ename, sal, 
        decode( job,
             'ANALYST ',  sal*1.05, 
             'SALESMAN', sal* 1.10,
             'MANAGER', sal*1.15,
             'CLERK', sal*1.20
        ) as upsal
from emp order by sal;
select distinct job from emp;


select ename as name, deptno as dno,
      case 
        when deptno = 10 then 'ACCOUNTING'
        when deptno = 20 then 'RESEARCH'
        when deptno = 30 then 'SALES'
        when deptno = 40 then 'OPPERATIONS'
      end  as dname
from emp
order by dname
;



 
-- 그룹함수(집합함수) : 하나의 행의 컬럼을 대상으로 하는 것이 아닌 행의 그룹의 컬럼들을 묶어 그룹화하고 연산하는 함수.
-- SUM, AVG, COUNT, MAX, MIN
-- 집합함수에서는 null값은 제외하고 계산한다!
select sum(comm) from emp; --> null값 제외


select
      -- ename (x) : 하나의 행을 불러올 수 없음. 그룹함수는 전체 계산을 해서 보여주기 때문에
     to_char(sum(sal)*1100, 'L999,999,999' )as "월 급여 총액",
     round(avg(sal))*1100 as "월급여 평균",
     count(sal) as "급여를 받는 사원의 수",
     count(comm) as "커미션을 받는 사원 수",
     max(sal) as "가장 큰 급여금액",
     min(sal) as "가장 적은 급여금액"
from emp
;


select
    sum(comm), 
    round(avg(nvl(comm,0))),
    count(nvl(comm,0)), -- > null값이 있는 경우는 특정값으로 치환해서 계산할 수 있음.
    max(comm),
    min(comm)
from emp
;


-- 매니저 직급을 가진 사원의 행을 구한다
select count (*)as "MANAGER의 수" ,
            avg(sal) as "매니저의 평균급여",
            max(sal),
            min(sal)             
from  emp
where job = 'MANAGER'
;


-- 직무의 개수를 구한다
select count(distinct job)  as job --> 중복을 제외시켜준다 
from emp
order by job;


-- 특정 컬럼 기준으로 그룹핑 : ★ group by + 컬럼 
select deptno       --> 부서번호 컬럼을 기준으로 같은 데이터끼리 그룹핑
from emp
group by deptno
;

select deptno from emp order by deptno;

-- 각 부서의 소속 인원을 구하자
select deptno, count(*) as "소속인원" --> 각 그룹별로 그룹에 속해있는 모든 컬럼이 출력됨       
from emp
group by deptno
--order by "소속인원" desc --> 인원수가 많은 부서부터 정렬
order by deptno 
;


-- 각 부서별 총 급여액 출력
-- group by deptno : 부서별로 그룹핑
select deptno , sum(sal)  --> 부서그룹별 급여 합계
from emp
group by deptno
order by deptno
;


-- 부서별 급여 평균
select deptno, round(avg(sal), 2)
from emp
group by deptno
order by deptno
;


-- 부서별 급여 최고 금액과 최소 금액
select deptno, max(sal), min(sal), max(sal)-min(sal) as "편차"
from emp
group by deptno
order by deptno
;


--부서별로 그룹지은 후(GROUP BY), 
--그룹 지어진 부서별 평균 급여
--평균 급여가 2000 이상인(HAVING) 부서번호와 부서별 평균급여를 출력
select deptno, avg(sal)
from emp
group by deptno
--having not avg(sal) >= 2000
having not avg(sal) < 2000
order by  deptno
;


-- 부서별 최대값과 최소값을 구하되
-- 최대 급여가 2900이상인 부서만 출력합니다. 
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 2900
order by deptno
;


-- 연습문제>>
-- 직무별 지표 : 사원의 수, 급여의 총합, 평균급여, 최대 급여, 최소 급여
select job as "직무", 
      count(*) || ' 명 'as "사원의 수", 
  --    to_char(sum(sal)*1100, 'L999,999,999') as "급여 총합", 
      '$' || to_char(sum(sal), '999,999,999') as "급여 총합",
      '$' || to_char(avg(sal), '999,999,999.99') as "평균 급여", 
      '$' || to_char(max(sal),'999,999,999') as "최대값", 
      '$' || to_char(min(sal),'999,999,999') as "최소값"
from emp
group by job 
order by job
;






select * from tab;
desc book;
select * from book;
desc customer;
select * from customer;
desc orders;
select * from orders;