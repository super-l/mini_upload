package cn.nepenthes.miniupload.service;

import cn.nepenthes.miniupload.entity.FileDataEntity;
import org.springframework.web.multipart.MultipartFile;


public interface LocalFileUploadService {

    FileDataEntity upload(MultipartFile file, boolean isOriginal, String path, String userName) throws Exception;
}
