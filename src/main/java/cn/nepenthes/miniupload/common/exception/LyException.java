package cn.nepenthes.miniupload.common.exception;

import cn.nepenthes.miniupload.common.exception.enums.ExceptionEnum;
import lombok.Getter;

@Getter
public class LyException extends RuntimeException {

    //增加状态码
    private Integer status;

    public LyException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getStatus();
    }

    public LyException(ExceptionEnum exceptionEnum, Throwable cause) {
        super(exceptionEnum.getMessage(), cause);
        this.status = status;
    }
}
