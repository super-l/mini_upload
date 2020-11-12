package cn.nepenthes.miniupload.service;

import cn.nepenthes.miniupload.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.nepenthes.miniupload.entity.UserEntity;

import java.util.Map;

/**
 * 
 *
 * @author Superl
 * @email superl@nepenthes.cn
 * @date 2020-11-12 12:57:21
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

