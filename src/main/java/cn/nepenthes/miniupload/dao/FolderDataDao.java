package cn.nepenthes.miniupload.dao;

import cn.nepenthes.miniupload.entity.FolderDataEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件夹数据
 * 
 * @author Superl
 * @email superl@nepenthes.cn
 * @date 2020-11-12 12:57:21
 */
@Mapper
public interface FolderDataDao extends BaseMapper<FolderDataEntity> {
	
}
