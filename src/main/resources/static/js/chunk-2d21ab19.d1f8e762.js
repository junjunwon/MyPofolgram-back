(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21ab19"],{bd34:function(l,e,s){"use strict";s.r(e);var i=s("7a23"),a={class:"mypage"},t={class:"mypageHeader"},c=Object(i["g"])("h2",{class:"nickname"},"eunj_eong",-1),o=Object(i["g"])("i",{class:"fa-solid fa-bars"},null,-1),n={class:"top"},p=Object(i["g"])("div",null,[Object(i["g"])("img",{src:"/images/example.jpeg",alt:"고양이"})],-1),d=Object(i["g"])("div",null,[Object(i["g"])("p",null,"게시물"),Object(i["g"])("span",null,"65")],-1),u=Object(i["g"])("p",null,"팔로워",-1),g=Object(i["g"])("p",null,"팔로잉",-1),r={key:0,class:"mypost"},b=Object(i["h"])('<div class="post"><img src="/images/example.jpeg" alt="고양이"></div><div class="post"><img src="/images/example.jpeg" alt="고양이"></div><div class="post"><img src="/images/example.jpeg" alt="고양이"></div><div class="post"><img src="/images/example.jpeg" alt="고양이"></div><div class="post"><img src="/images/example.jpeg" alt="고양이"></div><div class="post"><img src="/images/example.jpeg" alt="고양이"></div>',6),f=[b],j={key:1,class:"empty"},m=Object(i["g"])("div",null,[Object(i["g"])("i",{class:"fa-solid fa-camera"}),Object(i["g"])("h3",null,"게시물 없음")],-1),O=[m],v={key:2,class:"bottomModal"},w=Object(i["h"])('<p class="modalTitle">만들기</p><ul><li><i class="fa-solid fa-table-cells"></i><p>게시물</p></li><li><i class="fa-solid fa-clapperboard"></i><p>릴스</p></li><li><i class="fa-solid fa-circle-plus"></i><p>스토리</p></li><li><i class="fa-brands fa-gratipay"></i><p>스토리 하이라이트</p></li><li><i class="fa-solid fa-satellite-dish"></i><p>라이브 방송</p></li><li><i class="fa-solid fa-book-open"></i><p>가이드</p></li></ul>',2),h=[w];function y(l,e,s,b,m,w){var y=Object(i["w"])("dis");return Object(i["s"])(),Object(i["f"])("div",a,[Object(i["g"])("div",t,[c,Object(i["i"])(y,{class:"right"},{default:Object(i["C"])((function(){return[Object(i["g"])("i",{class:"fa-solid fa-square-plus",onClick:e[0]||(e[0]=function(l){return m.createModal=!m.createModal})}),o]})),_:1})]),Object(i["g"])("div",n,[p,d,Object(i["g"])("div",{onClick:e[1]||(e[1]=function(l){return w.gotoFollowWhen("follower",m.user.followerCount>0)})},[u,Object(i["g"])("span",null,Object(i["y"])(m.user.followerCount),1)]),Object(i["g"])("div",{onClick:e[2]||(e[2]=function(l){return w.gotoFollowWhen("following",m.user.followingCount>0)})},[g,Object(i["g"])("span",null,Object(i["y"])(m.user.followingCount),1)])]),Object(i["g"])("div",{class:"modify",onClick:e[3]||(e[3]=function(l){return w.moveTo("/mypage/modify")})},"프로필 편집"),m.isEmpty?(Object(i["s"])(),Object(i["f"])("div",j,O)):(Object(i["s"])(),Object(i["f"])("div",r,f)),m.createModal?(Object(i["s"])(),Object(i["f"])("div",v,h)):Object(i["e"])("",!0)])}var k={data:function(){return{isEmpty:!1,createModal:!1,user:{followerCount:1,followingCount:1}}},mounted:function(){},methods:{moveTo:function(l){this.$router.push({path:l})},gotoFollowWhen:function(l,e){e&&this.$router.push({path:"/mypage/follow/".concat(l)})}}},C=s("6b0d"),x=s.n(C);const M=x()(k,[["render",y]]);e["default"]=M}}]);
//# sourceMappingURL=chunk-2d21ab19.d1f8e762.js.map