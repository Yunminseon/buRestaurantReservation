
##  진행 상황
-로그인/회원가입 데이터베이스 연동 (회원정보 보기)
-예약내역 조회/변경/취소 데이터베이스 연동 예정

# 🍽️ Restaurant Reservation System (회원가입/로그인 기능 포함)

이 프로젝트는 Spring Boot를 사용하여 개발한 간단한 웹 기반 **회원가입 및 로그인 기능**을 포함한 **식당 예약 시스템**입니다.  
사용자는 회원가입을 통해 계정을 만들고, 로그인 후 서비스를 이용할 수 있습니다.

---

## 🚀 주요 기능

- ✅ 회원가입 (이메일 중복 검사 포함)
- ✅ 로그인 / 로그아웃
- ✅ 세션을 이용한 로그인 유지
- ✅ 전체 회원 목록 조회 (관리자 용도)
- 📌 추후 기능 예정: 식당 등록, 예약하기, 예약 확인/취소 등

---

## 🛠️ 사용 기술

| 기술 스택 | 설명 |
|-----------|------|
| Java      | 17   |
| Spring Boot | 백엔드 프레임워크 |
| Spring Data JPA | DB 연동 및 ORM 처리 |
|  MySQL | 회원정보, 예약정보 데이터베이스 |
| Thymeleaf | 템플릿 엔진 (화면 구현) |
| Lombok | 코드 간결화 (DTO, Entity 등) |

---

## 🗂️ 프로젝트 구조

com.bu.backend
├── controller # 웹 요청 처리 (회원가입, 로그인 등)
├── dto # 데이터 전송 객체 (DTO)
├── entity # DB 테이블 매핑 객체 (JPA Entity)
├── repository # JPA를 이용한 DB 인터페이스
├── service # 비즈니스 로직 처리
├── exception # 사용자 정의 예외 처리
└── templates # HTML 뷰 (Thymeleaf)
## 📷 화면 예시

> ✅ 로그인 화면, 회원가입 화면, 메인 페이지, 회원 목록 조회 화면  
> (스크린샷 이미지 삽입 예정)

---

## 🔧 실행 방법

```bash
# 1. 프로젝트 클론
git clone https://github.com/your-username/your-repo-name.git

# 2. IDE (STS, IntelliJ 등)로 열기

# 3. 실행
SpringBootApplication 클래스 실행
