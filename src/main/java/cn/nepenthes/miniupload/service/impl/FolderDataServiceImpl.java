package cn.nepenthes.miniupload.service.impl;

import cn.nepenthes.miniupload.common.utils.PageUtils;
import cn.nepenthes.miniupload.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.nepenthes.miniupload.dao.FolderDataDao;
import cn.nepenthes.miniupload.entity.FolderDataEntity;
import cn.nepenthes.miniupload.service.FolderDataService;


@Service
public class FolderDataServiceImpl extends ServiceImpl<FolderDataDao, FolderDataEntity> implements FolderDataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FolderDataEntity> page = this.page(
                new Query<FolderDataEntity>().getPage(params),
                new QueryWrapper<FolderDataEntity>()
        );

        return new PageUtils(page);
    }

}