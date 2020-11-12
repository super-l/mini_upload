package cn.nepenthes.miniupload.bean;

import lombok.Data;

@Data
public class UploadResponseBean {
    String saveName;
    String savePath;
    long   fileSize;
    String url;
}
