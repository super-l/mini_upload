package cn.nepenthes.miniupload.bean;

import lombok.Data;

@Data
public class UploadImageResponseBean {
    String imageName;
    String imagePath;
    long   imageSize;
    String imageUrl;
    String imageThumUrl;
}
