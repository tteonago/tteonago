# Spring Boot project: 나의 여행 비서, tteonago
*프로젝트 한줄 설명을 적어주세요*
<br/><br/>

## :hourglass: 개발 기간
03/14/23 ~ 04/06/23

<br/><br/>

## :hammer_and_wrench: 기술 스택 
![Spring Boot](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![miro](https://img.shields.io/badge/miro-050038?style=for-the-badge&logo=miro&logoColor=white)
![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-%23000000.svg?style=for-the-badge&logo=notion&logoColor=white)
<br/><br/>

## :runner: 참여 인원
Name|GitHub Address|
|------|---|
|:eagle:김주영|https://github.com/11000db|
|:frog:서원우|https://github.com/wonuseo|
|:alien:이신애|https://github.com/alpapago|
|:soccer:이준수|https://github.com/Junsoo71|
|:teddy_bear:조성민|https://github.com/Seongmin2018|
|:cat2:조성환|https://github.com/CSHcode|


<br/><br/>

## :open_book: 프로젝트 요약
*프로젝트 간단 요약을 적어주세요*

<br/><br/>

# :gear: 주요 기능 
## :world_map: 검색방법 : 지도
메인 페이지의 이미지카테고리(지역)을 조건으로 해당 지역의 호텔을 마커로 표시해줍니다.<br><br>
마커를 클릭하면 호텔 정보 창이 출력되며, 바로가기를 클릭시 상세페이지로 이동합니다.<br><br>
![검색_지도](https://user-images.githubusercontent.com/87034370/229581639-96dc01db-0aef-4355-9f1f-355e09aa2c56.gif)
<br><br>

## :necktie: 관리자 : 통계차트
원형 차트로 지역별 총 매출, 가장 많이 찜을 받은 선호도 상위 호텔 5개를 조회 할 수 있습니다.<br><br>
![관리자_차트](https://user-images.githubusercontent.com/87034370/229581658-75e2c170-8834-4263-a08f-bc448d60ec01.gif)
<br><br>

<br/><br/>

## :face_with_head_bandage: Trouble Shooting
> 
 :world_map: 검색방법 : 지도<br><br>
>  :dart:onclick속성을 이용해 스크립트 함수를 구현해 위도와 경로를 포함하는url을 구성  →  url encoding 문제에 봉착.
> *  스크립트를 사용 폐기,  기존 컨트롤러의 반환값 **AreaDTO** 사용해 사진마다 areaId를 세팅하고 **th:onclick**를 통해 areaId으로 값을 추가해서 url 만듬.
> * 새로운 컨트롤러를 사용해서 셋팅된 areaId값으로 **AreaDTO** 반환.
> * map 구현 코드는 js. Thymeleaf Template에서 읽을수 있도록 script 내부에 주석으로 AreaDTO사용. (or **th:attr** 사용)<br>

>:dart:마커를 찍기위해 호텔의 위경도 값을 가져와야하며, 해당 지역을 클릭하면 그 지역에 관련된 호텔만 불러와야한다. 
> * 지역을 조건으로 해당 호텔만 추출하도록 쿼리 작성.

>:dart:사진은 1번째 사진만 필요하고, HotelImage 테이블과 Hotel테이블의 정보가 필요하며, 기존의 area도 유지되어야함. 
> * 조건에 맞는 쿼리문을 작성하고, 매핑연관 관계를 이용해 조건에 맞는 검색 결과를 HotelMapDTO을  json으로 보냄.
> * HotelMapDTO은 hotelDTO에 hotelimage의 address 추가.

 <br><br>:necktie: 관리자 : 통계차트<br><br>
 >:dart: 원형 차트 : 넘어 오는 데이터는 의도한 대로 넘어 왔지만, script에서 값이 없어 차트가 보이지 않는 상황. (List<Object[]>형식으로 넘어가며, script는 JSON.parse() 로 변환.)
 > * JSON 문자열을 파싱해 주고 있었지만, 정작 직렬화해주지 않았다.
 > * 내부 객체&데이터를 외부의 시스템에서도 사용할 수 있게 바이트 형태로 직렬화&역직렬화.

 >:dart: 열 차트 : 행차트를 구현하려 했지만, 템플릿과 맞지 않는 문제가 발생.
 > * 열 차트 구현으로 노선 변경. but 호텔 이름이 길어 겹치는 문제발생.
 > * 호텔이름 겹치는 문제는 크기를 키우고, 잘리는 문제는 상위 5로 조정.

 <br><br>:pinching_hand: URL에 허용되지 않는 값을 임의로 삽입시 오류처리 해야함
 > * url 데이터 누락 -> 파라미터 없음 & 파라미터에 값 없음.
 > * 날짜 임의 작성 -> 잘못된 날짜 데이터.
 > * 위의 두가지의 경우의 수를 잡아, alert 메세지와 바로 뒤로가는 동작을하는 페이지로 이동.
 > * 잘못된 컨트롤러 요청 -> error/404
