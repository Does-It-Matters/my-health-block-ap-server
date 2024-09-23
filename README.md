# my-health-block-ap-server
본 프로젝트는 학습용으로 개발 중인 프로젝트로, 실제 의료 목적으로 사용될 수 없습니다
<br> 나만의 건강 블록: 의료 질의응답 게시판 AP 서버
1. 사용자 계정 관리
2. 질의응답 관리

## 자세한 내용은 [깃허브 위키](https://github.com/Does-It-Matters/my-health-block-ap-server/wiki)  
- ai 활용, 요구 사항 분석, 설계, 개발, 테스트, 문서화, 모니터링, 보안, 동시성 처리 등 프로젝트 목표 설명
- 도전 과제
- 진행 과정
- ...

## 설계: 육각형 아키텍처
```
com.example.myhealthblock
├── domain
│   ├── adapter
│   │   ├── in 
│   │   │   └── web 
│   │   │       ├── Controller.java 
│   │   │       ├── request 
│   │   │       │   └── Request.java
│   │   │       └── response 
│   │   │           └── Response.java
│   │   └── out
│   │       ├── jpa
│   │       │   ├── Entity.java
│   │       │   ├── Repository.java
│   │       │   └── PersistenceAdapter.java
│   │       ├── mongodb
│   │       │   ├── Document.java
│   │       │   ├── Repository.java
│   │       │   └── PersistenceAdapter.java
│   │       └── mybatis
│   │           ├── Entity.java
│   │           ├── Mapper.java
│   │           └── PersistenceAdapter.java
│   ├── application
│   │   ├── port
│   │   │   ├── in
│   │   │   │   ├── InputPort.java
│   │   │   │   └── dto
│   │   │   │       ├── InputPortRequest.java
│   │   │   │       └── InputPortResponse.java
│   │   │   └── out
│   │   │       ├── OutputPort.java
│   │   │       └── dto
│   │   │           ├── OutputPortRequest.java
│   │   │           └── OutputPortResponse.java
│   │   └── service
│   │       └── Service.java
│   └── domain
│       ├── model
│       │   └── Domain.java
│       ├── dto
│       │   └── DTO.java
│       └── mapper
│           └── DomainMapper.java
```

### 사용하는 기술
1. Spring Boot
2. MySQL
3. JPA

### 실행
db 세팅 : first_setting.sql
