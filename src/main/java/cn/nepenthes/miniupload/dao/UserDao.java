package cn.nepenthes.miniupload.dao;

import cn.nepenthes.miniupload.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author Superl
 * @email superl@nepenthes.cn
 * @date 2020-11-12 12:57:21
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
