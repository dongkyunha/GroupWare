/*
    게시판 생성 insert
*/

let init = function(){
    main.init();
}

let main = (function(){
    return {
        init : function(){
            console.log("자바스크립트 바인딩 테스트");

            Event.click();
        }
    }
}());

let Event = (function () {
    return {
        click : function(){
            //UI 이벤트 처리
            jQuery('#home').off('click').on('click', function (){
                location.href = '/home';
            });
        }
    }
}());

jQuery(document).ready(function(){
    console.log("인잇");
    init();
});