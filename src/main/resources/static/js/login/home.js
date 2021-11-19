/*
    게시판 생성 insert
*/
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//코드 정의
var Target = document.getElementById("clock");
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//상수

//--------------------------------------------------------------------------------------------------------------------------------------------------------
//시작 부분
//--------------------------------------------------------------------------------------------------------------------------------------------------------
let init = function(){
    main.init();
}

let main = (function(){
    return {
        init : function(){
            console.log("자바스크립트 바인딩 테스트");

            Event.clock();
        }
    }
}());

let Event = (function () {
    return {
        clock : function (){
            var time = new Date();

            var month = time.getMonth();
            var date = time.getDate();
            var day = time.getDay();
            var week = ['일', '월', '화', '수', '목', '금', '토'];

            var hours = time.getHours();
            var minutes = time.getMinutes();
            var seconds = time.getSeconds();

            Target.innerText =
                `${month + 1}월 ${date}일 ${week[day]}요일 ` +
                `${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes}` : minutes}:${seconds < 10 ? `0${seconds}` : seconds}`;

            setInterval(Event.clock, 1000); // 1초마다 실행
        }
    }
}());

jQuery(document).ready(function(){
    console.log("인잇");
    init();
});