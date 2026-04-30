package uz.pdp.calling_external_api.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true) // record class buni avto ishlatadi
public record BaseResponse<T> (
        T data,
        ErrorData error,
        boolean success
) {
    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(data, null, true);
    }

    public static <T> BaseResponse<T> ok() {
        return new BaseResponse<>(null, null, true);
    }

    public static <T> BaseResponse<T> error(ErrorData errorData) {
        return new BaseResponse<>(null, errorData, false);
    }


}
