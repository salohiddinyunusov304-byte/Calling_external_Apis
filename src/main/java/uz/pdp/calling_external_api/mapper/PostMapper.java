package uz.pdp.calling_external_api.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.pdp.calling_external_api.entity.Post;
import uz.pdp.calling_external_api.feign_clients.CommentClient;
import uz.pdp.calling_external_api.payload.PostCreator;
import uz.pdp.calling_external_api.payload.PostResponse;
import uz.pdp.calling_external_api.payload.PostResponseWithComments;

@Component
@RequiredArgsConstructor
public class PostMapper {
    private final CommentClient commentClient;

    public Post toEntity(PostCreator creator) {
        Post post = new Post();
        post.setTitle(creator.title());
        post.setBody(creator.body());
        return post;
    }

    public PostResponse toResponse(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getBody()
        );
    }

    public PostResponseWithComments toResponseWithComments(Post post) {
        return new PostResponseWithComments(
                post.getId(),
                post.getTitle(),
                post.getBody(),
                commentClient.findByPostId(post.getId())
        );
    }
}
