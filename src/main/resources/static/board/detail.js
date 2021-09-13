/*
    게시판 상세내용 및 수정 detail
*/

let init = function(){
    main.init();
}

let main = (function(){
    return {
        init : function(){
            Event.click();
        }
    }
}());

let Event = (function () {
    return {
        click : function(){
            //UI 이벤트 처리
            jQuery('#btnUpdateDetail').off('click').on('click', function (){
                jQuery('#updateView').show();
                jQuery('#detailView').hide();
            });

            jQuery('#btnUpdateCancel').off('click').on('click', function (){
                jQuery('#detailView').show();
                jQuery('#updateView').hide();
            });

            jQuery('#btnBoardDelete').off("click").on('click', function (){
                var params={
                    boardNo : jQuery('#boardNo').val()
                };

                $.ajax({
                    url: "/board/delete",
                    dataType: "json",
                    data: params,
                    type:"POST",
                    success: function(result){
                        var resultData = result;
                        console.log("성공 : " + resultData);
                        if(resultData.responseMessage == "success"){
                            location.href="/board/list";
                        }else{
                            console.log(resultData.resultList);
                            var boardNo = resultData.resultList.no;
                            location.href="/board/" +boardNo;
                        }
                    }
                });
            });
        }
    }
}());

jQuery(document).ready(function(){
    init();
});