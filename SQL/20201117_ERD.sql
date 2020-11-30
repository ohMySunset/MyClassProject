--2020.11.17

-- 데이터 모델링

-- 데이터 베이스의 생명주기
--  ★★★┌ > 인터뷰, 설문조사를 통해 요구사항 수렴, 비슷한 업무를 처리하는 기존 데이터 베이스 참고
-- 요구사항 수집 및 분석 (주제, 기능, 서비스) ->  DB설계   ->   구현   ->   운영   ->   감시 및 개선 
--                                                     1)  개념 모델링  -->  DDL,DML                        

-- 표현  : 개체 □   /  관계 ◇  /   속성○(타원)

-- 2) 논리적 모델링 : 개념적 모델링에서 만든 ERD를 사용하려는 DBMS에 맞게 ★사상한다(매핑한다)
-- 테이블 이름(컬럼명1(PK),  컬럼명2 ...) --> 용어사전, 용어정의 

-- 3) 물리적 모델링 
-- 논리적 모델링에서 정의한 내용을 실제 DBMS에 저장하기 위한 논리적 구조 생성



--< ER모델 >
-- 사물 = 개체 : E(entity) 개체 간의 관계 : R(realationship)

-- ER다이어그램 : 개체와 개체 간의 관계를 표준화된 그림으로 나타낸 것

-- 개체  □ =>1. 강한 개체 타입 : 다른 개체의 도움 없이 독자적으로 존재가능  ex) phoneinfo_basic
--                 2. 약한 개체 타입 : 독자적으로는 존재할 수 없고 *상위개체 타입을 갖고 있다.  ex)phoneinfo_univ

-- 속성 ○(타원) => 직사각형과 실선으로 연결 , 속성이 식별키일 경우 이름 밑에 밑줄 그어줌.
--                         속성이 약한 개체일 경우 식별키가 아닌 식별자를 가짐 (점선 밑줄)
--                         다중값 속성 : 여러 개 값을 같는 속성 (3개 이상일 경우 새로운 릴레이션으로)                  

-- 관계  ◇ => 관계 : 개체 사이의 연관성 표현 ( 몇 대 몇 ?)   1: 1 / 1: N / N: 1 / N : M
--                 1진 관계 : 자기 자신과 관계를 맺음
--                 2진 관계 : 두 개체가 관계를 맺음
--                 3진 관계 : 세 개체가 관계를 맺음  ==> 무조건 새로운 table이 나와야 함.
--                 관계 대응수 -> 관계에 참여하는 개체의 (최소값, 최대값)
--                  ex)          1                    :                    N
--                           학과□ (0, *)  -----◇----- 학생□ (1,1)


drop sequence seq_dept_deptno;

create sequence seq_dept_deptno
MINVALUE 10
start with 60
increment by 10

;
