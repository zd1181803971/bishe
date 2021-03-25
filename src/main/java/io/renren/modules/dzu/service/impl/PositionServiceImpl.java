package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.PositionDao;
import io.renren.modules.dzu.entity.PositionEntity;
import io.renren.modules.dzu.entity.form.DeptForm;
import io.renren.modules.dzu.entity.form.PositionForm;
import io.renren.modules.dzu.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("positionService")
public class PositionServiceImpl extends ServiceImpl<PositionDao, PositionEntity> implements PositionService {
    @Autowired
    PositionDao positionDao;

    @Override
    public PageUtils getPositionForm(Map<String, Object> params) {
        String name = null;
        if (params.get("name") != null && !params.get("name").equals("")) {
            name = params.get("name").toString();
        }
        IPage<DeptForm> page = new Query<DeptForm>().getPage(params);
        PageHelper.startPage((int) page.getCurrent(), (int) page.getSize());
        List<PositionForm> positionFormList = positionDao.getPositionFormList(name);
        PageInfo<PositionForm> positionFormPageInfo = new PageInfo<>(positionFormList);
        return new PageUtils(positionFormPageInfo.getList(),
                (int) positionFormPageInfo.getTotal(),
                positionFormPageInfo.getSize(),
                positionFormPageInfo.getPageNum());
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PositionEntity> page = this.page(
                new Query<PositionEntity>().getPage(params),
                new QueryWrapper<PositionEntity>()
        );

        return new PageUtils(page);
    }


}
