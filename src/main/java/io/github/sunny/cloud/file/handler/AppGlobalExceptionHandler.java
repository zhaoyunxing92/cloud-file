/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.handler;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author zhaoyunxing92
 * @date: 2020-04-04 23:52
 */
@RestControllerAdvice
public class AppGlobalExceptionHandler {
    /**
     * 文件超出限制异常
     *
     * @param ex MaxUploadSizeExceededException
     * @return ResponseEntity
     */
    @ExceptionHandler({MaxUploadSizeExceededException.class})
    public ResponseEntity<Object> fileSizeLimitException(MaxUploadSizeExceededException ex) {
        String msg = ex.getMessage();
        assert msg != null;
        return ResponseEntity.status(HttpStatus.NOT_EXTENDED).body(msg.substring(msg.lastIndexOf(":") + 1));
    }
}
