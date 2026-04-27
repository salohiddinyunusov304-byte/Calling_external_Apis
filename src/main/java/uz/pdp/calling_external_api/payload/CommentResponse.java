package uz.pdp.calling_external_api.payload;

public record CommentResponse(
        Integer id,
        String comment,
        Integer postId
) {
}
