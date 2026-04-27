package uz.pdp.calling_external_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.calling_external_api.entity.Post;
import uz.pdp.calling_external_api.mapper.PostMapper;
import uz.pdp.calling_external_api.payload.CommentResponse;
import uz.pdp.calling_external_api.payload.PostCreator;
import uz.pdp.calling_external_api.payload.PostResponse;
import uz.pdp.calling_external_api.payload.PostResponseWithComments;
import uz.pdp.calling_external_api.repository.PostRepository;
import uz.pdp.calling_external_api.service.PostService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public PostResponse create(PostCreator creator) {
        Post entity = postMapper.toEntity(creator);
        Post save = postRepository.save(entity);

        return postMapper.toResponse(save);
    }

    @Override
    public PostResponse findById(Integer id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return postMapper.toResponse(optionalPost.get());
        }
        throw new RuntimeException("Post not found...");
    }

    @Override
    public PostResponseWithComments findByIdWithComments(Integer id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            RestTemplate restTemplate = new RestTemplate();

            String url = "http://localhost:7070/api/comments/findByPostId/{0}";
///  way 1
//            ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class, id);
//            List body = responseEntity.getBody();

/// way 2
            List body = restTemplate.getForObject(url, List.class, id);


            return new PostResponseWithComments(
                    post.getId(),
                    post.getTitle(),
                    post.getBody(),
                    body
            );
        }
        throw new RuntimeException("Post not found...");
    }
}
