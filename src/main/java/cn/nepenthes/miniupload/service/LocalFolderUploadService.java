package cn.nepenthes.miniupload.service;

import cn.nepenthes.miniupload.entity.FolderDataEntity;
import org.springframework.web.multipart.MultipartFile;


public interface LocalFolderUploadService {

    FolderDataEntity upload( String userName, MultipartFile file, boolean isOriginal, String path, String password) throws Exception;
}
