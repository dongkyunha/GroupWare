package com.example.groupware.container;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class HTTPConnection {

    public <T> T sendGet(T t){
        return t;
    }

    public <T> T sendPost(T t){
        return t;
    }

    public <T> HttpHeaders createHearder(String url, T t, MultiValueMap<?,?> uriVariables){
        HttpHeaders headers = new HttpHeaders();

        return headers;
    }

    private <T> Map<String, Object> sendHTTP(String url, Class<?> responseType, T t, HttpMethod method, MediaType mediaType, MultiValueMap<?,?> multiValueMap, Map<? extends String, ? extends String> uriVariables){

        if(method != null){
            return sendInterface(url, responseType, t, HttpMethod.GET, mediaType, multiValueMap, uriVariables);
        }else{
            if(t == null){
                return sendInterface(url, responseType, null, HttpMethod.POST, mediaType, multiValueMap, uriVariables);
            }else{
                return sendInterface(url, responseType, t, HttpMethod.POST, mediaType, multiValueMap, uriVariables);
            }
        }
    }

    private <T> Map<String, Object> sendInterface(String url, Class<?> responseType, T t, HttpMethod method, MediaType mediaType, MultiValueMap<?,?> multiValueMap, Map<? extends String, ? extends String> uriVariables){

        Map<String, Object> result = new HashMap<>();

        try {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);
            url = uriBuilder.build().encode().toString();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(mediaType);

            HttpEntity<?> requestEntity = null;
            if(t != null){
                requestEntity = new HttpEntity<T>(t, headers);
            }else{
                requestEntity = new HttpEntity<T>(headers);
            }

            //통신
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<?> response = restTemplate.exchange(url, method, requestEntity, responseType);

            switch (response.getStatusCode()){
                case OK:
                    break;
                case CREATED:
                case ACCEPTED:
                case NOT_FOUND:
                case NO_CONTENT:
                case BAD_REQUEST:
                case CHECKPOINT:
                    log.error("요청 실패");
                    break;
            }
        }catch (Exception e){
            e.getMessage();
        }finally {

        }

        return result;
    }
}
