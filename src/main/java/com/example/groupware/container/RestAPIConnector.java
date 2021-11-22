package com.example.groupware.container;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestAPIConnector<T> {

    public <T> T sendGet(T t){
        return t;
    }

    public <T> T sendPost(T t){
        Map<String, Object> uriVariables = new HashMap<>();
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(header);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange("", HttpMethod.POST,requestEntity, Map.class, uriVariables);

        return t;
    }

    private <T> T Interface(String url,Class<?> responseType, T t){

        try {

            HttpEntity<?> response = null;
        }catch (Exception e){
            e.getMessage();
        }finally {

        }

        return t;
    }
}
