package uz.pdp.calling_external_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.calling_external_api.payload.*;
import uz.pdp.calling_external_api.service.impl.CommentsConnectorService;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentsConnectorService commentsConnectorService;

    @PostMapping("/create")
    public CommentResponse create(@RequestBody CommentCreator creator) {
        return commentsConnectorService.createComment(creator);
    }
}