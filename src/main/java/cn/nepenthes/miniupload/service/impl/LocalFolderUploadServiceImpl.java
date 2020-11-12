package cn.nepenthes.miniupload.service.impl;

import cn.nepenthes.miniupload.controller.LocalFolderUploadController;
import cn.nepenthes.miniupload.entity.FolderDataEntity;
import cn.nepenthes.miniupload.service.LocalFolderUploadService;
import cn.nepenthes.miniupload.utils.BaseUtil;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class LocalFolderUploadServiceImpl implements LocalFolderUploadService {
    private static final Logger logger = LoggerFactory.getLogger(LocalFolderUploadServiceImpl.class);

    private static List<String> allowedTypes = Arrays.asList("application/zip", "application/octet-stream");
    private static List<String> allowedSuffixs = Arrays.asList(".zip", ".ZIP");

    // 本地文件保存路径前缀(绝对路径)
    @Value("${local.savepath.prefix:/Users/superl/data/uploads}")
    private String savePathPrefix;

    // 本地文件访问URL前缀
    @Value("${local.url.prefix:http://file.nepenthes.cn}")
    private String urlPrefix;

    public FolderDataEntity upload(String userName, MultipartFile file, boolean isOriginal, String path, String passwd) throws Exception {
        FolderDataEntity folderFileDataEntity = new FolderDataEntity();

        //校验文件mime类型 是否为合法
        this.checkFileType(file);

        // 文件大小
        folderFileDataEntity.setFolderSize(file.getSize());

        // 上传文件原始名称
        String origName = file.getOriginalFilename();

        // 获取后缀
        String suffix = this.getSuffix(origName);

        // 校验后缀合法性
        this.checkSuffix(suffix);

        // 把ZIP文件移动到临时目录
        String zipTempFilePath = String.format("%s/%s/%s/", savePathPrefix, userName, "temp");
        File tempZipDir = new File(zipTempFilePath);
        if (!tempZipDir.exists()) {
            tempZipDir.mkdir();
        }

        File tempfile = new File(zipTempFilePath + BaseUtil.getUUID32());  // ZIP的临时目录
        file.transferTo(tempfile);

        // 保存的文件夹名称
        String folderSaveName = !isOriginal ? BaseUtil.getUUID32():origName;

        String folderPathReal = "";        // 新文件夹保存的目录
        String folderPathDb = "";          // 数据库中保存的目录
        String folderUrl = "";             // URL访问地址

        if (!"".equals(path)){
            folderPathReal = String.format("%s/%s/%s/%s", savePathPrefix, userName, path, folderSaveName);
            folderPathDb = path;
            folderUrl = String.format("%s/%s/%s/%s", urlPrefix, userName, path, folderSaveName);
        }else{
            folderPathReal = String.format("%s/%s", savePathPrefix, userName);
            folderPathDb = "";
            folderUrl = String.format("%s/%s/%s", urlPrefix, userName, folderSaveName);
        }


        // 解压到指定目录
        try {
            ZipFile zFile = new ZipFile(tempfile);

            // 验证.zip文件是否合法，包括文件是否存在、是否为zip文件、是否被损坏等
            if (!zFile.isValidZipFile()) {
                throw new ZipException("压缩文件不合法,可能被损坏.");
            }

            // 解压目录
            File destDir = new File(folderPathReal);
            if (!destDir.exists()) {
                destDir.mkdir();
            }

            if (zFile.isEncrypted()) {
                zFile.setPassword(passwd.toCharArray());  // 设置密码
            }

            // 将文件抽出到解压目录(解压)
            zFile.extractAll(folderPathReal);

            // 删除原ZIP文件
            tempfile.delete();

        } catch (IOException e) {
            throw new ZipException(e.getMessage());
        }

        folderFileDataEntity.setFolderName(folderSaveName);
        folderFileDataEntity.setFolderPath(folderPathDb);
        folderFileDataEntity.setFolderUrl(folderUrl);
        folderFileDataEntity.setCreatedAt(new Date());
        return folderFileDataEntity;
    }

    /**
     * 校验文件类型
     * @param file
     * @return
     * @throws Exception
     */
    private boolean checkFileType(MultipartFile file) throws Exception {
        //校验文件mime类型 是否为合法
        String contentType = file.getContentType();
        if(!allowedTypes.contains(contentType)){
            throw new Exception("文件类型不匹配");
        }
        return true;
    }

    /**
     * 校验后缀
     * @param suffix
     * @return
     */
    private boolean checkSuffix(String suffix) throws Exception {
        if(!allowedSuffixs.contains(suffix)){
            throw new Exception("文件后缀不匹配");
        }
        return true;
    }

    private String getSuffix(String filename) throws Exception {
        if ( filename == null){
            throw new Exception("文件名为空!");
        }
        int beginIndex = filename.lastIndexOf(".");
        String suffix = filename.substring(beginIndex);
        return suffix;
    }
}
