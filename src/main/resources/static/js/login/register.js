/*
    login 페이지
*/
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//코드 정의
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//상수


//--------------------------------------------------------------------------------------------------------------------------------------------------------
//시작 부분
//--------------------------------------------------------------------------------------------------------------------------------------------------------
let init = function () {
    main.init();
};
//--------------------------------------------------------------------------------------------------------------------------------------------------------
// 메인 함수 정의 부분
//--------------------------------------------------------------------------------------------------------------------------------------------------------
var main = (function () {
    return {
        init: function () {
            //시작과 동시에 할 작업 등..
            util.datePicker();
        }
    }
}());

//--------------------------------------------------------------------------------------------------------------------------------------------------------
//이벤트 함수 정의 부분
//--------------------------------------------------------------------------------------------------------------------------------------------------------
var Event = (function () {
    return {
        enterClick: function () {
            //UI 이벤트 처리
            jQuery('#register').off('click').on('click', function (){
                location.href = "/login/register";
                // alert("Sign Up");
            });
            // jQuery('#signIn').keypress(function (key){
            //    if(key.keyCode == 13){
            //        jQuery('#loginForm').submit();
            //    }
            // });


        }
    }
}());

//--------------------------------------------------------------------------------------------------------------------------------------------------------
//유틸성 함수 정의 부분
//--------------------------------------------------------------------------------------------------------------------------------------------------------
let util = (function () {
    return {
        datePicker: function () {
            //공통 및 유틸적성격의 함수 처리
            $("#datepicker").datepicker({
                language: 'ko',
                autoClose: true
            });
        }
    }
}());

jQuery(document).ready(function () {
    //시작 호출
    init();
});