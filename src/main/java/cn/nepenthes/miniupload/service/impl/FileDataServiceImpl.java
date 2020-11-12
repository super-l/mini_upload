package cn.nepenthes.miniupload.service.impl;

import cn.nepenthes.miniupload.common.utils.PageUtils;
import cn.nepenthes.miniupload.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.nepenthes.miniupload.dao.FileDataDao;
import cn.nepenthes.miniupload.entity.FileDataEntity;
import cn.nepenthes.miniupload.service.FileDataService;


@Service
public class FileDataServiceImpl extends ServiceImpl<FileDataDao, FileDataEntity> implements FileDataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FileDataEntity> page = this.page(
                new Query<FileDataEntity>().getPage(params),
                new QueryWrapper<FileDataEntity>()
        );

        return new PageUtils(page);
    }

}