/*
    난수 생성
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
let main = (function () {
    return {
        init : function(){
            Event.click();
        }
    }
}());

//--------------------------------------------------------------------------------------------------------------------------------------------------------
//이벤트 함수 정의 부분
//--------------------------------------------------------------------------------------------------------------------------------------------------------
let Event = (function () {
    return {
        click : function(){
            //UI 이벤트 처리
            jQuery('#home').off('click').on('click', function (){
                location.href = '/login/home';
            });

            jQuery('#createComplex').off('click').on('click', function (){
                $.ajax({
                    url: "/random/createComplex",
                    dataType: "json",
                    type:"POST",
                    success: function(result){
                        var resultData = result;
                        console.log("성공 : " + resultData.resultList);
                        jQuery('#randomComplex').val(resultData.resultList);
                        jQuery('#randomComplex2').html(resultData.resultList);
                    }
                });
            });

            jQuery('#createOnlyNum').off('click').on('click', function (){
                $.ajax({
                    url: "/random/createNum",
                    dataType: "json",
                    type:"POST",
                    success: function(result){
                        var resultData = result;
                        console.log("성공 : " + resultData.resultList);
                        jQuery('#randomNum').val(resultData.resultList);
                        jQuery('#randomNum2').html(resultData.resultList);
                    }
                });
            });

            jQuery('#createText').off('click').on('click', function (){
                $.ajax({
                    url: "/random/createText",
                    dataType: "json",
                    type:"POST",
                    success: function(result){
                        var resultData = result;
                        console.log("성공 : " + resultData.resultList);
                        jQuery('#randomText').val(resultData.resultList);
                        jQuery('#randomText2').html(resultData.resultList);
                    }
                });
            });
        }
    }
}());

jQuery(document).ready(function () {
    //시작 호출
    init();
});