package com.fancx.admin.result;

import com.fancx.common.result.CommonResultData;
import com.fancx.common.result.ResultCode;

public class AdminResultUtil {

    public static CommonResultData<String> fail(ResultCode resultCode) {
        return new CommonResultData(resultCode.getCode(), resultCode.getMessage());
    }
}
