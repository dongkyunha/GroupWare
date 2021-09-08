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
                        console.log("성공 : " + result);
                        if(result.responseMessage == "success"){
                            location.href="/board/list";
                        }else{
                            var result = result.resultList;
                            console.log(result);
                            // location.href="/board/" +no;
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