package cn.nepenthes.miniupload.common.exception.vo;

import lombok.Data;

import java.util.Date;

/**
 * 给前端展示异常信息
 */
@Data
public class ExceptionResult {

    private Integer status;
    private String message;
    private Date timestampt;


    public ExceptionResult(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.timestampt = new Date();
    }
}
