package com.example.groupware.controller.random;

import com.example.groupware.container.RandomGenerate;
import com.example.groupware.container.ResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
//        /** 랜덤 문자열 길이 **/
//        int random_string_length=10;

//        System.out.println("DATA_FOR_RANDOM_STRING ==> " + DATA_FOR_RANDOM_STRING);
        for (int i = 0; i < 1; i++) {
            String randomNum = randomGenerate.generate(DATA_FOR_RANDOM_STRING, 10);
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

//        System.out.println("DATA_FOR_RANDOM_STRING ==> " + DATA_FOR_RANDOM_STRING);
        for (int i = 0; i < 1; i++) {
            String randomNum = randomGenerate.generate(DATA_FOR_RANDOM_STRING, 10);
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
//        System.out.println("DATA_FOR_RANDOM_STRING ==> " + DATA_FOR_RANDOM_STRING);
        for (int i = 0; i < 1; i++) {
            String randomNum = randomGenerate.generate(DATA_FOR_RANDOM_STRING, 10);
            System.out.println("random " + i + " : " + randomNum);
            resultSet.setResultList(randomNum);
        }
        return resultSet;
    }

    @PostMapping(value = "/subList")
    public ModelAndView subList(ModelAndView mav){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
        List<Integer> subList = new ArrayList<>(list.subList(0, 3));
        System.out.println(subList);
        list.remove(0);
        System.out.println(subList);

        //#region List 출력 예제
        List listA = new ArrayList();

        listA.add("김삿갓");
        listA.add("홍아리");
        listA.add(new String("홍길동"));

        listA.add(1, "1번째 요소값");


        // 인덱스를 통한 조회
        String element0 = listA.get(0).toString();
        String element1 = listA.get(1).toString();
        String element3 = listA.get(2).toString();

        //Iterator 통한 전체 조회
        Iterator iterator = listA.iterator();
        while (iterator.hasNext()) {
            String element = (String) iterator.next();

        }

        //for-loop 통한 전체 조회
        for(Object object : listA) {
            String element = (String) object;
        }

        // 홍길동 앞에 값 추가
        int index = listA.indexOf("홍길동");
        listA.add(index, "홍길동 앞에 값 추가");

        // 존재 여부 확인
        System.out.println(listA.contains("홍길동"));

        // 값 삭제하는 방법
        System.out.println(listA.remove(0));
        System.out.println(listA.remove("홍길동"));
        //#endregion

        return mav;
    }
}
