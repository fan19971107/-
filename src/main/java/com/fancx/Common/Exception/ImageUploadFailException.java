package com.fancx.Common.Exception;

import com.fancx.Common.Result.CommonResultCode;
import com.fancx.Common.Result.ResultCode;
import lombok.Data;

@Data
public class ImageUploadFailException extends RuntimeException {
    ResultCode resultCode= CommonResultCode.IMAGE_UPLOAD_FAILED;
}
