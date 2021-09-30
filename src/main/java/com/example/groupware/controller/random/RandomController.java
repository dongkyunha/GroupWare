package com.example.groupware.controller.random;

import com.example.groupware.container.RandomGenerate;
import com.example.groupware.container.ResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/random")
public class RandomController {

    public RandomGenerate randomGenerate;

    private String ENGLISH_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private String ENGLISH_UPPER = ENGLISH_LOWER.toUpperCase();
    private String NUMBER = "0123456789";

    @GetMapping(value = "/list")
    public ModelAndView findBoardWhereAll(ModelAndView mav){
        mav.setViewName("random/randomCreate");
        return mav;
    }

    @PostMapping(value = "/createComplex")
    @ResponseBody
    public ResultSet<String> createComplex(){
        ResultSet<String> resultSet = new ResultSet<>();

        /** 랜덤을 생성할 대상 문자열 **/
        String DATA_FOR_RANDOM_STRING = ENGLISH_LOWER + ENGLISH_UPPER + NUMBER;
        /** 랜덤 문자열 길이 **/
        int random_string_length=10;

//        System.out.println("DATA_FOR_RANDOM_STRING ==> " + DATA_FOR_RANDOM_STRING);
        for (int i = 0; i < 10; i++) {
            String randomNum = randomGenerate.generate(DATA_FOR_RANDOM_STRING, random_string_length);
            System.out.println("random " + i + " : " + randomNum);
            resultSet.setResultList(randomNum);
        }
        return resultSet;
    }

    @PostMapping(value = "/createNum")
    @ResponseBody
    public ResultSet<String> createNum(){
        ResultSet<String> resultSet = new ResultSet<>();

        /** 랜덤을 생성할 대상 문자열 **/
        String DATA_FOR_RANDOM_STRING = NUMBER;
        /** 랜덤 문자열 길이 **/
        int random_string_length=10;

//        System.out.println("DATA_FOR_RANDOM_STRING ==> " + DATA_FOR_RANDOM_STRING);
        for (int i = 0; i < 10; i++) {
            String randomNum = randomGenerate.generate(DATA_FOR_RANDOM_STRING, random_string_length);
            System.out.println("random " + i + " : " + randomNum);
            resultSet.setResultList(randomNum);
        }
        return resultSet;
    }

    @PostMapping(value = "/createText")
    @ResponseBody
    public ResultSet<String> createText(){
        ResultSet<String> resultSet = new ResultSet<>();

        /** 랜덤을 생성할 대상 문자열 **/
        String DATA_FOR_RANDOM_STRING = ENGLISH_LOWER + ENGLISH_UPPER;
        /** 랜덤 문자열 길이 **/
        int random_string_length=10;

//        System.out.println("DATA_FOR_RANDOM_STRING ==> " + DATA_FOR_RANDOM_STRING);
        for (int i = 0; i < 10; i++) {
            String randomNum = randomGenerate.generate(DATA_FOR_RANDOM_STRING, random_string_length);
            System.out.println("random " + i + " : " + randomNum);
            resultSet.setResultList(randomNum);
        }
        return resultSet;
    }
}
