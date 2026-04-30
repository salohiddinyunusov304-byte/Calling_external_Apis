package uz.pdp.calling_external_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.calling_external_api.payload.*;
import uz.pdp.calling_external_api.service.PostService;
import uz.pdp.calling_external_api.service.impl.CommentsConnectorService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CommentsConnectorService commentsConnectorService;

    @PostMapping("/create")
    public PostResponse create(@RequestBody PostCreator creator) {
        return postService.create(creator);
    }

    @GetMapping("/findById/{id}")
    public PostResponse findById(@PathVariable Integer id) {
        return postService.findById(id);
    }

    @GetMapping("/findByIdWithComments/{id}")
    public BaseResponse<PostResponseWithComments> findByIdWithComments(@PathVariable Integer id) {
//        throw new RuntimeException();
        PostResponse post = postService.findById(id);
        List<CommentResponse> comments = commentsConnectorService.getComments(id);

        PostResponseWithComments response = new PostResponseWithComments(
                post.id(),
                post.title(),
                post.body(),
                comments
        );

        return BaseResponse.ok(response);
//        PostResponseWithComments response = postService.findByIdWithComments(id);
//        return BaseResponse.ok(response);
    }
}