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
            jQuery('#updateDetail').off('click').on('click', function (){
                //데이터를 가지고 이동
                var params={
                    boardNO : jQuery('#boardNo').val()
                };

                $.ajax({
                    url: "/board/insertView",
                    data: params,
                    type:"POST",
                    success: function(result){

                    },
                    error: function (e){

                    }
                });
            })
        }
    }
}());

jQuery(document).ready(function(){
    init();
});