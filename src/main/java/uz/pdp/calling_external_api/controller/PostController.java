package uz.pdp.calling_external_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.calling_external_api.payload.BaseResponse;
import uz.pdp.calling_external_api.payload.PostCreator;
import uz.pdp.calling_external_api.payload.PostResponse;
import uz.pdp.calling_external_api.payload.PostResponseWithComments;
import uz.pdp.calling_external_api.service.PostService;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

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
        PostResponseWithComments response = postService.findByIdWithComments(id);
        return BaseResponse.ok(response);
    }
}
