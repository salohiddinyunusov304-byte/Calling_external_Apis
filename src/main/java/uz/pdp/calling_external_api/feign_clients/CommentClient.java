package uz.pdp.calling_external_api.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.calling_external_api.payload.CommentCreator;
import uz.pdp.calling_external_api.payload.CommentResponse;

import java.util.List;

@FeignClient(value = "CommentClient", url = "http://localhost:7070/api/comments")
public interface CommentClient {
    @PostMapping("/create")
    CommentResponse create(@RequestBody CommentCreator creator);

    @GetMapping("/findByPostId/{postId}")
    List<CommentResponse> findByPostId(@PathVariable("postId") Integer postId);
}
