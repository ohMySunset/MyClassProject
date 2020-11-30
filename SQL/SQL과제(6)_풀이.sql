--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.

--(5) 박지성이 구매한 도서의 출판사 수
select distinct o.bookid
from customer c, orders o
where c.custid = o.custid and c.name = '박지성'
;

select count( distinct publisher)
from book
where bookid in (select distinct o.bookid
                                from customer c, orders o
                                where c.custid = o.custid and c.name = '박지성')
;

-- 조인을 이용한 해결
select count(distinct b.publisher)
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid and c.name ='박지성'
;


--(6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select b.bookname, b.price, b.price-o.saleprice as gap
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid and c.name ='박지성'
;




select custid from customer where name = '박지성';

select b.bookname, b.price, b.price - o.saleprice as gap
from book b, orders o
where b.bookid = o.bookid and o.custid = (select custid 
                                                                            from customer
                                                                            where name = '박지성')
;

--(7) 박지성이 구매하지 않은 도서의 이름
-- 도서의 이름 출력
select bookid from orders where custid = (select custid
                                                                            from customer
                                                                            where name = '박지성');

--다만 다중 쿼리 사용은 권장하지 않음!
select bookname
from book
where bookid not in (select bookid 
                                      from orders 
                                      where custid = (  select custid
                                                                     from customer
                                                                     where name = '박지성'
                                                                     )
                                       )
;

select *
from orders o, book b
where o.bookid = b.bookid
and o.custid ! = (select custid from customer where name = '박지성')
;


select distinct bookname
from book b
where bookid not in (select bookid from orders o, customer c where o.custid = c.custid and c.name ='박지성')
;



select * from orders;

--2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL문을 작성하시오.

--(8) 주문하지않은고객의이름(부속질의사용)
select distinct custid from orders;

-- 구매 고객 리스트
select name
from customer
where custid not in (select distinct custid from orders)
;


-- 조인을 이용한 문제 해결
select name
from orders o, customer c
where o.custid(+) = c.custid and o.orderid is null
;

--(9) 주문금액의총액과주문의평균금액
select sum(saleprice), avg(saleprice)
from orders;


--(10) 고객의이름과고객별구매액
select c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.name
;

--(11) 고객의이름과고객이구매한도서목록
select c.name, b.bookname
from customer c, orders o, book b
where c.custid = o.custid and b.bookid = o.bookid
;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
--orders orderid

select max(b.price-o.saleprice)
from book b, orders o
where b.bookid = o.bookid
;

select orderid
from orders o, book b
where o.bookid = b.bookid and (b.price-o.saleprice)  = (select max(b.price-o.saleprice) 
                                                                                                    from book b, orders o
                                                                                                    where b.bookid = o.bookid)
                                                                                                    
;

select orderid
from orders o, book b
where o.bookid = b.bookid and (b.price-o.saleprice)  >= all (select b.price-o.saleprice 
                                                                                                    from book b, orders o
                                                                                                    where b.bookid = o.bookid)
;

--(13) 도서의 판매액 평균 보다 자신의 구매액평균이 더 높은 고객의 이름
-- 판매액 평균
select avg(saleprice) from orders ;
-- 자신의 구매액 평균
select c.name, avg(saleprice)
from customer c, orders o
where c.custid = o.custid 
group by c.name
having avg(saleprice) > (select avg(saleprice) from orders)
;

--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

--(1) 박지성이 구매한 도서의 출판사와 
-- 같은 출판사에서 도서를 구매한 고객의 이름

select publisher from book b, orders o, customer c 
where b.bookid = o.bookid and o.custid = c.custid and c.name = '박지성';

select c.name
from orders o, book b, customer c
where b.bookid = o.bookid and o.custid = c.custid 
and b.publisher in (select publisher 
                                   from book b, orders o, customer c 
                                   where b.bookid = o.bookid and o.custid = c.custid 
                                   and c.name = '박지성') and c.name != '박지성';


--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
-- 고객별 구매 현황 count
select c.name
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid
group by c.name
having count(distinct b.publisher)>1
;



select c.name, b.bookname, b.publisher
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid
order by c.name
;