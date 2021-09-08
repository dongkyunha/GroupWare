package com.example.groupware.container;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResultSet<T> {
    private String responseMessage = "success";	//성공여부
    private Object resultList;			//결과


    public ResultSet() {}

    //default
    public ResultSet(T resultList) {
        this.resultList = resultList;
    }
}
