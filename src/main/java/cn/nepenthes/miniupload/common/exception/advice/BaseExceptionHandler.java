package cn.nepenthes.miniupload.common.exception.advice;

import cn.nepenthes.miniupload.common.exception.LyException;
import cn.nepenthes.miniupload.common.exception.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理：当controller层抛出异常，统一在这个类中处理
 *
 */
@ControllerAdvice
public class BaseExceptionHandler {

    //处理各种类型异常

    @ExceptionHandler(LyException.class)
    public ResponseEntity<ExceptionResult> handlerLyError(LyException e){
        return ResponseEntity.status(e.getStatus()).body(new ExceptionResult(e.getStatus(), e.getMessage()));
    }

}
