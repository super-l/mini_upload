package cn.nepenthes.miniupload.service.impl;

import cn.nepenthes.miniupload.common.utils.PageUtils;
import cn.nepenthes.miniupload.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.nepenthes.miniupload.dao.ImageDataDao;
import cn.nepenthes.miniupload.entity.ImageDataEntity;
import cn.nepenthes.miniupload.service.ImageDataService;


@Service
public class ImageDataServiceImpl extends ServiceImpl<ImageDataDao, ImageDataEntity> implements ImageDataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ImageDataEntity> page = this.page(
                new Query<ImageDataEntity>().getPage(params),
                new QueryWrapper<ImageDataEntity>()
        );

        return new PageUtils(page);
    }

}