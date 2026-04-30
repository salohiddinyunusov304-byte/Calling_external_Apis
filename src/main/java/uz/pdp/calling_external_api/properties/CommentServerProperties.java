package uz.pdp.calling_external_api.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "comment-server")
public record CommentServerProperties(
        String baseUrl,
        String getCommentByPostId,
        String create
) {
}
