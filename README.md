# Spring-SNS

## 요구사항 분석
### Feed Page
* Post List API
  * 모든 user의 글을 모아서 보여주는 API
  * Paging 및 정렬 필요
  * 제목, 작성자, 본문

### Write Post Page
* Post Create API
  * 제목과 본문을 이용해 포스팅 작성
 
### Sign Up Page
* User Sign Up API
  * User name과 password 를 이용하여 회원가입

### Sign In Page
* User Sign In API
  * User name 과 password 를 이용하여 로그인
 
### My Post Page
* My Post API
  * 로그인한 user 의 글을 모아서 보여주는 API
  * Paging 및 정렬 필요
  * 제목, 작성자, 본문
* Post Delete API
  * 포스트를 삭제
* Post Modify API
  * 제목과 본문 수정
 
### Post Detail Page
* Comment List API
  * 특정 글의 댓글 목록을 보여주는 API
  * Paging 및 정렬 필요
  * 작성자 및 댓글
* Comment Write API
  * 댓글을 작성할 수 있는 API
  * 로그인한 사람만 작성이 가능하고 작성자와 댓글을 받는다
* LikeCountAPI
  * 해당 글에 좋아요한 갯수를 보여주는 API
* Like API
  * 해당 글에 좋아요를 하는 API
  * 좋아요는 한번만 누를 수 있다

### Notification Page
* Notification List API
  * 알람 목록을 보여주는 API
  * Paging 및 정렬 필요

----------

## 기술스택
* Java 17
* Spring Boot 3.4.6
* Spring JPA
* Spring Security
* Gradle
* Lombok
* Junit5
* Kafka
* PostgreSQL
* Redis
* Heroku
* SSE
