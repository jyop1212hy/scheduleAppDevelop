하륜아—와 이건 솔직히 말해서 **README 치고 너무 길다** 😂
지금 네 README는 “API 명세서 + 프로젝트 소개 + 두 개 서비스 전체 문서 + 표 + 예시 JSON”이 한 파일에 다 들어가 있어서,
**깃허브에서 스크롤 ㅈㄴ 길어지는 스타일**임 ㅋㅋㅋㅋ


# 📅 Calendar App Develop (Spring Boot REST API)

![Spring Boot](https://img.shields.io/badge/SpringBoot-3.5.7-brightgreen?style=flat-square&logo=springboot)
![Java](https://img.shields.io/badge/Java-17-blue?style=flat-square&logo=openjdk)
![MySQL](https://img.shields.io/badge/MySQL-8.0-yellow?style=flat-square&logo=mysql)
![Gradle](https://img.shields.io/badge/Gradle-Build-lightgrey?style=flat-square&logo=gradle)
![Status](https://img.shields.io/badge/Level-Lv6🔥-red?style=flat-square)

> **Spring Boot 기반 일정 관리 백엔드 API 프로젝트**  
> JPA 기반 CRUD, 연관관계 매핑, 유저–일정 연결까지 모두 구현한 미니 백엔드 프로젝트입니다.

---

## 📌 프로젝트 개요

| 항목 | 내용 |
|------|------|
| **프로젝트명** | Calendar App Develop |
| **개발 기간** | 2025.11.10 ~ 2025.11.20 |
| **언어 / 프레임워크** | Java 17 / Spring Boot 3.5.7 |
| **DB / ORM** | MySQL 8.0 / Spring Data JPA |
| **빌드 도구** | Gradle |
| **REQUEST 구조** | REST API |
| **API 테스트 도구** | Postman |
| **연관관계** | User (1) — Schedule (N) |

---

## 🧠 ERD (예시)

```
<img src="./images/CalendarAppDevelopERDImages.png" width="500">
```

![ERD](./images/CalendarAppDevelopERDImages.png)

---

## 📚 API 문서

각 기능별 상세 명세서는 아래 파일에서 확인하세요:

- 📄 **[API_SCHEDULE.md](docs/API_SCHEDULE.md)** — 일정 CRUD API 전체 문서
- 📄 **[API_USER.md](docs/API_USER.md)** — 유저 CRUD API 전체 문서

---

## 🧩 기능 요약

### ✔ User CRUD
- POST `/scheduleUsers` — 유저 생성
- GET `/scheduleUsers` — 전체 유저 조회
- GET `/scheduleUsers/{id}` — 유저 조회
- PATCH `/scheduleUsers/{id}` — 유저 수정
- DELETE `/scheduleUsers/{id}` — 유저 삭제

### ✔ Schedule CRUD
- POST `/schedules` — 일정 생성 (User FK 사용)
- GET `/schedules` — 전체 일정 조회
- GET `/schedules/{id}` — 일정 단건 조회
- PATCH `/schedules/{id}` — 일정 수정
- DELETE `/schedules/{id}` — 일정 삭제

---

## ⚙ 기술 포인트

- Spring Boot + JPA 기반 CRUD 개발
- 양방향 아닌 **단방향 연관관계 매핑 (Schedule → User)**
- DTO 분리 (Request / Response)
- 파라미터 검증 및 예외 처리 확장 가능
- Postman 테스트 환경 구축

---

## 📦 프로젝트 구조 (요약)

src/main/java
└── com.scheduleappdevelop
├── controller
├── service
├── repository
├── entity
└── dto

---

## ✨ 향후 확장 가능성

- 예외 처리 (Global Exception Handling)
- 로그인 기능 (Session / JWT)
- 비밀번호 암호화 (BCrypt)
- 페이징 처리
- Swagger API 문서 적용

---

## 👨‍💻 개발자



