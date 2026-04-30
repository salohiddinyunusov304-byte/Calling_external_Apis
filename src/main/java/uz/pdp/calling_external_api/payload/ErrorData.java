package uz.pdp.calling_external_api.payload;

import java.util.Map;

public record ErrorData(
        String code,
        String message,
        int httpCoe,
        Map<String, Object> details
) {
    public static ErrorData withoutDetails(String code, String message, int httpCoe, Map<String, Object> details) {
        return new ErrorData(code, message, httpCoe, null);
    }
}
