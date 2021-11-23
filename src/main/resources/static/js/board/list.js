/*
    게시판 List
*/
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//코드 정의
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

            Event.click();
        }
    }
}());

let Event = (function () {
    return {
        click : function(){
            jQuery("#choiceSize").off("change").on("change", function (){
                const size = jQuery("#choiceSize option:selected").val();
                const searchType = jQuery("#searchType").val();
                const searchContent = jQuery("#searchContent").val();

                let local = "?page=" + "1" + "&size=" + size;
                if(searchType != "" && searchContent != ""){
                    local += "&searchType=" + searchType + "&searchContent=" + searchContent;
                }
                location.href = local;
            });

            jQuery("#btnSearch").off("click").on("click", function () {
                const size = jQuery("#choiceSize option:selected").val();
                const searchType = jQuery("#searchType").val();
                const searchContent = jQuery("#searchContent").val().trim();
                let local = "?page=" + "1" + "&size=" + size;
                if(searchType != "" && searchContent != ""){
                    local += "&searchType=" + searchType + "&searchContent=" + searchContent;
                }
                location.href = local;

            });

            jQuery("#home").off("click").on("click", function (){
                location.href = "/login/home";
            });
        }
    }
}());

jQuery(document).ready(function(){
    console.log("인잇");
    init();
});