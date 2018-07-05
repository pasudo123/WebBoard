# WebBoard
게시판 만들기

1. 2018/01/15 ~ 2018/01/29
2. 2018/04/23 ~ 
3. 2018/06/18 ~  

## 개발환경
* IDE : Eclipse Neon.3 Release (4.6.3)
* Java : 1.8.0_171
* Apache Maven 3. 5. 2
* Spring Framework 4.3.16 Release
* Spring Security 4.2.3 Release
* Database : Oracle Database 11g
* Tomcat 8
* OS : Window 10

## 기능명세
* READ / WRITE / DELETE / MODIFY (수행완료)
* Paging Navi (수행완료)
* 댓글
* 파일
* 회원가입 / 로그인

## 학습리스트
* 스프링에서 CSS 외부 스타일 시트 적용하기
* 크롬 개발자 도구에서 CSS 변경하기
* HTML 태그 내에 SCIPRT 삽입 위치 여부 (실행순서와 렌더링 관련)
* 상대경로 & 절대경로
* Java SimpleDateFormat() 
* [ Oracle Sequence ](http://pasudo123.tistory.com/140)
* VARCHAR SIZE 관련
* JSTL 문법
* @RequestParam & HttpServletRequest & WebRequest
* Interceptor & Filter
* /** & /*
* Spring Security
* [ Properties file ](http://pasudo123.tistory.com/215)

## 데이터베이스
__게시판 테이블__
~~~SQL
CREATE TABLE WEB_BOARD_TB
(
    CONTENTS_NUMS NUMBER(7) PRIMARY KEY,
    CONTENTS_TITLE VARCHAR2(50),
    CONTENTS_WRITER VARCHAR2(50),
    CONTENTS_CONTENT VARCHAR2(1000),
    CONTENTS_DATE VARCHAR(20),
    CONTENTS_READ_COUNT NUMBER(4),
    CONTENTS_HIT_COUNT NUMBER(4)
);

-- 시퀀스 생성
CREATE SEQUENCE 
    CONTENTS_SEQ
START WITH 1 INCREMENT BY 1 MAXVALUE 9999999;
~~~
