package uz.pdp.calling_external_api.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.calling_external_api.entity.Post;
import uz.pdp.calling_external_api.payload.PostCreator;
import uz.pdp.calling_external_api.payload.PostResponse;

@Component
public class PostMapper {
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
}
