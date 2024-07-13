#  <img src="https://github.com/user-attachments/assets/ec696e3a-38d6-4925-8bba-71b6f44f1ed2"  width="30" height="30"/> 별을담다  
> Samsung Software Academy For Youth 10기  
> 주 제 : 웹 큐레이팅  
> 개발 기간 : 2023.12.28 ~ 2024.02.16

# 🌟 프로젝트 소개
<p align="center">
<img src="https://github.com/user-attachments/assets/6ebc1ccc-1a6f-4523-8072-4794b054fb5a" height="200"/>
</p>
갤러리형식의 사진기반 SNS 서비스! 아직 감이 안 오시죠?? 저희는 기존의 사진기반 SNS인 인스타그램에서 서비스를 조금 더 발전시켜 3D로 제작해보았습니다. 나의 우주에 나만의 별자리를 만들어 우주를 꾸미고, 나의 개성을 우주를 통해 보여주세요. 

### 1. 프로젝트를 어떻게 기획하게 되었나요?
현대의 SNS는 단순히 일상을 기록하는 목적뿐이 아니라, 사진을 통해 자신을 과시하기 위한 피드들이 많아지고 있습니다. 그리고 광고 목적의 피드들도 정말 많구요. 어느순간 SNS는 자신의 삶을 다른 사람들에게 과시하기 위한 공간으로 변모하였습니다. 이러한 변화에 타인과 자신을 비교하며 불행하게 될 뿐이라 생각이 들었고 본인의 삶을 진실되게 기록하고, 그것을 본인만의 공간에 담아두는 새로운 형태의 SNS의 필요성을 느끼게 되었습니다.

### 2. 프로젝트의 핵심 가치는 무엇인가요?
이런 생각에서 출발한 '별을담다'는 사용자가 자신의 이야기를 별자리로 만들어나가는 과정에 집중하게 하여, 자신의 삶에 더욱 충실하게 살아가는 기회를 제공합니다. 사용자는 자신의 사진을 선택하고, 그에 대한 설명과 태그를 담아 하나의 '별'을 만들어냅니다. 그리고 이런 '별'들을 모아 자신만의 '별자리'를 창조하며, 그것을 자신만의 '우주'에 담아둘 수 있습니다.
자신의 우주에서 전시된 별자리들을 통해 자신의 추억을 돌아보고, 그 이야기를 다른 사람들에게 공유함으로써 삶을 더욱 풍요롭게 만들 수 있습니다. '별을 담다'는 단순히 사진을 공유하는 것이 아닌, 자신의 이야기를 통해 자신만의 우주를 만들어가는 과정을 제공함으로써 사용자에게 새로운 경험을 선사하는 서비스입니다.

# 💡 주요 기능

### 홈 화면

![홈화면.gif](Untitled.png)
- 홈 화면에서는 마우스를 이용하여 화면을 이동시킬 수 있습니다.
- 3D 화면처럼 보이도록 하여 우주의 다양한 별자리를 볼 수 있으며 별자리를 클릭하면 해당 별자리를 크게 볼 수 있고 해당 별자리의 별들도 볼 수 있습니다.

### 별자리 생성하기

![별자리 생성](https://github.com/user-attachments/assets/8d309551-ac9e-48c3-ba5f-d23e2dda66d3)
![별자리 생성.gif](별자리생성.gif)

- 사진을 등록하는 버튼을 통해 별자리로 만들고 싶은 사진을 추가할 수 있습니다.
- 화면에 사진을 업로드한 뒤 AI 윤곽선 추출 버튼을 통해 윤곽선을 추출할 수 있습니다.
- 추출한 사진을 가지고 원하는 객체를 선택할 수 있습니다.
- 만약 원하는대로 나오지 않았다면 점들을 드래그 앤 드롭을 통해 별자리를 편집할 수 있습니다.
- 별자리 편집을 완료하였다면 별자리 이름을 적고 생성 버튼을 누르면 나의 우주에 별자리가 생성된 것을 확인할 수 있습니다.

### 별 생성하기

![별생성1.gif](<게시물 생성.gif>)
![별생성5.gif](%EB%A7%88%EC%9A%B0%EC%8A%A4%ED%98%B8%EB%B2%84.gif)
- 사진을 선택하고 사진을 설명할 수 있는 글과 해시태그들을 적습니다.
- 다음을 눌러 원하는 별자리를 선택하고 새 별을 생성합니다.
- 별을 생성하면 다음과 같이 별자리에 글이 생김을 확인할 수 있으며 글 위에 마우스를 갖다대면 썸네일이 보이고 별을 누르면 해당 게시글을 볼 수 있습니다.

### 피드 확인하기

![피드.gif](%ED%94%BC%EB%93%9C.gif)
- 자신의 팔로워들의 피드들을 볼 수 있습니다.
- 상대의 피드에 좋아요 및 댓글을 남길 수 있습니다.
- 대댓글까지 가능합니다.

### 검색

![Animation.gif](Animation.gif)

- 유저 검색과 게시물 검색이 가능합니다.

# 🛠️ 주요 기술 스택
### FrontEnd

- Language : JavaScript
- Library : React, react-dom, three.js, konva

### BackEnd

- Language : Java
- Framework : Spring boot

### Database

- REDIS
- MariaDB
- MongoDB
- JPA
- S3

### AI

- Language : python
- Framework : Django
- Model : Detectron2

### Deploy

- Docker
- Jenkins
- NginX
- Gitlab
- Gerrit


# ⚙ 시스템 아키텍쳐
![Untitled 201](https://github.com/user-attachments/assets/4ffedad2-df55-4d70-9c59-f946ed6b1ad7)

## ⚒️ CI/CD
- GitLab, Gerrit과 Jenkins를 이용하여 지속적 통합 및 자동 배포
- Gitlab을 통해 Git Flow를 생성하여 Branch를 구성하고 Feature를 생성하여 작업 진행
- Feature에서 모든 코드 push 시 Gerrit을 통한 코드 리뷰 필수화
- Develop에서 Master로 코드가 올라가면 Jenkins를 통해 자동 배포

# 👩‍💻 팀원 역할 분배
### 김수혁 BE, AI

- 게시글 이미지, 게시글 썸네일, 프로필 이미지 리사이징
- 이미지 S3 업로드
- Detectron2를 이용한 Image Segmentation
- Mask와 OpenCV를 이용한 윤곽선 추출

### 이민우 BE, INFRA

- 소셜로그인(카카오, 네이버, 구글) 및 이메일 로그인
- 액세스 토큰 및 리프레시 토큰을 활용한 유저 인증 관리
- 이메일 검증 및 인증 로직 구현
- 팔로워, 팔로잉 기능 구현(팔로우 요청, 수락, 취소)
- REDIS를 사용한 유저인증 쿼리 최적화
- NoSQL(MongoDB)를 사용한 윤곽선 정보 관리
- 도커 컴포즈를 활용한 컨테이너 관리
- Nginx를 활용한 HTTPS 적용

### 이은규 FE, UIUX Design

- 서비스 디자인 기획 및 UIUX 디자인
- 와이어프레임 및 목업 제작
- 프론트엔드 컴포넌트, 페이지 계층 구조 제작 및 코드 작성
- 백엔드 api 통신을 이용한 네비게이션바, 확장바, 프로필 정보 표시, 프로필 정보 수정, 팔로잉 팔로워 모달, 별자리 리스트 모달 구현
- 컴포넌트, 페이지별 CSS 스타일링
- 프로젝트 소개 발표 자료 제작 및 발표

### 이창헌 BE

- 별자리, 게시물, 유저 등 핵심 백엔드 데이터베이스 관리
- 검색, 해시태그, 휴지통 기능 구현
- UCC 제작

### 차현철 BE

- 댓글 및 대댓글, 좋아요, Swagger 등 백엔드 코드 작성
- Kafka와 SSE를 활용한 백엔드 알림 기능 구현
- 댓글 및 대댓글 테스트코드 작성 및 테스트
- 검색 피드, 상세 게시물, 설정 프론트 페이지 제작
- 노션 문서 기록 관리

### 황정민 FE, INFRA

- 소셜로그인(카카오, 네이버, 구글) 및 사용자 토큰 관리 구현
- Three.js를 이용해 사용자가 만든 별자리를 밤하늘의 별을 구경하듯이 볼 수 있는 화면 구현
- Konva 라이브러리를 사용해 사용자가 이미지나 별자리를 편집할 수 있는 에디터 구현
- 게릿 깃랩 연동 및 설정, 젠킨스 깃랩 웹훅 연결, nginx를 이용해 리액트 앱 배포 설정
