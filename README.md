# MyPofolgram-back


### JAVA DOCS for REQUEST API
- https://junjunwon.github.io/MyPofolgram-back/


## 프론트엔드 깃허브 주소 (Front-end github link)
https://github.com/junjunwon/junjunwon-MyPofolgram-front


## 기술 스택
#### 프론트엔드
- Node.js : v17.8.0
- @vue/cli : 4.5.15
- vue : v2
- Javascript ES6
- CSS / HTML
#### 백엔드
- SringBoot : v2.6.4
- Java : Java Open Jdk 11.0.2
#### 데이터베이스
- heroku-PostgreSql
#### Cloud
- Heroku : deploy Backend server
- AWS S3 : storing images


## DB table diagram (Still working on it to make it better)

<img width="789" alt="dialgram" src="https://user-images.githubusercontent.com/45681336/158583301-46dcbe66-3562-4925-812c-66f2de198dad.png">

```sql
// Creating tables
Table Users {
  id int [pk, increment]
  userId varchar
  nickName varchar
  email varchar
  createDate datetime
  updateDate datetime
  removeDate datetime
}

Table Post {
  id int [pk, increment]
  userId varchar
  content varchar
  locationId int
  createDate datetime
  updateDate datetime
  removeDate datetime
}

Table PostHashTag {
hashTagId int
  postId int
}

Table HashTag {
  id int [pk, increment]
  title varchar
}

Table Locations {
  id int [pk, increment]
  title varchar
  address varchar
}

Table Photos {
  id int [pk, increment]
  fileName varchar
  postId int
  userId varchar
}

Table Comments {
  id int [pk, increment]
  body varchar
  postId int
  userId varchar
}

Table Settings {
  id int [pk, increment]
  private boolean
  addingPhtos varchar
  userId varchar
}

Table Likes {
  id int [pk, increment]
  postId varchar
  userId varchar
}

// Creating references
// You can also define relaionship separately
// > many-to-one; < one-to-many; - one-to-one

//사용자와 게시글의 1: 매칭
Ref: Users.userId - Post.userId

//1:1 관계로 게시글을 올린 지역
Ref: Post.locationId - Locations.id

//PostHashTag는 연결 테이블로
//post와 hashTag M:N관계를 성립
Ref:PostHashTag.postId - Post.id
Ref:PostHashTag.hashTagId - HashTag.id

//Photos테이블 FK키로
//사진 소유자와 N:1 관계
//게시글과 N:1 관계
Ref: Photos.userId > Users.userId
Ref: Photos.postId > Post.id

//Comment 테이블 FK키로
//댓글을 작성한 사용자 1: 관계
//여러 댓글이 달린 사진 N : 1 관계
Ref: Comments.userId - Users.userId
Ref: Comments.postId > Post.id

//Setting 테이블 FK키
//유저에 대한 환경설정으로 1:1 관관계
Ref: Settings.userId - Users.userId

//Likes 테이블 FK키로 
//사용자는 여러개의 좋아요를 누를 수 있다.
//게시글은 여러 사용자가 좋아요를 누를 수 있다.
Ref: Likes.userId - Users.userId
Ref: Likes.postId - Post.id

```
