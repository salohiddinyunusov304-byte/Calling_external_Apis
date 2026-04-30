package uz.pdp.calling_external_api.payload;

public record CommentCreator(
        String comment,
        Integer postId
) {
}
