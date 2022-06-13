package com.fancx.common.result;

public class CommonResultUtil {
    public static CommonResultData success() {
        return new CommonResultData<>(CommonResultCode.SUCCESS.getCode(), CommonResultCode.SUCCESS.getMessage());
    }

    public static <T> CommonResultData<T> success(T data) {
        return new CommonResultData<T>(CommonResultCode.SUCCESS.getCode(), CommonResultCode.SUCCESS.getMessage(), data);
    }

    public static CommonResultData<String> fail(ResultCode resultCode) {
        return new CommonResultData<>(resultCode.getCode(), resultCode.getMessage());
    }
}
