package com.example.groupware.container;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.invoke.MethodType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

    public <T> HttpHeaders createHeaders(String url, String charSet, MultiValueMap<String,String> headersVariables){
        HttpHeaders headers = new HttpHeaders();

        if(charSet == null && headersVariables == null){
//            headers.setContentType("text/plain");
//            headers.setAccept("text/plain");
        }else{

        }

        return headers;
    }

    private <T> T sendHTTP(String url, String charSet, Class<? extends T> Clazz, T t, MultiValueMap<? extends String, ? extends String> uriVariables, MediaType mediaType, List<MediaType> acceptMediaType, MultiValueMap<String, String> headersVariables){

        if(mediaType == null){
            return sendInterface(url, charSet, Clazz, t, HttpMethod.GET, uriVariables, null, null, headersVariables);
        }else{
            if(acceptMediaType == null){
                return sendInterface(url, charSet, Clazz, t, HttpMethod.POST, uriVariables, mediaType, Collections.singletonList(mediaType), headersVariables);
            }else{
                return sendInterface(url, charSet, Clazz, t, HttpMethod.POST, uriVariables, mediaType, acceptMediaType, headersVariables);
            }
        }
    }

    private <T> T sendInterface(String url, String charSet, Class<? extends T> Clazz, T t, HttpMethod method, MultiValueMap<? extends String, ? extends String> uriVariables, MediaType mediaType, List<MediaType> acceptMediaType, MultiValueMap<String, String> headersVariables){

        Map<String, Object> result = new HashMap<>();

        try {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);
            url = uriBuilder.build().encode().toString();

            HttpHeaders headers = new HttpHeaders();
            headers = createHeaders(url, charSet, headersVariables);

            HttpEntity<?> requestEntity = null;
            if(t != null){
                requestEntity = new HttpEntity<T>(t, headers);
            }else{
                requestEntity = new HttpEntity<T>(headers);
            }

            //통신
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<?> response = restTemplate.exchange(url, method, requestEntity, Clazz);

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

//            T t =  <T> response.getBody();

        }catch (Exception e){
            e.getMessage();
        }

        return t;
    }
}
