package cn.nepenthes.miniupload.service.impl;

import cn.nepenthes.miniupload.entity.FileDataEntity;
import cn.nepenthes.miniupload.service.LocalFileUploadService;
import cn.nepenthes.miniupload.utils.BaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class LocalFileUploadServiceImpl implements LocalFileUploadService {

    private static List<String> allowedTypes = Arrays.asList("image/jpeg", "image/png", "image/gif");

    // 本地文件保存路径前缀(绝对路径)
    @Value("${local.savepath.prefix:/Users/superl/data/uploads}")
    private String savePathPrefix;

    // 本地文件访问URL前缀
    @Value("${local.url.prefix:http://file.nepenthes.cn}")
    private String urlPrefix;

    public FileDataEntity upload(MultipartFile file, boolean isOriginal, String path, String userName) throws Exception {
        //校验文件mime类型 是否为合法
        this.checkFileType(file);

        long fileSize = file.getSize();                          // 文件大小
        String origName = file.getOriginalFilename();            // 上传文件原始名称

        // 保存的文件名
        String saveName = origName;
        if ( !isOriginal){
            //截取上传的文件名的后缀类型，比如.jpg
            int beginIndex = origName.lastIndexOf(".");
            String suffix = origName.substring(beginIndex);

            saveName = String.format("%s%s", BaseUtil.getUUID32(), suffix); // 新的图片的名称
        }

        String savePathReal;         // 新文件保存的目录
        String savePathDb = "";      // 数据库中保存的目录
        String url;                  // URL访问地址

        if (!"".equals(path)){
            savePathReal = String.format("%s/%s/%s", savePathPrefix, userName, path);
            savePathDb = path;
            url = String.format("%s/%s/%s/%s", urlPrefix, userName, path, saveName);
        }else{
            savePathReal = String.format("%s/%s", savePathPrefix, userName);
            savePathDb = "";
            url = String.format("%s/%s/%s", urlPrefix, userName, saveName);
        }

        // 如果保存目录不存在，则创建
        File parentPath = new File(savePathReal);
        if (!parentPath.exists()) {
            parentPath.mkdirs();
        }

        // 新文件保存的绝对路径
        String saveFilePathReal = String.format("%s/%s", savePathReal, saveName);

        // 移动到指定文件
        File newfile = new File(saveFilePathReal);
        file.transferTo(newfile);

        FileDataEntity fileDataEntity = new FileDataEntity();
        fileDataEntity.setFileName(saveName);
        fileDataEntity.setFilePath(savePathDb);
        fileDataEntity.setFileSize(fileSize);
        fileDataEntity.setMethod(1);
        fileDataEntity.setFileUrl(url);

        return fileDataEntity;
    }

    /**
     * 校验文件类型
     * @param file
     * @return
     * @throws Exception
     */
    private boolean checkFileType(MultipartFile file) throws Exception {
        return true;
    }


}
