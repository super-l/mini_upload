package cn.nepenthes.miniupload.service.impl;

import cn.nepenthes.miniupload.entity.ImageDataEntity;
import cn.nepenthes.miniupload.service.LocalImageUploadService;
import cn.nepenthes.miniupload.utils.BaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class LocalImageUploadServiceImpl implements LocalImageUploadService {

    private static List<String> allowedTypes = Arrays.asList("image/jpeg", "image/png", "image/gif");
    private static List<String> allowedSuffixs = Arrays.asList(".jpeg", ".jpg", ".png", ".gif");

    // 本地文件保存路径前缀(绝对路径)
    @Value("${local.savepath.prefix:/Users/superl/data/uploads}")
    private String savePathPrefix;

    // 本地文件访问URL前缀
    @Value("${local.url.prefix:http://file.nepenthes.cn}")
    private String urlPrefix;

    public ImageDataEntity upload(MultipartFile file, boolean isOriginal, String path, boolean createThum, String userName) throws Exception {
        ImageDataEntity imageFileDataEntity = new ImageDataEntity();

        //校验文件mime类型 是否为合法
        this.checkImageFileType(file);

        //校验文件内容-是否为图片
        this.checkImage(file);

        // 文件大小
        imageFileDataEntity.setImageSize(file.getSize());

        // 上传文件原始名称
        String origName = file.getOriginalFilename();

        // 获取后缀
        String suffix = this.getSuffix(origName);

        // 校验后缀合法性
        this.checkSuffix(suffix);

        // 保存的文件名
        String imageSaveName = !isOriginal ? String.format("%s%s", BaseUtil.getUUID32(), suffix):origName;

        String imagePathReal = "";        // 新图片保存的目录
        String imageThumPathReal = "";    // 新图片缩略图保存的目录
        String savePathDb = "";           // 数据库中保存的目录
        String imageUrl = "";             // 图片URL访问地址
        String imageThumUrl = "";         // 图片缩略图URL访问地址

        if (!"".equals(path)){
            imagePathReal = String.format("%s/%s/%s", savePathPrefix, userName, path);
            savePathDb = path;
            imageUrl = String.format("%s/%s/%s/%s", urlPrefix, userName, path, imageSaveName);
            if( createThum){
                imageThumPathReal =  String.format("%s/%s/%s/%s", savePathPrefix, userName, path, "thum");
                imageThumUrl = String.format("%s/%s/%s/%s/%s", urlPrefix, userName, path, "thum", imageSaveName);
            }
        }else{
            imagePathReal = String.format("%s/%s", savePathPrefix, userName);
            savePathDb = "";
            imageUrl = String.format("%s/%s/%s", urlPrefix, userName, imageSaveName);
            if( createThum){
                imageThumPathReal =  String.format("%s/%s/%s", savePathPrefix, userName, "thum");
                imageThumUrl = String.format("%s/%s/%s/%s", urlPrefix, userName, "thum", imageSaveName);
            }
        }

        // 如果图片保存目录不存在，则创建
        File imageParentPath = new File(imagePathReal);
        if (!imageParentPath.exists()) {
            imageParentPath.mkdirs();
        }

        // 创建缩略图目录
        if ( createThum){
            if ( !"".equals(imageThumPathReal)){
                File imageThumParentPath = new File(imageThumPathReal);
                if (!imageThumParentPath.exists()) {
                    imageThumParentPath.mkdirs();
                }
            }
        }

        // 新文件保存的绝对路径
        String saveImagePathReal = String.format("%s/%s", imagePathReal, imageSaveName);
        String saveImageThumPathReal = String.format("%s/%s", imageThumPathReal, imageSaveName);

        // 移动到指定文件
        File newfile = new File(saveImagePathReal);
        file.transferTo(newfile);

        // 生成缩略图并移动？？暂时不支持

        imageFileDataEntity.setImageName(imageSaveName);
        imageFileDataEntity.setImagePath(savePathDb);
        imageFileDataEntity.setMethod(1);
        imageFileDataEntity.setImageUrl(imageUrl);
        imageFileDataEntity.setImageThumUrl(imageThumUrl);
        imageFileDataEntity.setCreatedAt(new Date());
        return imageFileDataEntity;
    }

    /**
     * 校验文件类型
     * @param file
     * @return
     * @throws Exception
     */
    private boolean checkImageFileType(MultipartFile file) throws Exception {
        //校验文件mime类型 是否为合法
        String contentType = file.getContentType();
        if(!allowedTypes.contains(contentType)){
            throw new Exception("文件类型不匹配");
        }
        return true;
    }

    /**
     * 校验文件内容-是否为图片
     * @param file
     * @return
     * @throws Exception
     */
    private boolean checkImage(MultipartFile file) throws Exception {
        try {
            BufferedImage read = ImageIO.read(file.getInputStream());
        } catch (IOException e) {
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
