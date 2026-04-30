package uz.pdp.calling_external_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import uz.pdp.calling_external_api.payload.CommentCreator;
import uz.pdp.calling_external_api.payload.CommentResponse;
import uz.pdp.calling_external_api.properties.CommentServerProperties;

import org.springframework.http.HttpHeaders;

@Service
@RequiredArgsConstructor
public class CommentsConnectorService {
//    private final RestTemplate restTemplate;
    private final CommentServerProperties commentServerProperties;

    public CommentResponse createComment(CommentCreator creator) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.setBasicAuth("admin", "123");
        HttpEntity http = new HttpEntity<>(creator, headers);


        return null;
    }

//    public CommentResponse createComment(CommentCreator creator) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
//        headers.setBasicAuth("admin", "123");
//        HttpEntity http = new HttpEntity<>(creator, headers);
//
//        try {
//            ResponseEntity<CommentResponse> exchange = restTemplate.exchange(
//                    commentServerProperties.create(),
//                    HttpMethod.POST,
//                    http,
//                    new ParameterizedTypeReference<>() {
//                    }
//            );
//            return exchange.getBody();
//        } catch (ResourceAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
