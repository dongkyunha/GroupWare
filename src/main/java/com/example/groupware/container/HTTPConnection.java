package com.example.groupware.container;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedRuntimeException;
import org.springframework.expression.AccessException;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.invoke.MethodType;
import java.rmi.ConnectException;
import java.util.*;

@Slf4j
@Component
public class HTTPConnection {

    public <T> T sendGet(String url, String charSet, Class<?> Clazz, T t, MultiValueMap<String,String> uriVariables, MediaType mediaType, List<MediaType> acceptMediaType, MultiValueMap<String, String> headersVariables) throws Exception {
        return (T) sendHTTP(url, charSet, Clazz, t, uriVariables, mediaType, acceptMediaType, headersVariables);
    }

    public <T> T sendPost(String url, String charSet, Class<?> Clazz, T t, MultiValueMap<String, String> uriVariables, MediaType mediaType, List<MediaType> acceptMediaType, MultiValueMap<String, String> headersVariables) throws Exception {

        return (T) sendHTTP(url, charSet, Clazz, t, uriVariables, mediaType, acceptMediaType, headersVariables);
    }

    public <T> HttpHeaders createHeaders(MediaType mediaType, List<MediaType> acceptMediaType, MultiValueMap<String,String> headersVariables){
        HttpHeaders headers = new HttpHeaders();

        if(mediaType == null && acceptMediaType == null){
            headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
            headers.setContentType(MediaType.TEXT_PLAIN);
        }else{
            if(CollectionUtils.isEmpty(acceptMediaType)){
                headers.setAccept(Collections.singletonList(mediaType));
            }else{
                headers.setAccept(acceptMediaType);
            }
            headers.setContentType(mediaType);
        }

        if(headersVariables != null){
            Iterator<String> it = (Iterator<String>) headersVariables.keySet().iterator();
            while(it.hasNext()){
                String keyStr = it.next();
                headers.set(keyStr, headersVariables.getFirst(keyStr));
            }
        }

        return headers;
    }

    private <T> T sendHTTP(String url, String charSet, Class<? extends T> Clazz, T t, MultiValueMap<? extends String, ? extends String> uriVariables, MediaType mediaType, List<MediaType> acceptMediaType, MultiValueMap<String, String> headersVariables) throws Exception {

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

    private <T> T sendInterface(String url, String charSet, Class<? extends T> Clazz, T t, HttpMethod method, MultiValueMap<? extends String, ? extends String> uriVariables, MediaType mediaType, List<MediaType> acceptMediaType, MultiValueMap<String, String> headersVariables) throws Exception {

        try {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);
            if(method == HttpMethod.GET){
                Iterator<String> it = (Iterator<String>) uriVariables.keySet().iterator();
                while (it.hasNext()){
                    String keyStr = it.next();
                    url += keyStr;
                }
            }
            log.debug(url);
            url = uriBuilder.build().encode().toString();

            HttpHeaders headers = createHeaders(mediaType, acceptMediaType, headersVariables);

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
                case BAD_REQUEST:
                case UNAUTHORIZED:
                case NOT_FOUND:
                case INTERNAL_SERVER_ERROR:
                case SERVICE_UNAVAILABLE:
//                    throw new SendInterfaceException("내부 통신 실패", "999");
                    throw new Exception("Exception");
                default:
//                    throw new SendInterfaceException("내부 통신 알수 없는 오류", "999");
                    throw new Exception("Exception");
            }

            return (T) response.getBody();
        }catch(HttpClientErrorException e){
            log.error("HttpClientErrorException", e);
            throw new Exception("HttpClientErrorException", e);
        }catch(HttpServerErrorException e){
            log.error("HttpServerErrorException", e);
            throw new Exception("HttpServerErrorException", e);
        }catch(RestClientException e){
            log.error("RestClientException", e);
            throw new Exception("RestClientException", e);
        }catch(NestedRuntimeException e){
            log.error("NestedRuntimeException", e);
            throw new Exception("NestedRuntimeException", e);
        }catch(InvalidMediaTypeException e){
            log.error("InvalidMediaTypeException", e);
            throw new Exception("InvalidMediaTypeException", e);
        }catch (Exception e){
            log.error("Exception", e);
            throw new Exception("Exception", e);
        }
    }
}
