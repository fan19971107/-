package com.fancx.Admin.Result;

import com.fancx.Common.Result.CommonResultData;
import com.fancx.Common.Result.ResultCode;

public class AdminResultUtil {

    public static CommonResultData<String> fail(ResultCode resultCode) {
        return new CommonResultData(resultCode.getCode(), resultCode.getMessage());
    }
}
