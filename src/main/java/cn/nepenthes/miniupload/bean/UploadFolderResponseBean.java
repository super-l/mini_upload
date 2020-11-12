package cn.nepenthes.miniupload.bean;

import lombok.Data;

@Data
public class UploadFolderResponseBean {
    String folderName;
    String folderPath;
    long   foldereSize;
    String folderUrl;
}
