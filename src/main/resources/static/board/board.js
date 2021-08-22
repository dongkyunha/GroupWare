let init = function(){
    main.init();
}

let main = (function(){
    return {
        init : function(){
            console.log("자바스크립트 바인딩 테스트");
        }
    }
}());

$(document).ready(function(){
    console.log("인잇");
    init();
});