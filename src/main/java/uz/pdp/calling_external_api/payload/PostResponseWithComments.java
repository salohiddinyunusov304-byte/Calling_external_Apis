package uz.pdp.calling_external_api.payload;

import java.util.List;

public record PostResponseWithComments(
        Integer id,
        String title,
        String body,
        List<?> comments
) {
}
