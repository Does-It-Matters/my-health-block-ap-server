# my-health-block-ap-server
본 프로젝트는 학습용으로 개발 중인 프로젝트로, 실제 의료 목적으로 사용될 수 없습니다

## 나만의 건강 블록
### 1. 본래의 서버
- 사용자 계정 관리
- 질의응답 관리
- 의료 서비스 API에 요청을 보냄
- 블록체인 서버에 요청을 보냄
- 응급 상황 시 환자의 긴급 데이터 조회

다른 리포지토리에 다시 코드를 복구 예정

### 2. 현재는 축소된 의료 질의응답 게시판 AP 서버
- 사용자 계정 관리
- 질의응답 관리
- 다양한 시도를 민첩하게 도전하기 위해 규모를 축소 

## 자세한 내용은 [깃허브 위키](https://github.com/Does-It-Matters/my-health-block-ap-server/wiki)  
### 밑바탕이 되는 설계: 육각형 아키텍처 
현재는 여러 모듈로 분리하여 아래의 설계와 같이 패키지 구성이 되어 있지는 않지만 아래의 설계를 바탕으로 설계되어 있습니다.

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
