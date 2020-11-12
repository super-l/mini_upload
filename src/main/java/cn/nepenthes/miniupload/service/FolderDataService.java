package cn.nepenthes.miniupload.service;

import cn.nepenthes.miniupload.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.nepenthes.miniupload.entity.FolderDataEntity;

import java.util.Map;

/**
 * 文件夹数据
 *
 * @author Superl
 * @email superl@nepenthes.cn
 * @date 2020-11-12 12:57:21
 */
public interface FolderDataService extends IService<FolderDataEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

