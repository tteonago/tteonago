# Spring Boot project: 나의 여행 비서, tteonago
최근 국가 간 여행 제한이 완화되면서 국내 여행 수요가 증가하고 있다는 추세를 파악하여, 저희는 한국 내 프리미엄 호텔 예약 웹페이지를 개발했습니다.<br><br> 
여행에서 가장 중요한 숙소 예약을 원활하게 할 수 있도록 노력했습니다. '떠나고'를 통해 한국의 우수한 프리미엄 호텔을 더욱 편리하게 예약해보세요.
<br/><br/>

## :hourglass: 개발 기간
03/14/23 ~ 04/06/23
<br/><br/>

## :hammer_and_wrench: 기술 스택 
![Spring Boot](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![Axios](https://img.shields.io/badge/Axios-5A29E4.svg?style=for-the-badge&logo=Axios&logoColor=white)
![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![Eclipse IDE](https://img.shields.io/badge/Eclipse%20IDE-2C2255.svg?style=for-the-badge&logo=Eclipse%20IDE&logoColor=white)
![VisualStudioCode](https://img.shields.io/badge/Visual%20Studio%20Code-007ACC.svg?style=for-the-badge&logo=Visual%20Studio%20Code&logoColor=white) 
![Sourcetree](https://img.shields.io/badge/Sourcetree-0052CC.svg?style=for-the-badge&logo=Sourcetree&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032.svg?style=for-the-badge&logo=Git&logoColor=white)
![miro](https://img.shields.io/badge/miro-050038?style=for-the-badge&logo=miro&logoColor=white)
![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)<br><br>
[![Notion](https://img.shields.io/badge/MOM-%23000000.svg?style=for-the-badge&logo=notion&logoColor=white&link=https://www.notion.so/Project-tteonago-509553f79ea542a6a743746741247d80?pvs=4)](https://www.notion.so/Project-tteonago-509553f79ea542a6a743746741247d80?pvs=4)  
<br/><br/> 
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

## :books: ERD
<br/><br/>

## :railway_track: 순서도
![순서도](https://user-images.githubusercontent.com/87034370/230520105-3940c755-a2cc-411b-b315-4905bdd8b170.png)<br><br>
<br><br>

# :gear: 주요 기능 
* [:world_map: 호텔검색_지도](#world_map-호텔검색_지도)<br>
* [:mag_right: 호텔검색_조건 검색](#mag_right-검색방법)
* [:necktie: 관리자_통계차트](#necktie-관리자_통계차트)
* [:moneybag: 결제](#moneybag-결제)
* [:pencil2: 리뷰쓰기](#pencil2-리뷰쓰기)
* [:face_with_head_bandage: Trouble Shooting](#face_with_head_bandage-trouble-shooting)
<br><br>

## :world_map: 호텔검색_지도
![검색_지도](https://user-images.githubusercontent.com/87034370/229581639-96dc01db-0aef-4355-9f1f-355e09aa2c56.gif)<br><br>
* 메인 페이지의 이미지 카테고리(지역)을 조건으로 해당 지역의 호텔을 마커로 표시해줍니다.<br><br>
* 마커를 클릭하면 호텔 정보 창이 출력되며, 바로가기를 클릭 시 상세페이지로 이동합니다.<br><br>
[:gear: 주요 기능](#gear-주요-기능)
<br><br>

## <a name="mag_right-검색방법"></a>:mag_right: 호텔검색_조건 검색
![검색](https://user-images.githubusercontent.com/122413012/230009947-5d286592-7ab8-497e-9b5e-38a24ec94c4e.gif)
<br/><br/>
![재검색](https://user-images.githubusercontent.com/122413012/230009921-7103cf78-3ed3-4d06-9fcf-72ee616f0e8d.gif)
<br>

* 메인 페이지의 호텔 검색 조건(지역, 체크인/체크아웃, 인원(객실)수, 등급)을 설정하고 검색 버튼을 누르면 검색조건에 해당하는 호텔 정보 리스트가 출력됩니다. 
* 호텔 이름 클릭 시 해당 호텔 세부정보 페이지로 이동합니다. 
* 호텔 예약 재검색 기능으로 메인페이지에서 되돌아가 다시 호텔을 검색하지 않고 이미 호텔이 검색된 목록 페이지에서 동기 방식으로 재검색하여 검색조건에 맞는 호텔목록을 보여줍니다.
<br><br>
[:gear: 주요 기능](#gear-주요-기능)
<br/><br/>


## :necktie: 관리자_통계차트
![관리자_차트](https://user-images.githubusercontent.com/87034370/229581658-75e2c170-8834-4263-a08f-bc448d60ec01.gif)<br><br>
* 원형 차트는 지역별 총 매출, 열 차트는 가장 많이 찜을 받은 선호도 상위 호텔 5개를 조회 할 수 있습니다.
<br><br>
[:gear: 주요 기능](#gear-주요-기능)
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
<br><br>
[:gear: 주요 기능](#gear-주요-기능)
<br/><br/>

## :computer: 로그인/소셜 로그인
<img src="https://user-images.githubusercontent.com/116073413/230076109-5a7a08f2-5836-470c-8ae6-90245915a893.gif" width="100%" height="90%" title="px(픽셀) 크기 설정" >
<br>

* 로그인은 Spring Security에서 관리됩니다.
* 로그인은 두가지의 방법이 있으며 첫번째는 일반적인 Spring Security 폼 인증, 두번째는 OAuth2 의 소셜 로그인 인증입니다.
* 최초로 소셜 로그인을 한 사용자는 ‘소셜 등급‘ 의 권한을 부여 받으며 추후에 이메일 인증을 해야 사이트의 모든 기능을 사용할 수 있습니다. 
<br><br>
[:gear: 주요 기능](#gear-주요-기능)
<br/><br/>

## :shopping_cart: 찜 하기
<img src="https://user-images.githubusercontent.com/116073413/230077975-ec4b8b8c-d3f9-4f71-b5d6-64d27bfcb1e4.gif" width="100%" height="90%" title="px(픽셀) 크기 설정" >

<br>

* 사용자는 마음에 드는 호텔을 '찜하기' 기능을 통해 즐겨찾기에 추가할수 있습니다. 
* 하트의 색깔이 채워져 있으면 이미 찜 목록에 추가된 상태이고, 한번 더 눌러 찜 목록에서 삭제할 수 있습니다.
* '찜 목록' 에서 직접 삭제할 수도 있습니다.
<br><br>
[:gear: 주요 기능](#gear-주요-기능)
<br/><br/>

## :moneybag: 결제
![결제](https://user-images.githubusercontent.com/122413012/230001516-9fb6f90a-57c6-4649-999a-ad2dc88b85b2.gif)
<br>
* 호텔 상세 페이지에서 방 리스트 탭에 최종 예약 날짜 선택 후 예약하기 버튼 클릭 시 결제 페이지로 이동합니다.
* 결제하기 버튼 클릭 시 KG이니시스 결제 API 사용하여 실제처럼 결제가 가능합니다. 사용자는 상세 페이지에서 입력받은 데이터를 토대로 결제 페이지에서 자신의 정보를 확인하고, 결제를 완  료할 수 있게 됩니다. 
* 결제 완료 시 마이페이지로 즉시 이동하여 구매내역 확인이 가능하고 취소 시 취소 알림창을 띄워 페이지 이동은 하지 않고 다시 결제 가능 및 홈으로 버튼 클릭 시 메인페이지로 이동합니다. 
<br><br>
[:gear: 주요 기능](#gear-주요-기능)
<br/><br/>

## :file_cabinet: 질문 게시판
<img src="https://user-images.githubusercontent.com/116073413/230085088-bff10365-aa8f-4199-a448-9d734ce70ac3.gif" width="100%" height="90%" title="px(픽셀) 크기 설정" >
<br>

* 질문 게시판을 사용하여 관리자는 사용자와 소통하고 사용자의 다양한 의견을 수렴하여 편의를 제공합니다.
* 글 제목을 클릭하여 내용을 열람할 수 있고, 로그인을 한 유저만 게시판에 글을 작성할 수 있습니다.

<img src="https://user-images.githubusercontent.com/116073413/230085527-1dfee8e8-f4dd-4cd7-b52d-efd0f287db74.jpg" width="50%" height="40%">

* 관리자는 사용자의 글에 답변과 삭제할 수 있는 권한이 있습니다. 
<br><br>
[:gear: 주요 기능](#gear-주요-기능)
<br/><br/>

## :pencil2: 리뷰쓰기
<img srt="https://user-images.githubusercontent.com/117890994/230529358-29e8d7bf-3038-42d9-8d1b-35cd8d162629.gif" width="50%" height="40%">

* 머물렀던 호텔에 대해서 리뷰를 쓸 수 있고, 한 번 리뷰를 작성하면 중복해서 작성할 수 없습니다.
* 내가 쓴 리뷰를 다른 유저들이 호텔을 선택할 때, 디테일 페이지에서 확인할 수 있습니다. 
<br><br>
[:gear: 주요 기능](#gear-주요-기능)
<br><br>

## :face_with_head_bandage: Trouble Shooting
:page_facing_up: 메인 페이지<br><br>
> :rotating_light: 메인 페이지에서 스크롤 시 크롬 웹 브라우저 관리자 도구에서 네트워크 탭에 이미지 로고 파일이 스크롤 시 마다 이미지가 로드 되는 문제 발생 -> 스크롤 시 렉 유발 발                   생
> * 메인 페이지에서 스크롤 시 자바 스크립트 단에 스크롤 이벤트 함수가 발생되어 적용되어 있는데 그 함수에 스크롤 시 마다 로고 이미지 파일이 로드 되는 코드를 발견하여 해당 코드 삭제     하여 문제 해결

 <br><br>:world_map: 검색방법 : 지도<br><br>
 
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

> :rotating_light:마커 클릭으로 출력되는 인포윈도우에 담을 정보 중에, 사진은 첫번째 사진 한장만 나오게 변경해야한다. 
> * 조건에 맞는 쿼리문을 작성.
> * -> 해당 지역의 호텔 사진 중 첫번째 사진은 마지막이름이 1번이다. like연산자를 통해 첫번째 이미지만 불러온다.


<br><br>:mag_right: 검색방법 : 조건 검색<br><br>
>  :dart: 메인페이지 조건 검색시 해당 조건에 맞게 입력값 반환을 원하는 상황  →  null pointer Exception, Syntax Error발생
> *  @param어노테이션의 이름과 변수명이 일치하지 않는 경우 오류 발생. 동일하게 수정 후 해결 <br>
> *  Syntax Error 이 부분도 쿼리문에서 사용되는 테이블 및 칼럼 이름 확인하고 데이터베이스에서 정의된 이름과 동일하게 수정 후 해결<br>


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
 
 <br><br>:moneybag: 결제<br><br>
 > :rotating_light: 호텔 상세보기 페이지단에 방 리스트 탭 및 결제 페이지에서 1박 가격 값이 천(1000) 단위마다 콤마가 적용 안되서 숫자 데이터 가독성 문제점 발생 
 > * Thymeleaf 문법 함수 #numbers.formatInteger 적용해서 문제점 해결

<br><br>
[:gear: 주요 기능](#gear-주요-기능)
