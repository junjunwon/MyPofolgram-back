(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0e17b0"],{"7b2a":function(e,t,c){"use strict";c.r(t);var i=c("7a23"),n={class:"topWithButton"},s={class:"bold"},a=Object(i["g"])("p",{class:"point"},"완료",-1),l={class:"modifyProfile"},o={class:"medium"},r=Object(i["g"])("div",{class:"line"},null,-1),u={class:"small"};function b(e,t,c,b,p,g){return Object(i["s"])(),Object(i["f"])(i["a"],null,[Object(i["g"])("div",n,[Object(i["g"])("i",{class:"fa-solid fa-chevron-left",onClick:t[0]||(t[0]=function(t){return e.$router.go(-1)})}),Object(i["g"])("p",s,Object(i["y"])(p.title),1),a]),Object(i["g"])("div",l,[Object(i["g"])("p",o,Object(i["y"])(p.title),1),Object(i["D"])(Object(i["g"])("input",{type:"text","onUpdate:modelValue":t[1]||(t[1]=function(e){return p.value=e})},null,512),[[i["A"],p.value]]),Object(i["g"])("i",{class:"fa-solid fa-circle-xmark right",onClick:t[2]||(t[2]=function(){return g.remove&&g.remove.apply(g,arguments)})}),r,Object(i["g"])("p",u,Object(i["y"])(p.message),1)])],64)}var p={props:["type"],data:function(){return{value:"value",title:"",message:"",nickname:""}},created:function(){this.pageSetting(this.type)},methods:{pageSetting:function(e){switch(e){case"name":this.title="이름",this.message="사람들이 이름, 별명 또는 비즈니스 이름 등 회원님의 알려진 이름을 사용하여회원님의 ㅣ계정을 찾을 수 있도록 도와주세요. 이름은 14일 안에 두 번만 변경할 수 있습니다.";break;case"nickname":this.title="사용자 이름",this.message="대부분의 경우 이후 14일 동안 사용자 이름을 다시 {{this.nickname}}(으)로 변경할 수 있습니다.";break;case"intro":this.title="소개";break}},remove:function(){this.value=""}}},g=c("6b0d"),d=c.n(g);const f=d()(p,[["render",b]]);t["default"]=f}}]);
//# sourceMappingURL=chunk-2d0e17b0.20b473ba.js.map