(function(e){function t(t){for(var n,c,i=t[0],s=t[1],u=t[2],l=0,d=[];l<i.length;l++)c=i[l],Object.prototype.hasOwnProperty.call(o,c)&&o[c]&&d.push(o[c][0]),o[c]=0;for(n in s)Object.prototype.hasOwnProperty.call(s,n)&&(e[n]=s[n]);f&&f(t);while(d.length)d.shift()();return a.push.apply(a,u||[]),r()}function r(){for(var e,t=0;t<a.length;t++){for(var r=a[t],n=!0,c=1;c<r.length;c++){var s=r[c];0!==o[s]&&(n=!1)}n&&(a.splice(t--,1),e=i(i.s=r[0]))}return e}var n={},o={app:0},a=[];function c(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-722943b3":"7ad84303"}[e]+".js"}function i(t){if(n[t])return n[t].exports;var r=n[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,i),r.l=!0,r.exports}i.e=function(e){var t=[],r=o[e];if(0!==r)if(r)t.push(r[2]);else{var n=new Promise((function(t,n){r=o[e]=[t,n]}));t.push(r[2]=n);var a,s=document.createElement("script");s.charset="utf-8",s.timeout=120,i.nc&&s.setAttribute("nonce",i.nc),s.src=c(e);var u=new Error;a=function(t){s.onerror=s.onload=null,clearTimeout(l);var r=o[e];if(0!==r){if(r){var n=t&&("load"===t.type?"missing":t.type),a=t&&t.target&&t.target.src;u.message="Loading chunk "+e+" failed.\n("+n+": "+a+")",u.name="ChunkLoadError",u.type=n,u.request=a,r[1](u)}o[e]=void 0}};var l=setTimeout((function(){a({type:"timeout",target:s})}),12e4);s.onerror=s.onload=a,document.head.appendChild(s)}return Promise.all(t)},i.m=e,i.c=n,i.d=function(e,t,r){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(i.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)i.d(r,n,function(t){return e[t]}.bind(null,n));return r},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/",i.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],u=s.push.bind(s);s.push=t,s=s.slice();for(var l=0;l<s.length;l++)t(s[l]);var f=u;a.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("56d7")},"56d7":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var n=r("7a23");function o(e,t,r,o,a,c){var i=Object(n["s"])("Header"),s=Object(n["s"])("router-view"),u=Object(n["s"])("Footer");return Object(n["o"])(),Object(n["c"])("div",null,[Object(n["f"])(i),Object(n["f"])(s),Object(n["f"])(u)])}var a={class:"header"},c=Object(n["e"])('<h1 class="logo"><img src="/images/logo.png" alt=""></h1><div class="iconList"><i class="fa-solid fa-square-plus"></i><i class="fa-solid fa-heart"></i><i class="fa-solid fa-paper-plane"></i><img src="/images/example.jpeg" alt="유저이미지"></div>',2),i=[c];function s(e,t){return Object(n["o"])(),Object(n["c"])("div",a,i)}var u=r("6b0d"),l=r.n(u);const f={},d=l()(f,[["render",s]]);var p=d,b={class:"footer"},v=Object(n["d"])("i",{class:"fa-solid fa-house"},null,-1),h=Object(n["d"])("i",{class:"fa-solid fa-magnifying-glass"},null,-1),j=Object(n["d"])("i",{class:"fa-solid fa-clapperboard"},null,-1),O=Object(n["d"])("i",{class:"fa-solid fa-circle-user"},null,-1),g=[v,h,j,O];function m(e,t){return Object(n["o"])(),Object(n["c"])("div",b,g)}const y={},w=l()(y,[["render",m]]);var P=w,k={name:"App",components:{Header:p,Footer:P}};const x=l()(k,[["render",o]]);var _=x,S=(r("d3b7"),r("3ca3"),r("ddb0"),r("6c02")),M=[{path:"/",component:function(){return r.e("chunk-722943b3").then(r.bind(null,"cd56"))}}],T=Object(S["a"])({history:Object(S["b"])("/"),routes:M}),E=T,L=Object(n["b"])(_).use(E);L.mount("#app")}});
//# sourceMappingURL=app.8d39d5a8.js.map