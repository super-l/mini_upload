package cn.nepenthes.miniupload.controller;

import cn.nepenthes.miniupload.annotation.UserLoginToken;
import cn.nepenthes.miniupload.bean.UploadImageResponseBean;
import cn.nepenthes.miniupload.entity.ImageDataEntity;
import cn.nepenthes.miniupload.entity.UserEntity;
import cn.nepenthes.miniupload.service.ImageDataService;
import cn.nepenthes.miniupload.service.LocalImageUploadService;
import cn.nepenthes.miniupload.service.UserService;
import cn.nepenthes.miniupload.utils.JwtUtil;
import cn.nepenthes.miniupload.utils.R;
import cn.nepenthes.miniupload.utils.SecurityUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 本地上传控制器
 *
 * @author  superl
 * @email   superl@nepenthes.cn
 * @blog    http://www.superl.org
 */
@RestController
@RequestMapping("local/image")
public class LocalImageUploadController {

    @Autowired
    private ImageDataService imageDataService;

    @Autowired
    private LocalImageUploadService localImageUploadService;

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(LocalImageUploadController.class);

    /**
     * 上传图片
     * @param token             令牌
     * @param isOriginal        是否保持源文件不变
     * @param path              是否带自定义目录
     * @param file              文件
     * @return
     */
    @UserLoginToken
    @RequestMapping(value="upload", method = RequestMethod.POST)
    public R uploadImage(
            @RequestHeader("Authorization") String token,
            @RequestParam(value = "is_original", required = false, defaultValue = "false") boolean isOriginal,
            @RequestParam(value = "path", required = false, defaultValue="") String path,
            @RequestParam(value = "auto_thum", required = false, defaultValue = "false") boolean autoThum,
            @RequestParam("file") MultipartFile file
    ){

        // 获取 token 中的 uuid
        String userName = JwtUtil.getUserName(token);
        UserEntity userEntity = userService.getOne(new QueryWrapper<UserEntity>().eq("username",userName));
        if ( userEntity == null) {
            return R.error(1000,"无权限操作!");
        }

        if ( userEntity.getStatus() == 0){
            return R.error(1000,"用户被禁用!");
        }

        // 判断是否为空
        if ( file.isEmpty()){
            return R.error(1000,"文件为空!");
        }

        if ( autoThum){
            return R.error(1000,"暂不支持生成缩略图功能!");
        }

        if (!SecurityUtil.isCommonStr(path)){
            return R.error(1000,"参数path规则:只允许数字/字母/下划线组合!");
        }

        try{
            ImageDataEntity imageFileEntity = localImageUploadService.upload(file, isOriginal, path, autoThum, userName);
            imageFileEntity.setUserId(userEntity.getId());
            logger.info(imageFileEntity.toString());
            boolean result = imageDataService.save(imageFileEntity);

            // 插入数据成功
            if ( result ){
                // 返回信息
                UploadImageResponseBean uploadImageResponseBean = new UploadImageResponseBean();
                uploadImageResponseBean.setImageName(imageFileEntity.getImageName());
                uploadImageResponseBean.setImagePath(imageFileEntity.getImagePath());
                uploadImageResponseBean.setImageSize(imageFileEntity.getImageSize());
                uploadImageResponseBean.setImageUrl(imageFileEntity.getImageUrl());
                uploadImageResponseBean.setImageThumUrl(imageFileEntity.getImageThumUrl());

                return R.ok().put("data", uploadImageResponseBean);
            }
            return R.error(1000,"系统繁忙,操作失败!");
        }catch (Exception e){
            return R.error(1000, e.getMessage());
        }

    }



}
