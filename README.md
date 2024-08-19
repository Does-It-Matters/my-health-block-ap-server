# my-health-block-ap-server

나만의 건강 블록 

## 목적
의료 질의응답 게시판 서버
<br>(Application Server)
<br>

---

### 주요 기능
| |간단 설명|
| - | - |
|(1)|사용자 계정 관리|
|(2)|질의응답 관리|
|(3)|symptom-similarity-service와 상호작용|

---

### 설계: 육각형 아키텍처
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
│   │       └── persistence
│   │           ├── Entity.java
│   │           ├── Repository.java
│   │           └── PersistenceAdapter.java
│   ├── application
│   │   ├── port
│   │   │   ├── in
│   │   │   │   └── Inport.java
│   │   │   └── out
│   │   │       └── Outport.java
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
| |종류|
|-|-|
|(1)|Spring Boot 3|
|(2)|MySQL 8|
|(3)|JPA|

<br>

### API 문서

<br>

---

### 사용 방법

### 설치

### 실행
db 세팅 : first_setting.sql
