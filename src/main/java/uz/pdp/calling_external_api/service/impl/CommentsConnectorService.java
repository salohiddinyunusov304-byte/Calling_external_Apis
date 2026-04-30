package uz.pdp.calling_external_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import uz.pdp.calling_external_api.exception.CommentServerException;
import uz.pdp.calling_external_api.payload.CommentCreator;
import uz.pdp.calling_external_api.payload.CommentResponse;
import uz.pdp.calling_external_api.properties.CommentServerProperties;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsConnectorService {
//    private final RestTemplate restTemplate;
    private final CommentServerProperties commentServerProperties;
    private final WebClient webClient;

    public List<CommentResponse> getComments(Integer postId) {
        return webClient
                .get()
                .uri(commentServerProperties.getCommentByPostId(), postId)
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.error(new CommentServerException("Server error :: From Comment Server")))
                .bodyToMono(new ParameterizedTypeReference<List<CommentResponse>>() {})
                .block();
    }

    public CommentResponse createComment(CommentCreator creator) {
        return webClient
                .post()
                .uri(commentServerProperties.create())
                .bodyValue(creator)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<CommentResponse>() {})
                .block();
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
