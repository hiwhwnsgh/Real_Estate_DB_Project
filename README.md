# 부동산 관리시스템
# (Real Estate DB Project)

- 기여자 : 조준호, 남태윤, 한유정

## 산출물
[☞ 프로젝트 결과보고서](https://drive.google.com/file/d/1wjmuHzxoI1mJ_h51eT-rpeldDfsC9c_U/view?usp=sharing)

## 목표
- 부동산 중개 및 관리 시스템을 제작하여 부동산을 이용하는 임대인, 고객, 중개인 모두에게 정보제공을 목적으로 개발
- 고객의 경우 자본금, 희망도시 등의 정보를 이용하여 중개인을 통해 매물의 정보를 얻을 수 있고, 중개인은 고객의 정보와 임대인의 정보, 매물의 정보를 모두 이용하여 편리한 매칭을 할 것입니다
- 임대인은 판매위치, 판매금액 등의 정보와 건물의 건물형태, 건설사 등의 정보를 이용하여 중개인을 통해 쉬운 임대를 목적으로 개발
- 이러한 시스템을 통해 각 사용자들이 부동산 거래 및 관리를 용이하게 하는 것을 목표로 합니다

## 데이베이스 설계
<details markdown="1">
<summary>요구사항 명세서</summary>
  
 - 고객에 대한 고객id, 희망도시, 자본금, 계약조건 정보를 입력해야 한다.
 - 고객은 고객id로 식별한다.
 - 고객은 여러 중개사에게 중개를 받을 수 있고, 중개사는 여러 고객에게 중개를 할 수 있다.
 - 중개사가 고객에게 중개를 할 때, 계약날짜 정보를 유지해야 한다.
 - 중개사에 대한 중개사id, 이름, 매물개수, 중개소위치, 전화번호 정보를 입력해야 한다.
 - 개사는 중개사id로 식별한다.
 - 한 중개사는 여러 임대인에게 중개해줄 수 있고, 각 임대인은 한 중개사에게 중개받을 수 있다.
 - 임대인에 대한 판매자id, 판매위치, 구매시기 정보를 유지해야 한다.
 - 임대인은 판매자id로 식별한다.
 - 임대인은 건물을 여러개 보유할 수 있고, 건물은 임대인을 하나만 보유할 수 있다.
 - 건물에 대한 일련번호, 주소, 완공시기, 평균시세, 건설사, 판매여부, 계약조건 정보를 유지해야 한다.
 - 건물은 일련번호로 식별한다.
 - 한 중개사는 여러 건물을 관리할 수 있고, 각 건물은 한 명의 중개사에게 관리받는다.
</details>
<details>
<summary>E-R 다이어그램</summary>
  
  - 개체와 속성 추출

|개체|속성|
|:-----:|:----:|
|고객|고객id, 희망도시, 자본금, 계약조건|
|중개사|중개사id, 이름, 매물개수, 중개소위치, 전화번호|
|임대인|판매자id, 판매위치, 구매시기|
|건물|일련번호, 주소, 완공시기, 평균시세, 건설사, 판매여부, 계약조건|


  - 관계 추출

|관계|참여 개체|관계유형|속성|
|:------:|:-----:|:-----:|:---:|
|중개1|고객, 중개사|다대다|계약날짜|
|중개2|중개사, 임대인|일대다|-|
|관리|중개사, 건물|일대다|-|
|보유|건물, 임대인|일대다|-|

- E-R 다이어그램

  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/f19221e9-43da-4412-acf4-2f1cf111eb72)

</details>
<details>
  <summary>릴레이션 스키마(* PK=밑줄, FK=굵은체)</summary>
 
  |릴레이션|속성|
  |:-----:|:------:|
  |고객|고객id, 희망도시, 자본금, 계약조건|
  |중개사|<U>중개사id</U>, 이름, 매물개수, 중개소 위치, 전화번호|
  |임대인|<U>판매자id</U>, 판매위치, 구매시기, **중개사id**|
  |건물|<U>일련번호</U>, 주소, 완공시기, 건물형태, 평균시세, 건설사, 판매여부, 계약조건, **판매자id**, **중개사id**|
  |중개1|<U>계약번호</U>, **고객id**, **중개사id**, 계약날짜|
  
</details>

<details>
  <summary>프로그램 기능</summary>
  
  - 서버측 프로그램
    - 저장 프로시저 : 
      - 건물완공 n년 이하 건물조회 프로시저
      - 건물완공 n년 이하 및 특정도시 건물조회 프로시저
      - 건물완공 n년 이하 및 특정도시 건물조회 및 판매금액 프로시저
      - 건물계약 프로시저
      - 회원가입 중복체크 프로시저
      - 회원정보 수정 프로시저
      - 회원정보 수정 프로시저
     - 트리거 :
        - 건물테이블이 갱신될 때 마다 갱신 내용을 중개사 테이블의 매물개수에 반영하는 트리거
  - 클라이어트측 자바 프로그램 with JDBC
      - Statement :
        - 중매사 검색을 위해 select로 중매사를 검색할 때 사용
        - 중매사가 관리하는 해당 건물 검색을 위해 select로 건물을 검색할 때 사용
        - 건물 계약 폼의 자본금 검색 사용
      - PrepareStatement :
        - 회원가입을 위해 insert로 고객 정보를 넣을 때 사용
        - 로그인을 위해서 select로 고객을 검색할 때 사용
        - 원하는 건물을 보기 위해 select로 건물, 임대인을 검색할 때 사용
        - 계약을 위해 select로 해당 건물을 검색할 때 사용
      - CallableStatement :
        - 아이디 중복 체크를 위해 사용
        - 건물 계약을 위해 사용
        - 유저정보 수정을 위해 사용
</details>

## DB 기능 구현
### 저장 프로시저
 <details>
   <summary> 건물계약 프로시저 </summary>
   
   - 프로시저 화면

     ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/f9bbd4dd-8e0c-480b-aeb0-423e3f7aefd4)

   - 프로시저 기능 설명
      - 자바에서 사용자로부터 PI_중개사ID, PI_고객ID, PI_일련번호(건물일련번호)를 입력받아 입력받은 PI_일련번호는 건물.일련번호와 비교 후 일치하는 건물의 시세데이터를 V_판매가격에 저장, PI_고객ID는 고객.고객ID와 비교 후 일치하는 고객의 자본금을 V_자본금에 저장한다.
      - V_판매금액과 V_자본금을 비교 후 V_자본금이 V_판매금액보다 크다면 건물테이블에 PI_일련번호와 일치하는 건물의 계약여부를 1로 바꾼다.(0일 때 계약가능, 1일 때 계약완료)
  PI_고객ID와 일치하는 고객의 자본금을 V_판매금액 만큼 뺀 데이터를 저장한다.
      - 계약이 성공하면 중개1테이블에 건물일련번호(PI_일련번호), 고객ID(PI_고객ID), 중개사ID(PI_중개사ID), 계약날짜(SYSDATE)를 삽입하여 계약서를 생성한다.
      - 만약 V_판매금액과 V_자본금 비교에서 V_자본금이 V_판매금액보다 작다면 예외처리를 통해 에러를 발생시킨다.
     
 </details>

 <details>
   <summary>회원정보 수정 프로시저</summary>
   
   - 프로시저 화면

  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/0a773276-9d7b-4537-83a8-f6447720bc59)

  - 프로시저 기능 설명
    - 자바에서 사용자로부터 PI_ID, PI_PW, PI_CITY, PI_MONEY, PI_TERMS를 입력받은 뒤 PI_ID와  고객.고객ID를 비교 후 같은 고객의 데이터들을 비밀번호(PI_PW), 희망도시(PI_CITY), 자본금(PI_MONEY), 계약조건(PI_TERMS)로 변경하여 회원정보를 수정한다.
 </details>
 
 ### 트리거

 <details>
   <summary>건물 삽입 및 수정 시 중개사 매물개수 변경 트리거 작성</summary>
   
   - 트리거 화면
   
   ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/6a6d1d70-854e-4536-9a1e-a8039b826d1d)

  - 건물 삽입 전 중개사 테이블
    
    ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/4ef19545-c2f1-4164-afd6-18e29c36f25f)
  - 건물 데이터 삽입

    ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/aba2e75f-966c-4474-aa69-79005f02e851)

  - 건물 삽입 후 중개사 테이블

    ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/f0a9b599-9c4f-4628-a694-63c9768212a4)

건물 삽입 후 중개사 테이블의 매물갯수가 증가 된걸 확인이 가능하다.

    
 </details>

### 데이터베이스 데이터(Oracle)
<details>
  <summary>(1) 건물</summary>
  
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/317406d9-10b8-4813-aa76-36785c6c0904)
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/dcef8fde-3583-49b8-a86b-56f29834d03f)
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/efa69d28-5601-4fb7-8111-92ecd117e521)
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/19666126-e40f-49e5-a626-abc83df1a0fb)
  
</details>

<details>
  <summary>(2) 고객</summary>
  
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/6c77891e-71e7-46c4-90e5-95d857130b71)
  
</details>

<details>
  <summary>(3) 임대인</summary>
  
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/4cf8de71-9a1c-4d80-a348-ec34e32ff754)

</details>

<details>
  <summary>(4) 중개1(프로그램에서 계약 시 생기는 데이터)</summary>
  
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/f1dcd8cd-917a-416c-8b0a-20083d24a0cd)

</details>

<details>
  <summary>(5) 중개사</summary>

  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/6eaebee3-076b-4809-a325-b2490bd9ca57)

</details>

## Java 구현
### Statement 구현

<details>
<summary>중개사 목록 검색</summary>

  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/df6b885a-751c-4b58-b2fc-969b1d72f7fa)
  <br>
  지역콤보박스 선택 후 검색버튼 클릭 시 중개사 목록 출력
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/ec6e9461-6793-4c81-b38c-836c4b1b95a7)
  
</details>

<details>
  <summary>건물 목록 검색</summary>

  중개사 테이블의 행 클릭 시 해당 중개사가 중개하고 있는 건물의 목록을 보여줌
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/f41ec8bb-4da6-4157-9d23-84298ee6cd44)

</details>

### PrepareStatement 구현
<details>
  <summary>건물 검색</summary>

  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/48fd143a-6b9e-4c3b-9a82-9c5fd432f54a)
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/570dbf44-10a5-4b13-859c-16e6cc41078d)

</details>

<details>
  <summary>로그인하기</summary>
  
  - 만약 아이디와 비밀번호 둘다 일치하는 경우가 DB에 있을 경우 로그인에 성공하게되고 로그인 창이 사라지면서 메인 창으로 이동한다.
  - DB에 아이디나 비밀번호 둘중하나가 없거나 둘다 없는 경우 로그인을 실패하고 로그인 창에 계속 머물게 된다.(이때 실패 사실을 실패 메시지를 띄워서 알려준다.)

  잘못 입력한 경우
  
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/e4a413d3-26cf-4e13-9688-3a2885bc88f0)
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/6f026278-88fc-4544-bc3d-9853a5c7c1db)

</details>

### CallableStatement
<details>
  <summary>건물 계약</summary>
  
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/ed18c0cd-4330-4304-a6ad-7b63701665ef)
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/6c7c22e8-5a6e-4f60-ac15-7e7cab0e38f1)
  
  건물 계약 성공했을 때
  
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/1c2453ca-575f-4381-8544-0e0f0d917a6e)
  
  건물 계약 실패했을 때
  
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/89215f74-1d7a-4b84-a126-8a48c12c5fad)

</details>

<details>
  <summary>회원 정보 수정</summary>
  
  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/8bb2718b-a2c4-41ab-b492-15d7b64ed0f5)

  회원정보 수정했을 때

  ![image](https://github.com/hiwhwnsgh/Real_Estate_DB_Project/assets/78071893/a10b5666-f456-4545-aed1-9d7f9f9ad8cf)

</details>
