# flower kiosk android

**팀 프로젝트의 안드로이드 Repository 입니다.**

[백엔드 Repositroy](https://github.com/acornkiosk/flower-back) <br/>
[프론트엔드 Repository](https://github.com/acornkiosk/flower_front) <br/>
[키오스크 메인 Repository](https://github.com/acornkiosk/flower_kiosk)

## 프로젝트 특징

* Spring Boot, android를 기반으로 꽃을 판매하는 키오스크 서비스
    
* 프론트엔드와 백엔드를 분리하여 프로젝트 개발
    * 각 파트의 별도 Repository를 생성 후 작업
    * 백엔드 : Spring Boot를 이용
    * 안드로이드 : Android Studio 이용

* 회원가입은 X

* 초기 더미데이터는 DBeaver를 통한 DB에 직접 삽입
  
* RestApi 방식으로 CRUD 구현
    * 키오스크 정보 추가, 조회, 수정, 삭제, 키오스크 전원 변경   
    * 메뉴 정보 추가, 조회, 수정, 삭제
    * 사용자 정보 추가, 조회, 수정, 삭제
    * 주문 정보 추가, 조회, 수정, 삭제

## 개요

* 명칭 : flower_kiosk

* 개발 인원 : 1명

* 개발 기간 : 2024.03.11 ~ 2024.03.29

* 주요 기능 
	* 키오스크 기능 : 메뉴 리스트 조회, 메뉴 상세 정보 기능, 메뉴 및 옵션 선택 기능, 장바구니 기능, 주문 기능

* 개발 언어 : Kotlin

* 개발 환경 : Android Studio

* 형상 관리 툴 : git

* 간단 소개 : 꽃 키오스크 서비스 프로젝트
## 사용 패키지
 * viewpager2
   * 카테고리별 프래그먼트를 위한 라이브러리
 * retrofit2, okHttp
   * rest api를 json으로 통신하기 위한 라이브러리
 * gson
   * json으로 데이터를 보내기 위한 라이브러리
## 개발 역할분담

| 이름       | 진행 목록                                                    |
| ------------ | ------------------------------------------------------------- |
| 김동주         | 메뉴 리스트 조회, 메뉴 상세 정보 기능, 메뉴 및 옵션 선택 기능, 장바구니 기능, 주문 기능 |  |                          

## 개발 타임라인(백엔드, 프론트 공통)

| 일자       | 진행 목록                                                    |
| ---------- | ------------------------------------------------------------ |
| 2024.02.17 | [ 프로젝트 화면계획서 V0.1 작성](https://drive.google.com/drive/folders/19cVOkx5jpWMl9KqFia3Dd_BrflqpRaVl) <br />백엔드 Repository 생성 |
| 2024.02.19 | [ 프로젝트 화면계획서 V0.3 작성](https://drive.google.com/drive/folders/19cVOkx5jpWMl9KqFia3Dd_BrflqpRaVl) |
| 2024.02.20 | [ 프로젝트 화면계획서 V0.5 작성](https://drive.google.com/drive/folders/19cVOkx5jpWMl9KqFia3Dd_BrflqpRaVl) <br/> 키오스크 관리 DB, API 추가|
| 2024.02.21 | [ 프로젝트 화면계획서 V0.6 작성](https://drive.google.com/drive/folders/19cVOkx5jpWMl9KqFia3Dd_BrflqpRaVl) <br/> 주문 관리 DB, API 추가<br/> 프론트 Repository 생성|
| 2024.02.23 | [ 프로젝트 화면계획서 V0.7 작성](https://drive.google.com/drive/folders/19cVOkx5jpWMl9KqFia3Dd_BrflqpRaVl) <br/> API 명세서 작성|
| 2024.02.24 | 키오스크 관리 기능 완료|
| 2024.02.27 | 주문 관리 기능 완료|
| 2024.02.28 | 사이드바 기능 완료|
| 2024.03.03 | 키오스크 메인 화면 레포 이전|
| 2024.03.08 | 요구사항 수정|
| 2024.03.13 | [ 프로젝트 화면계획서 V0.8 작성](https://drive.google.com/drive/folders/19cVOkx5jpWMl9KqFia3Dd_BrflqpRaVl)|
| 2024.03.14 | [ 프로젝트 화면계획서 V0.9 작성](https://drive.google.com/drive/folders/19cVOkx5jpWMl9KqFia3Dd_BrflqpRaVl)|


## Contents

### 웰컴 페이지
<img src="https://github.com/acornkiosk/flower_android/assets/94777814/c58ab6b0-d0e8-4251-88ed-3c43461f011e" width="200" height="400"/>

### 메인 페이지
<img src="https://github.com/acornkiosk/flower_android/assets/94777814/92ed11cf-ffcc-41da-b3c7-499d95b5293f" width="200" height="400"/>

### 메뉴 상세 페이지
<img src="https://github.com/acornkiosk/flower_android/assets/94777814/917bd584-9964-4875-835b-f8d5663c13d5" width="200" height="400"/>

### 장바구니 페이지
<img src="https://github.com/acornkiosk/flower_android/assets/94777814/6b25af19-e13a-496a-8e5a-9bf4749d604e" width="200" height=400"/>

### 시연영상
[YouTube Link](https://youtu.be/hw9iefr5Kxk)
