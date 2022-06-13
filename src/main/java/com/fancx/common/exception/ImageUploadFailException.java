package com.fancx.common.exception;

import com.fancx.common.result.CommonResultCode;
import com.fancx.common.result.ResultCode;
import lombok.Data;

@Data
public class ImageUploadFailException extends RuntimeException {
    ResultCode resultCode= CommonResultCode.IMAGE_UPLOAD_FAILED;
}
