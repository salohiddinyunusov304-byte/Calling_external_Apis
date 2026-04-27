package uz.pdp.calling_external_api.payload;

public record PostResponse(
        Integer id,
        String title,
        String body
) {
}
