package com.example.groupware.container;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestAPIConnector {

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

    private <T> T Interface(String url,Class<?> responseType, T t, HttpMethod method, MediaType mediaType){

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);

        try {


            url = uriBuilder.build().encode().toString();

            HttpEntity<?> requestEntity = null;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(mediaType);

//            requestEntity = new HttpEntity<T>(t, headers);
            requestEntity = new HttpEntity<T>(headers);


            //통신
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(url, method, requestEntity, String.class);

        }catch (Exception e){
            e.getMessage();
        }finally {

        }

        return t;
    }
}
