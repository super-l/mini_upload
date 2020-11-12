package cn.nepenthes.miniupload.service;

import cn.nepenthes.miniupload.entity.ImageDataEntity;
import org.springframework.web.multipart.MultipartFile;


public interface LocalImageUploadService {

    ImageDataEntity upload(MultipartFile file, boolean isOriginal, String path, boolean createThum, String userName) throws Exception;
}
