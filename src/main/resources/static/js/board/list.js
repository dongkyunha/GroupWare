/*
    게시판 생성 insert
*/
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//코드 정의
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//상수
var today = new Date();
var Target = document.getElementById("clock");
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

            Event.click();
        }
    }
}());

let Event = (function () {
    return {
        click : function(){
            jQuery('#choiceSize').off('change').on('change', function (){
                const size = jQuery('#choiceSize option:selected').val();
                location.href = '?page='+ '1' + '&size=' + size;
                // console.log(size);
            });

            jQuery('#btnSearch').off('click').on('click', function () {
                const searchType = jQuery('#searchType').val();
                const searchContent = jQuery('#searchContent').val();
                console.log(searchType);
                console.log(searchContent);
            });


            jQuery('#home').off('click').on('click', function (){
                console.log(location.href);
                location.href = '/login/home';
            });
        }
    }
}());

jQuery(document).ready(function(){
    console.log("인잇");
    init();
});