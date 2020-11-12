package cn.nepenthes.miniupload.dao;

import cn.nepenthes.miniupload.entity.ImageDataEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 图片数据
 * 
 * @author Superl
 * @email superl@nepenthes.cn
 * @date 2020-11-12 12:57:21
 */
@Mapper
public interface ImageDataDao extends BaseMapper<ImageDataEntity> {
	
}
