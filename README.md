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
