(function(e){function t(t){for(var r,a,i=t[0],u=t[1],s=t[2],l=0,p=[];l<i.length;l++)a=i[l],Object.prototype.hasOwnProperty.call(o,a)&&o[a]&&p.push(o[a][0]),o[a]=0;for(r in u)Object.prototype.hasOwnProperty.call(u,r)&&(e[r]=u[r]);f&&f(t);while(p.length)p.shift()();return c.push.apply(c,s||[]),n()}function n(){for(var e,t=0;t<c.length;t++){for(var n=c[t],r=!0,a=1;a<n.length;a++){var u=n[a];0!==o[u]&&(r=!1)}r&&(c.splice(t--,1),e=i(i.s=n[0]))}return e}var r={},o={app:0},c=[];function a(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-2d0e6c29":"62397fb5","chunk-2d21ab19":"ecc0e3e8","chunk-722943b3":"c9001d78","chunk-b24257b4":"917912d5"}[e]+".js"}function i(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.e=function(e){var t=[],n=o[e];if(0!==n)if(n)t.push(n[2]);else{var r=new Promise((function(t,r){n=o[e]=[t,r]}));t.push(n[2]=r);var c,u=document.createElement("script");u.charset="utf-8",u.timeout=120,i.nc&&u.setAttribute("nonce",i.nc),u.src=a(e);var s=new Error;c=function(t){u.onerror=u.onload=null,clearTimeout(l);var n=o[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),c=t&&t.target&&t.target.src;s.message="Loading chunk "+e+" failed.\n("+r+": "+c+")",s.name="ChunkLoadError",s.type=r,s.request=c,n[1](s)}o[e]=void 0}};var l=setTimeout((function(){c({type:"timeout",target:u})}),12e4);u.onerror=u.onload=c,document.head.appendChild(u)}return Promise.all(t)},i.m=e,i.c=r,i.d=function(e,t,n){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)i.d(n,r,function(t){return e[t]}.bind(null,r));return n},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/",i.oe=function(e){throw console.error(e),e};var u=window["webpackJsonp"]=window["webpackJsonp"]||[],s=u.push.bind(u);u.push=t,u=u.slice();for(var l=0;l<u.length;l++)t(u[l]);var f=s;c.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("7a23");function o(e,t,n,o,c,a){var i=Object(r["w"])("Header"),u=Object(r["w"])("router-view"),s=Object(r["w"])("Footer");return Object(r["s"])(),Object(r["f"])("div",null,[a.showHeader?(Object(r["s"])(),Object(r["d"])(i,{key:0})):Object(r["e"])("",!0),Object(r["i"])(u),a.showFooter?(Object(r["s"])(),Object(r["d"])(s,{key:1})):Object(r["e"])("",!0)])}n("4de4"),n("d3b7"),n("2ca0");var c={class:"header"},a=Object(r["h"])('<h1 class="logo"><img src="/images/logo.png" alt=""></h1><div class="iconList"><i class="fa-solid fa-square-plus"></i><i class="fa-solid fa-heart"></i><i class="fa-solid fa-paper-plane"></i><img src="/images/example.jpeg" alt="유저이미지"></div>',2),i=[a];function u(e,t){return Object(r["s"])(),Object(r["f"])("div",c,i)}var s=n("6b0d"),l=n.n(s);const f={},p=l()(f,[["render",u]]);var d=p,b={class:"footer"},h=Object(r["g"])("i",{class:"fa-solid fa-house"},null,-1),m=Object(r["g"])("i",{class:"fa-solid fa-magnifying-glass"},null,-1),v=Object(r["g"])("i",{class:"fa-solid fa-clapperboard"},null,-1);function g(e,t,n,o,c,a){return Object(r["s"])(),Object(r["f"])("div",b,[h,m,v,Object(r["g"])("i",{class:"fa-solid fa-circle-user",onClick:t[0]||(t[0]=function(e){return a.moveTo("/mypage")})})])}var j={methods:{moveTo:function(e){this.$router.push({path:e})}}};const O=l()(j,[["render",g]]);var y=O,w={name:"App",components:{Header:d,Footer:y},computed:{showHeader:function(){var e=this,t=["/mypage"];return t=t.filter((function(t){return e.$route.path.startsWith(t)})),0===t.length},showFooter:function(){var e=this,t=["/mypage/modify"];return t=t.filter((function(t){return e.$route.path.startsWith(t)})),0===t.length}}};const k=l()(w,[["render",o]]);var P=k,x=(n("3ca3"),n("ddb0"),n("6c02")),T=[{path:"/",component:function(){return n.e("chunk-722943b3").then(n.bind(null,"cd56"))}},{path:"/mypage",component:function(){return n.e("chunk-2d21ab19").then(n.bind(null,"bd34"))}},{path:"/mypage/follow/:page",component:function(){return n.e("chunk-2d0e6c29").then(n.bind(null,"99b5"))}},{path:"/mypage/modify",component:function(){return n.e("chunk-b24257b4").then(n.bind(null,"f1f3"))}}],_=Object(x["a"])({history:Object(x["b"])("/"),routes:T}),S=_,F=Object(r["c"])(P).use(S);F.mount("#app")}});
//# sourceMappingURL=app.df27f2cd.js.map