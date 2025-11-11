# 📅 Calendar App Develop (Spring Boot REST API)

![Spring Boot](https://img.shields.io/badge/SpringBoot-3.5.7-brightgreen?style=flat-square&logo=springboot)
![Java](https://img.shields.io/badge/Java-17-blue?style=flat-square&logo=openjdk)
![MySQL](https://img.shields.io/badge/MySQL-8.0-yellow?style=flat-square&logo=mysql)
![Gradle](https://img.shields.io/badge/Gradle-Build-lightgrey?style=flat-square&logo=gradle)
![Status](https://img.shields.io/badge/Level-Lv6🔥-red?style=flat-square)

> **발전된 일정 관리 앱 API**  
> 기존의 일정 관리앱에서 SessionID 기반의 인증/인가 시스템을 구현하여  
> 클라이언트의 서버 및 DB 접근을 효율적으로 통제할 수 있도록 설계한 **Spring Boot 기반 백엔드 프로젝트**입니다.

---

## 🧩 프로젝트 개요

| 항목 | 내용 |
|------|------|
| **프로젝트명** | Calendar App Develop |
| **개발 기간** | 2025.11.10 ~ 2025.11.20 |
| **언어 / 프레임워크** | Java 17 / Spring Boot 3.5.7 |
| **DB / ORM** | MySQL 8.4.7 (macOS ARM64) / Spring Data JPA |
| **빌드 도구** | Gradle |
| **API 테스트 도구** | Postman |
| **API 연관관계** | 단방향 |

---

## 🧠 ERD (예시)

```
![ERD](./images/CalendarAppDevelopERDImages.png)
```

---

## 🧾 API 명세서

### 📅 일정 생성 (POST)

#### 1️⃣ 개요

| 구분         | 내용                                |
| ---------- | --------------------------------- |
| **요청 유형**  | `POST`                            |
| **데이터 유형** | `JSON`                            |
| **엔드포인트**  | `http://localhost:8080/schedules` |
| **설명**     | 새로운 일정(게시물)을 생성하고 DB에 저장합니다.      |

#### 2️⃣ 요청 본문 (Request Body)

| 필드명               | 타입     | 필수 | 설명          |
| ----------------- | ------ | -- | ----------- |
| `title`           | String | ✅  | 일정 제목       |
| `email`           | String | ✅  | 작성자 이메일     |
| `createdUserName` | String | ✅  | 작성자 이름      |
| `password`        | String | ✅  | 수정/삭제용 비밀번호 |

#### 3️⃣ 요청 예시

```json
{
  "createdUserName": "각시탈",
  "toDoTitle": "각시탈의 일본여행기",
  "toDoContent": "당장 짐싸!",
  "password": "123456"
}
```

#### 4️⃣ 응답 예시

```json
{
  "id": 1,
  "createdUserName": "각시탈",
  "toDoTitle": "각시탈의 일본여행기",
  "toDoContent": "당장 짐싸!",
  "createdAt": "2025-11-06T15:03:05.633274",
  "modifiedAt": "2025-11-07T15:03:05.633274"
}
```
---

### 👤 유저 생성 (POST)

#### 1️⃣ 개요
| 구분 | 내용 |
|------|------|
| **요청 유형** | `POST` |
| **데이터 유형** | `JSON` |
| **엔드포인트** | `http://localhost:8080/users` |
| **설명** | 클라이언트가 입력한 유저 정보를 서버가 받아 새로운 유저를 생성 및 저장합니다. |

#### 2️⃣ 요청 본문 (Request Body)
| 필드명 | 타입 | 필수 | 설명 |
|---------|------|------|------|
| `userName` | String | ✅ | 유저명 |
| `email` | String | ✅ | 이메일 |
| `password` | String | ✅ | 비밀번호 (회원가입, 수정/삭제 시 필요) |

#### 3️⃣ 요청 예시
```json
{
  "userName": "각시탈",
  "email": "Gaksital4ever@naver.ccm",
  "password": "123456"
}
````

#### 4️⃣ 응답 예시

```json
{
  "id": 1,
  "userName": "각시탈",
  "email": "Gaksital4ever@naver.ccm",
  "password": "123456",
  "createdAt": "2025-11-10T15:03:05.633274",
  "modifiedAt": "2025-11-11T15:03:05.633274"
}
```

---

## 🧱 주요 기능
- 모든 테이블은 고유 식별자(ID)를 가진다.  
- 일정 CRUD  
  - `POST /schedules` 일정 생성  
  - `GET /schedules` 전체 일정 조회  
  - `GET /schedules/{id}` 단일 일정 조회  
  - `PUT /schedules/{id}` 일정 수정  
  - `DELETE /schedules/{id}` 일정 삭제  
- 유저 CRUD  
  - `POST /users` 유저 생성  
  - `GET /users` 전체 유저 조회  
  - `GET /users/{id}` 단일 유저 조회  
  - `PUT /users/{id}` 유저 수정  
  - `DELETE /users/{id}` 유저 삭제  
- 회원가입: 비밀번호를 필수로 입력하여 계정 생성  
- 로그인: 이메일과 비밀번호를 이용한 인증  

---


## ⚙️ 기능별 엔드포인트 요약

| 리소스      | 메서드      | 엔드포인트             | 설명       |
| -------- | -------- | ----------------- | -------- |
| User     | `POST`   | `/users`          | 유저 생성    |
| User     | `GET`    | `/users/{id}`     | 유저 단건 조회 |
| User     | `PUT`    | `/users/{id}`     | 유저 수정    |
| User     | `DELETE` | `/users/{id}`     | 유저 삭제    |
| Schedule | `POST`   | `/schedules`      | 일정 생성    |
| Schedule | `GET`    | `/schedules/{id}` | 일정 단건 조회 |
| Schedule | `PUT`    | `/schedules/{id}` | 일정 수정    |
| Schedule | `DELETE` | `/schedules/{id}` | 일정 삭제    |

---

## 🧩 기술 포인트

* **Spring Data JPA** 를 활용한 CRUD 및 영속성 관리
* **Session 기반 인증**으로 사용자 구분
* **Postman Collection**으로 API 테스트 및 문서화
* **RESTful URL 설계** 준수 (`/users`, `/schedules/{id}` 등)

---

## 📜 License

Copyright © 2025 Team Calendar App.
All rights reserved.

```

---

이 버전은 바로 `README.md` 파일에 복붙해도 GitHub에서 예쁘게 렌더링돼.  
원하면 여기에 **ERD 다이어그램 이미지**나 **Postman 테스트 캡처 섹션**도 추가해서 완성형 포트폴리오 버전으로 만들어줄 수도 있어 — 해줄까?
```
