# Spring Boot project: 나의 여행 비서, tteonago
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
* [:world_map: 호텔검색_지도](#world_map-호텔검색_지도)<br>
* [:necktie: 관리자_통계차트](#necktie-관리자_통계차트)
* [:face_with_head_bandage: Trouble Shooting](#face_with_head_bandage-trouble-shooting)
<br><br>

## :world_map: 호텔검색_지도
![검색_지도](https://user-images.githubusercontent.com/87034370/229581639-96dc01db-0aef-4355-9f1f-355e09aa2c56.gif)<br><br>
메인 페이지의 이미지 카테고리(지역)을 조건으로 해당 지역의 호텔을 마커로 표시해줍니다.<br><br>
마커를 클릭하면 호텔 정보 창이 출력되며, 바로가기를 클릭 시 상세페이지로 이동합니다.<br><br>
<br><br>


## :necktie: 관리자_통계차트
![관리자_차트](https://user-images.githubusercontent.com/87034370/229581658-75e2c170-8834-4263-a08f-bc448d60ec01.gif)<br><br>
원형 차트는 지역별 총 매출, 열 차트는 가장 많이 찜을 받은 선호도 상위 호텔 5개를 조회 할 수 있습니다.
<br><br>

## :memo: 회원가입
<img src="https://user-images.githubusercontent.com/116073413/230073771-e58cd554-d425-4c7a-9e72-68cdf53855d1.gif" width="100%" height="90%" title="px(픽셀) 크기 설정" >

<br>

* 회원가입시 ‘아이디’, ‘비밀번호‘, ‘이름‘, ‘이메일’ 이 요구됩니다.
* ‘아이디‘ 는 ‘중복확인’기능을 사용하여 사용 가능한 아이디 인지 확인합니다. 
* ‘비밀번호‘는 한번 더 입력하여 오타나 잘못된 입력을 사전에 방지하고, 입력한 비밀번호가 일치하지 않으면 경고 문구가 출력됩니다.
* 위의 모든 조건을 만족하기 전까지는 ‘회원가입‘ 버튼은 비활성화 상태로 유지됩니다. 
<img src="https://user-images.githubusercontent.com/116073413/230077557-ec1694e3-2d97-44c3-afbe-f22643e5a32d.jpg">

* 회원가입시 입력한 비밀번호는 암호화 되어 저장되기 때문에 비밀번호 유출 등의 보안 문제를 방지할 수 있습니다. 

<br/><br/>

## :computer: 로그인/소셜 로그인
<img src="https://user-images.githubusercontent.com/116073413/230076109-5a7a08f2-5836-470c-8ae6-90245915a893.gif" width="100%" height="90%" title="px(픽셀) 크기 설정" >
<br>

* 로그인은 Spring Security에서 관리됩니다.
* 로그인은 두가지의 방법이 있으며 첫번째는 일반적인 Spring Security 폼 인증, 두번째는 OAuth2 의 소셜 로그인 인증입니다.
* 최초로 소셜 로그인을 한 사용자는 ‘소셜 등급‘ 의 권한을 부여 받으며 추후에 이메일 인증을 해야 사이트의 모든 기능을 사용할 수 있습니다. 

<br/><br/>

## :shopping_cart: 찜 하기
<img src="https://user-images.githubusercontent.com/116073413/230077975-ec4b8b8c-d3f9-4f71-b5d6-64d27bfcb1e4.gif" width="100%" height="90%" title="px(픽셀) 크기 설정" >

<br>

* 사용자는 마음에 드는 호텔을 '찜하기' 기능을 통해 즐겨찾기에 추가할수 있습니다. 
* 하트의 색깔이 채워져 있으면 이미 찜 목록에 추가된 상태이고, 한번 더 눌러 찜 목록에서 삭제할 수 있습니다.
* '찜 목록' 에서 직접 삭제할 수도 있습니다.

<br/><br/>

## :file_cabinet: 질문 게시판
<img src="https://user-images.githubusercontent.com/116073413/230085088-bff10365-aa8f-4199-a448-9d734ce70ac3.gif" width="100%" height="90%" title="px(픽셀) 크기 설정" >
<br>

* 질문 게시판을 사용하여 관리자는 사용자와 소통하고 사용자의 다양한 의견을 수렴하여 편의를 제공합니다.
* 글 제목을 클릭하여 내용을 열람할 수 있고, 로그인을 한 유저만 게시판에 글을 작성할 수 있습니다.

<img src="https://user-images.githubusercontent.com/116073413/230085527-1dfee8e8-f4dd-4cd7-b52d-efd0f287db74.jpg" width="50%" height="40%">

* 관리자는 사용자의 글에 답변과 삭제할 수 있는 권한이 있습니다. 

<br/><br/>

## :face_with_head_bandage: Trouble Shooting
 :world_map: 검색방법 : 지도<br><br>
 
> :rotating_light:이미지 카테고리에 onclick속성을 이용해 해당 지역 위도와 경도값을 map.html로 넘겨 주는 스크립트 함수를 구현해 위도와 경도 값을 포함하는url을 구성  → url encoding 문제에 봉착.
> * 기존 위도와 경도 값을 사용하는 코드 폐기, Thymeleaf 반복문으로 프로젝트 내부의 지역 사진을 가져오고 있는 코드를 수정하는 방향 선정.
> * -> 사진을 가져오는 반복문에서, 지역의 pk를 파라미터로 받는 새로운 컨트롤러를 호출해 해당 지역의 데이터와 해당 지역을 조건으로 호텔과 호텔 이미지의 데이터를 담고 있는 DTO 두가지를 model로 전달한다.

> :rotating_light: Script 내부에서 Thymeleaf 표현식을 사용 못함.
> * Thymeleaf는 서버 측에서 HTML 템플릿을 생성하는 데 사용.
> * 주석(/**/)을 사용하거나, script를 감싸는 태그에 **th:attr** 속성을 사용해 할당된 변수를 사용한다.

> :rotating_light:마커를 찍기위해 호텔의 위경도 값을 가져와야하며, 해당 지역을 클릭하면 그 지역에 관련된 호텔만 불러와야한다. 
> * 지역을 조건으로 해당 호텔만 추출하도록 쿼리 작성.
> * 호텔 entity에 @Embedded로 선언된 필드에있는 위경도 값을 사용한다.
> * 가져온 hotel객체에서 대부분의 정보를 사용할 수 있다.

> :rotating_light:사진은 1번째 사진만 필요하고, HotelImage 테이블과 Hotel테이블의 정보가 필요하며, 기존의 area도 유지되어야함. 
> * 조건에 맞는 쿼리문을 작성하고, 조건에 맞는 검색 결과를 새로운DTO에 담아 json으로 보냄.

 <br><br>:necktie: 관리자 : 통계차트<br><br>
 > :rotating_light: 원형 차트 : 넘어 오는 데이터는 의도한 대로 넘어 왔지만, script에서 값이 없어 차트가 보이지 않는 상황. (List<Object[]>형식으로 넘어가며, script는 JSON.parse() 로  변환.)
 > * JSON 문자열을 파싱해 주고 있었지만, 직렬화하지 않았음.
 > * 내부 객체&데이터를 외부의 시스템에서도 사용할 수 있게 바이트 형태로 직렬화&역직렬화.

 > :rotating_light: 열 차트 : 행차트를 구현하려 했지만, 템플릿과 맞지 않는 문제가 발생.
 > * 열 차트 구현으로 노선 변경. but 호텔 이름이 길어 겹치는 문제발생.
 > * 호텔이름 겹치는 문제는 크기를 키우고, 잘리는 문제는 상위 5로 조정.

 <br><br>:pinching_hand: URL에 허용되지 않는 값 오류처리
 > * url 데이터 누락 -> 파라미터 없음 & 파라미터에 값 없음.
 > * 날짜 임의 작성 -> 잘못된 날짜 데이터.
 > * 위의 두가지의 경우의 수를 잡아, alert 메세지와 바로 뒤로가는 동작을하는 페이지로 이동.
 > * 잘못된 컨트롤러 요청 -> error/404



