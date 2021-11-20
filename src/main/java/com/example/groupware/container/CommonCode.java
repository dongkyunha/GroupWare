package com.example.groupware.container;

public enum CommonCode {
    YES("Y"),
    NO("N")
    ;

    public String code;

    private CommonCode(String code){
        this.code = code;
    }

    public String CommonCode(){
        return code;
    }
}
