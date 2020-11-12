package cn.nepenthes.miniupload.service.impl;

import cn.nepenthes.miniupload.common.utils.PageUtils;
import cn.nepenthes.miniupload.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.nepenthes.miniupload.dao.UserDao;
import cn.nepenthes.miniupload.entity.UserEntity;
import cn.nepenthes.miniupload.service.UserService;


@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

}