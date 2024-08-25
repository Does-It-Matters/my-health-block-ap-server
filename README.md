# my-health-block-ap-server
나만의 건강 블록: 의료 질의응답 게시판 AP 서버
1. 사용자 계정 관리
2. 질의응답 관리

<br> 깃허브 위키 작성 중  

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
